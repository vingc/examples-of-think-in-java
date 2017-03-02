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

class MyDialog extends JDialog {
    public MyDialog( JFrame parent ) {
        super( parent, "My Dialog", true );
        setLayout( new FlowLayout() );
        add( new JLabel( "Here is my dialog!" ) );

        JButton ok = new JButton( "Ok" );
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // close the dialog
            }
        });
        add( ok );
        setSize( 150, 125 );

    }
}

public class Dialogs extends JFrame {
    private JButton showDialog = new JButton( "Show Dialog Box" );
    private MyDialog myDialog = new MyDialog( null );
    public Dialogs() {
        showDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDialog.setVisible( true );
            }
        });
        add( showDialog );
    }



    public static void main( String[] args ) {
        SwingConsole.run( new Dialogs(), 125, 75 );
    }
}
