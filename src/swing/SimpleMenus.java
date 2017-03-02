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

public class SimpleMenus extends JFrame {
    private JMenuBar jmb = new JMenuBar();
    private JMenu    jm  = new JMenu( "File" );

    public SimpleMenus() {
        jm.add( new JMenuItem( "save" ) );
        jm.add( new JMenuItem( "open" ) );
        jm.addSeparator();
        jm.add( new JCheckBoxMenuItem( "ok" ) );
        jm.add( new JRadioButtonMenuItem( "ok" ) );
        jmb.add( jm );
        setJMenuBar( jmb );
        setLayout( new FlowLayout() );
    }

    public static void main( String[] args ) {
        SwingConsole.run( new SimpleMenus(), 200, 300 );
    }
}
