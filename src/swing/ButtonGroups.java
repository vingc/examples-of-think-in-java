package swing;

/**
 * Created by vingc on 2017/3/1.
 */
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import java.awt.*;
import java.lang.reflect.Constructor;


public class ButtonGroups extends JFrame {
    private static String[] ids = new String[] {
        "June", "Ward", "Beaver", "Wally", "Eddie", "Lumpy"
    };

    static JPanel makeBPanel( Class< ? extends AbstractButton > kind, String[] ids ) {
        ButtonGroup bg = new ButtonGroup();
        JPanel jp = new JPanel();
        String title = kind.getSimpleName();
//        System.out.println( "simpleName " + title  );
        title = title.substring( title.lastIndexOf( '.' ) + 1 );
        jp.setBorder( new TitledBorder( title ) );

        for( String id: ids ) {
            AbstractButton ab = new JButton( "Failed" );
            try {
                Constructor cons = kind.getConstructor( String.class );
                ab = (AbstractButton)cons.newInstance( id );
            } catch( Exception e ) {
                System.out.println( "failed to create" + kind  );
            }

            jp.add( ab );
            bg.add( ab );
        }
        return jp;
    }

    public ButtonGroups() {
        setLayout( new FlowLayout() );
        add( makeBPanel( JButton.class, ids ) );
        add( makeBPanel( JToggleButton.class, ids ) );
        add( makeBPanel( JCheckBox.class, ids ) );
        add( makeBPanel( JRadioButton.class, ids ) );
    }

    public static void main( String[] args ) {
        SwingConsole.run( new ButtonGroups(), 600, 500 );
    }
}
