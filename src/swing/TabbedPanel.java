package swing;

/**
 * Created by vingc on 2017/3/1.
 */
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.*;
import java.awt.*;
import java.lang.reflect.Constructor;

public class TabbedPanel extends JFrame {
    private String[] flavors = {
        "Chocolate", "Strawberry", "Mud Pie"
    };
    private JTabbedPane tabs = new JTabbedPane();
    private JTextField txt = new JTextField( 20 );
    public TabbedPanel() {
        int i = 0;
        for( String flavor: flavors ) {
            tabs.add( flavors[ i ], new JButton( "Tabbed pane " + i++ ) );
        }

        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                txt.setText( "Tab selected: " + tabs.getSelectedIndex() );
            }
        });

        add( BorderLayout.SOUTH, txt );
        add( tabs );
    }

    public static void main( String[] args ) {
        SwingConsole.run( new TabbedPanel(), 100, 250 );
    }
}
