package swing;

/**
 * Created by vingc on 2017/3/1.
 */
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

public class Faces extends JFrame {
    private static Icon[] facesIcon;
    private JButton jb, jb2 = new JButton( "Dsiable" );
    private Boolean mad = false;

    public Faces() {
        facesIcon = new Icon[] {
                new ImageIcon( getClass().getResource( "face0.jpg" ) ),
                new ImageIcon( getClass().getResource( "face1.jpg" ) ),
                new ImageIcon( getClass().getResource( "face2.jpg" ) ),
                new ImageIcon( getClass().getResource( "face3.jpg" ) ),
                new ImageIcon( getClass().getResource( "face4.jpg" ) ),
        };

        jb = new JButton( "JButton", facesIcon[ 3 ] );
        setLayout( new FlowLayout() );
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( mad ) {
                    jb.setIcon( facesIcon[ 3 ] );
                    mad = false;
                } else {
                    jb.setIcon( facesIcon[ 0 ] );
                    mad = true;
                }
                jb.setVerticalAlignment( JButton.TOP );
                jb.setHorizontalAlignment( JButton.LEFT );
            }
        });

        jb.setRolloverEnabled( true );
        jb.setRolloverIcon( facesIcon[ 1 ] );
        jb.setPressedIcon( facesIcon[ 2 ] );
        jb.setDisabledIcon( facesIcon[ 4 ] );
        jb.setToolTipText( "a!yow!" );
        add( jb );

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( jb.isEnabled() ) {
                    jb.setEnabled( false );
                    jb2.setText( "Enable" );
                } else {
                    jb.setEnabled( true );
                    jb2.setText( "Disable" );
                }
            }
        });
        add( jb2 );
    }

    public static void main( String[] args ) {
        SwingConsole.run( new Faces(), 250, 125 );
        System.out.println(Faces.class.getResource(""));
        System.out.println(Faces.class.getResource("/"));
    }
}
