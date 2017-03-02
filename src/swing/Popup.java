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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;

public class Popup extends JFrame {
    private JPopupMenu jpopup = new JPopupMenu();
    private JTextField jtext = new JTextField( 30 );

    class MenuListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            jtext.setText( ( (JMenuItem)e.getSource() ).getText() );
        }
    }

    class PopupMouseListener extends MouseAdapter {

         public void mousePressed( MouseEvent e ) {
             maybeShowPopup( e );
         }
         public void mouseReleased( MouseEvent e ) {
             maybeShowPopup( e );
         }
         public void maybeShowPopup( MouseEvent e ) {
             jpopup.show( e.getComponent(), e.getX(), e.getY() );
         }
    }

    public Popup() {
        setLayout( new FlowLayout() );
        add( jtext );

        JMenuItem jmi = new JMenuItem( "save" );
        jmi.addActionListener( new MenuListener() );
        jpopup.add( jmi );

        jmi = new JMenuItem( "open" );
        jmi.addActionListener( new MenuListener() );
        jpopup.add( jmi );

        PopupMouseListener pml = new PopupMouseListener();
        addMouseListener( pml );
        jtext.addMouseListener( pml );
    }

    public static void main( String[] args ) {
        SwingConsole.run( new Popup(), 400, 500 );
    }
}
