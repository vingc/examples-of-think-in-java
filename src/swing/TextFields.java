package swing;

/**
 * Created by vingc on 2017/3/1.
 */
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

public class TextFields extends JFrame {

    private JButton jGetText = new JButton( "GetText" ),
                    jSetText = new JButton( "SetText" );
    private JTextField  jt1  = new JTextField( 30 ),
                        jt2  = new JTextField( 30 ),
                        jt3  = new JTextField( 30 );
    private String  strSelected = null;
    private UpperCaseDocument ucd = new UpperCaseDocument();
    public TextFields() {
        jt1.setDocument( ucd );
        ucd.addDocumentListener( new T1() );
        jGetText.addActionListener( new B1() );
        jSetText.addActionListener( new B2() );
        jt1.addActionListener( new T1A() );
        setLayout( new FlowLayout() );

        add( jGetText );
        add( jSetText );
        add( jt1 );
        add( jt2 );
        add( jt3 );
    }

    class T1 implements DocumentListener {
        public void changedUpdate( DocumentEvent e ) {}
        public void insertUpdate( DocumentEvent e ) {
            jt2.setText( jt1.getText() );
            jt3.setText( "Text: " + jt1.getText() );
        }
        public void removeUpdate( DocumentEvent e ) {
            jt2.setText( jt1.getText() );
        }
    }

    class T1A implements ActionListener {
        private int count = 0;
        public void actionPerformed( ActionEvent e ) {
            jt3.setText( "jt1 Action event " + count++ );
        }
    }

    class B1 implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            if( jt1.getSelectedText() == null ) {
                strSelected = jt1.getText();
            } else {
                strSelected = jt1.getSelectedText();
            }
//            jt1.setEnabled( true );
            jt1.setEditable( true );
        }
    }

    class B2 implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
//            ucd.setUpperCase( false );
            jt1.setText( "insert by buttion 2: " + strSelected );
//            ucd.setUpperCase( true );
//            jt1.setEnabled( false );
            jt1.setEditable( false );
        }
    }

    public static void main( String[] args ) {
        SwingConsole.run( new TextFields(), 375, 200 );
    }

    class UpperCaseDocument extends PlainDocument {
        private boolean upperCase = false;
        public void setUpperCase( boolean flag ) {
            upperCase = flag;
        }
        public void insertString(int offset, String str, AttributeSet set ) throws BadLocationException {
//            if( upperCase ) {
//                str = str.toUpperCase();
//            }

            super.insertString( offset, str, set );
        }
    }
}
