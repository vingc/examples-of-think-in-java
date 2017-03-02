package swing;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by vingc on 2017/3/1.
 */
public class Progress extends JFrame {
    private JProgressBar pb = new JProgressBar();
    private ProgressMonitor pm = new ProgressMonitor( this, "Monitoring Progress", "Test", 0, 100 );
    private JSlider js = new JSlider( JSlider.HORIZONTAL, 0, 100, 60 );
    public Progress() {
        setLayout( new GridLayout( 2, 1 ) );
        add( pb );
        pm.setProgress( 0 );
        pm.setMillisToPopup( 1000 );
        js.setValue( 0 );
        js.setPaintTicks( true );
        js.setMajorTickSpacing( 20 );
        js.setMinorTickSpacing( 5 );
        js.setBorder( new TitledBorder( "Slide Me " ) );
        pb.setModel( js.getModel() );
        add( js );
        js.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                pm.setProgress( js.getValue() );
            }
        });
    }

    public static void main( String[] args ) {
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
        SwingConsole.run( new Progress(), 300, 200 );
    }

}
