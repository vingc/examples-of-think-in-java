package swing;

/**
 * Created by vingc on 2017/2/28.
 */

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import java.awt.*;


public class Buttons extends JFrame {
    private JButton  jb = new JButton( "JButton" );
    private BasicArrowButton
            up = new BasicArrowButton( BasicArrowButton.NORTH ),
            down = new BasicArrowButton( BasicArrowButton.SOUTH ),
            left = new BasicArrowButton( BasicArrowButton.WEST ),
            right = new BasicArrowButton( BasicArrowButton.EAST );

    public Buttons() {
        setLayout( new FlowLayout() );
        add( jb );
        add( new JToggleButton( "ToggleButton" ) );
        add( new JCheckBox( "CheckBox" ) );
        add( new JRadioButton( "RadioButton" ) );
        JPanel jp = new JPanel();
        jp.setBorder( new TitledBorder( "Directions" ) );
//        jp.setBounds( 200, 100,200,100 );
        jp.add( up );
        jp.add( down );
        jp.add( left );
        jp.add( right );
        add( jp );
    }

    public static void main( String[] args ) {
        SwingConsole.run( new Buttons(), 400, 500 );
    }
}
