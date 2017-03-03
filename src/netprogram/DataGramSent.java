package netprogram;

/**
 * Created by vingc on 2017/3/3.
 */

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;
import java.net.*;

/* check the return value of getAddr() and getPort() before sent and after sent.*/
public class DataGramSent {

    public static void main( String[] args ) throws SocketException {
        DatagramSocket udpSocket = null;

        try {
            udpSocket = new DatagramSocket(9999);
        } catch ( SocketException e ) {
            System.err.println( "Can't open Udp socket on port 9999 " );
            throw e;
        }

        byte[] buf = new byte[ 10 ];

        try {
            DatagramPacket dp = new DatagramPacket( buf, buf.length, InetAddress.getLocalHost(), 9090 );
            System.out.println( "Before sent: " + dp.getAddress() + ": " + dp.getPort() );
            udpSocket.send( dp );
            System.out.println( "After sent: " + dp.getAddress() + ": " + dp.getPort() );

        } catch( UnknownHostException e ) {
            System.err.println( " can't find host " );
        } catch( IOException e ) {
            System.err.println( " sent fail " );
        }

    }
}
