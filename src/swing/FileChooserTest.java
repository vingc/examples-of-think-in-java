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

public class FileChooserTest extends JFrame {
    private JTextField fileName = new JTextField(),
                       dir = new JTextField();
    private JButton open = new JButton( "Open" );
    private JButton save = new JButton( "Save" );
    private JButton color = new JButton( "Color" );

    public FileChooserTest() {
        JPanel p = new JPanel();
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                int rVal = jfc.showOpenDialog(FileChooserTest.this );
                if ( rVal == JFileChooser.APPROVE_OPTION ) {
                    fileName.setText( jfc.getSelectedFile().getName() );
                    dir.setText( jfc.getCurrentDirectory().toString() );
                } else if ( rVal == JFileChooser.CANCEL_OPTION ) {
                    fileName.setText( " canceled " );
                    dir.setText( "" );
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                int rVal = jfc.showSaveDialog(FileChooserTest.this );
                if ( rVal == JFileChooser.APPROVE_OPTION ) {
                    fileName.setText( jfc.getSelectedFile().getName() );
                    dir.setText( jfc.getCurrentDirectory().toString() );
                } else if ( rVal == JFileChooser.CANCEL_OPTION ) {
                    fileName.setText( " canceled " );
                    dir.setText( "" );
                }
            }
        });

        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser jcc = new JColorChooser();
                Color col = jcc.showDialog( FileChooserTest.this, "GetColor", Color.RED );
                System.out.println( "col: " + col );
                dir.setText( " col: " + col.toString() );
            }
        });

        p.add( open );
        p.add( save );
        p.add( color );
        add( p, BorderLayout.SOUTH );
        dir.setEditable( false );
        fileName.setEditable( false );
        p = new JPanel();
        p.setLayout( new GridLayout( 2, 1 ) );
        p.add( fileName );
        p.add( dir );
        add( p, BorderLayout.NORTH );


    }

    public static void main( String[] args ) {
        SwingConsole.run( new FileChooserTest(), 250, 150 );
    }
}
