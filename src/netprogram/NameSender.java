package netprogram;

/**
 * Created by vingc on 2017/3/3.
 */
//: NameSender.java
// An applet that sends an email address
// as a datagram, using Java 1.02.
import java.awt.*;
import java.applet.*;
import java.net.*;
import java.io.*;

public class NameSender extends Applet implements Runnable {
    private Thread pl = null;
    private Button send = new Button( "Add email address to mailing list" );
    private TextField emailAddr = new TextField( "type your email address here", 40 );
    private String str = new String();
    private Label  sendTips = new Label(), resultTips = new Label();
    private DatagramSocket s;
    private InetAddress hostAddress;
    private byte[] buf = new byte[ NameCollector.BUFFER_SIZE ];
    private DatagramPacket dp = new DatagramPacket( buf, buf.length );
    private int vcount = 0;

    public void init() {
        setLayout( new BorderLayout() );
        Panel p = new Panel();
        p.setLayout( new GridLayout( 2, 1 ) );
        p.add( emailAddr );
        p.add( send );
        add( "North", p );

        Panel labels = new Panel();
        labels.setLayout( new GridLayout( 2, 1 ) );
        labels.add( sendTips );
        labels.add( resultTips );
        add( "Center", labels );

        try {
            // Auto-assign port number:
            s = new DatagramSocket();
            hostAddress = InetAddress.getByName( getCodeBase().getHost() );
            System.out.println( "host:" + hostAddress );
        } catch( UnknownHostException e ) {
            sendTips.setText( "Cannot find host" );
        } catch( SocketException e ) {
            sendTips.setText( "Can't open socket" );
        }

        sendTips.setText( "Ready to send your email address" );
    }

    public boolean action ( Event evt, Object arg ) {
        if( !evt.target.equals( send ) ) {
            return super.action(evt, arg);
        } else {
            if( pl != null ) {
                // pl.stop(); Deprecated in Java 1.2
                Thread remove = pl;
                pl = null;
                remove.interrupt();
            }

            resultTips.setText("");
            // Check for errors in email name:
            str = emailAddr.getText().toLowerCase().trim();
            if( str.indexOf(' ') != -1 ) {
                sendTips.setText( "Spaces not allowed in name" );
                return true;
            }

            if( str.indexOf(',') != -1 ) {
                sendTips.setText( "Commas not allowed in name" );
                return true;
            }

            if( str.indexOf('@') == -1 ) {
                sendTips.setText( "Name must include '@'" );
                resultTips.setText("");
                return true;
            }
            if( str.indexOf('@') == 0 ) {
                sendTips.setText( "Name must preceed '@'" );
                resultTips.setText("");
                return true;
            }

            String end = str.substring( str.indexOf('@') );
            if( end.indexOf('.') == -1 ) {
                sendTips.setText( "Portion after '@' must " + "have an extension, such as '.com'" );
                resultTips.setText("");
                return true;
            }

            // Everything's OK, so send the name. Get a
            // fresh buffer, so it's zeroed. For some
            // reason you must use a fixed size rather
            // than calculating the size dynamically:
            byte[] sbuf = str.getBytes();
            DatagramPacket toSend = new DatagramPacket( sbuf, sbuf.length, hostAddress, NameCollector.COLLECTOR_PORT );
            try {
                s.send( toSend );
            } catch( Exception e ) {
                sendTips.setText( "Couldn't send datagram" );
                return true;
            }
            sendTips.setText( "Sent: " + str );
            send.setLabel( "Re-send" );
            pl = new Thread(this);
            pl.start();
            resultTips.setText( "Waiting for verification " + ++vcount );
        }

        return true;
    }

    // The thread portion of the applet watches for
    // the reply to come back from the server:
    public void run() {
        try {
            s.receive( dp );
        } catch(Exception e) {
            resultTips.setText( "Couldn't receive datagram" );
            return;
        }
        resultTips.setText( dp.getData().toString() );
    }
} ///:~