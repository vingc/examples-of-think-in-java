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

public class HTMLButton extends JFrame {
    private JButton jb = new JButton( "<html><b><font size=+2>" + "<center>Hello!<br><i>Press me now!" );
    public HTMLButton() {
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add( new JLabel( "<html>" + "<i><font size=+4>Kapow!" ) );
                validate();
            }
        });
        setLayout( new FlowLayout() );
        add( jb );


    }

    public static void main( String[] args ) {
        SwingConsole.run( new HTMLButton(), 200,500 );
    }
}
