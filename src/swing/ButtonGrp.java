package swing;

import javax.swing.*;
import java.awt.*;
import swing.SwingConsole.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by vingc on 2017/1/19.
 */
public class ButtonGrp extends JFrame {
    private JButton b1 = new JButton( "Button 1" );
    private JButton b2 = new JButton( "Button 2" );
    private JTextField text = new JTextField( 10 );

    class ButtonListener implements ActionListener {
        public void actionPerformed( ActionEvent  ae ) {
            String name = ( (JButton) ae.getSource()).getText();
            text.setText( name );
        }
    }

    private ButtonListener bl = new ButtonListener();

    ButtonGrp() {
        b1.addActionListener( bl );
        b2.addActionListener( bl );
        setLayout( new FlowLayout() );
        add( b1 );
        add( b2 );
        add( text );
    }

    public static void main( String[] args ) {
        SwingConsole.run( new ButtonGrp(), 200, 100 );
    }
}
