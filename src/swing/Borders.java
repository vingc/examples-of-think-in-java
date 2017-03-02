package swing;

/**
 * Created by vingc on 2017/3/1.
 */
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import java.awt.*;
import java.lang.reflect.Constructor;

public class Borders extends JFrame {
    static JPanel showBorder( Border borderObj ) {
        JPanel jp = new JPanel();
        jp.setLayout( new BorderLayout() );
        String nm = borderObj.getClass().toString();
        nm = nm.substring( nm.lastIndexOf( '.' ) + 1 );
        jp.add( new JLabel( nm, JLabel.CENTER ), BorderLayout.CENTER );
        jp.setBorder( borderObj );
        return jp;
    }

    public Borders() {
        setLayout( new GridLayout( 2, 4 ) );
        add( showBorder( new TitledBorder( "Title" ) ) );
        add( showBorder( new EtchedBorder() ) );
        add( showBorder( new LineBorder( Color.blue ) ) );
        add( showBorder( new MatteBorder( 5, 5, 30, 30, Color.GREEN ) ) );
        add( showBorder( new BevelBorder( BevelBorder.LOWERED ) ) );
        add( showBorder( new CompoundBorder( new EtchedBorder(), new LineBorder( Color.RED ) ) ) );
    }

    public static void main( String[] args ) {
        SwingConsole.run( new Borders(), 500, 300 );
    }
}
