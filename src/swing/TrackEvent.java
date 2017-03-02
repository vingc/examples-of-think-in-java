package swing;

/**
 * Created by vingc on 2017/2/27.
 */

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TrackEvent extends JFrame {

    private HashMap<String, JTextField> hm = new HashMap<String, JTextField>();
    private String[] avt = {
            "focusGained", "focusLost", "keyPressed", "keyTyped",
            "keyReleased", "mouseClicked", "mouseEntered", "mouseExited",
            "mousePressed", "mouseReleased", "mouseDragged", "mouseMoved"
            };
    private MyButton
            MB1 = new MyButton( Color.BLUE, "test1" ),
            MB2 = new MyButton( Color.RED, "test2" );

    class MyButton extends JButton {

        void report( String field, String msg ) {
            hm.get( field ).setText( msg );
        }

        FocusListener fl = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                report( "focusGained", e.paramString() );
            }

            @Override
            public void focusLost(FocusEvent e) {
                report( "focusLost", e.paramString() );
            }
        };

        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                report( "keyTyped", e.paramString() );
            }

            @Override
            public void keyPressed(KeyEvent e) {
                report( "keyPressed", e.paramString() );
            }

            @Override
            public void keyReleased(KeyEvent e) {
                report( "keyReleased", e.paramString() );
            }
        };

        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                report( "mouseClicked", e.paramString() );
            }

            @Override
            public void mousePressed(MouseEvent e) {
                report( "mousePressed", e.paramString() );
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                report( "mouseReleased", e.paramString() );
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                report( "mouseEntered", e.paramString() );
            }

            @Override
            public void mouseExited(MouseEvent e) {
                report( "mouseExited", e.paramString() );
            }
        };

        MouseMotionListener mml = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                report( "mouseDragged", e.paramString() );
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                report( "mouseMoved", e.paramString() );
            }
        };

        public MyButton( Color col, String lable ) {
            super( lable );
            setBackground( col );
            addFocusListener( fl );
            addKeyListener( kl );
            addMouseListener( ml );
            addMouseMotionListener( mml );
        }
    }

    public TrackEvent() {
        setLayout( new GridLayout( avt.length + 1, 2 ) );
        for( String e: avt ) {
            JTextField jf = new JTextField();
            jf.setEnabled( false );
            add( new JLabel( e, JLabel.RIGHT ) );
            add( jf );
            hm.put( e, jf );
        }
        add( MB1 );
        add( MB2 );
    }

    public static void main( String[] args ) {
        SwingConsole.run( new TrackEvent(), 900, 800 );
//        int abc = 37;
//        if( "37".equals(abc) )
//        {
//            System.out.println("true");
//        }
//        else {
//            System.out.println("false");
//            if( abc=37 )
//            {
//
//                System.out.println("true");
//            }
//        }
    }
}
