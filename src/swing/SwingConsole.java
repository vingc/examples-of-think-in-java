package swing;

import javax.swing.*;

/**
 * Created by vingc on 2017/1/19.
 */
public class SwingConsole {
    public static void run( final JFrame jf, final int width, final int height ) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jf.setTitle( jf.getClass().getSimpleName() );
                jf.setSize( width, height );
                jf.setVisible( true );
                jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            }
        });
    }
}
