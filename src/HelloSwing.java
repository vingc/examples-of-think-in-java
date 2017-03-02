import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by vingc on 2017/1/19.
 */
public class HelloSwing {
    public static void main( String[] args ) throws InterruptedException {
        JFrame jf = new JFrame( "Hello Swing" );
        JLabel jl = new JLabel( "This is Lable!" );
        JLabel jl2 = new JLabel( "This is Lable2!" );

        jf.add(jl);
        jf.add(jl2);
        jf.setSize( 600, 200 );
        jf.setVisible( true );
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        TimeUnit.SECONDS.sleep(2);
        //jl.setText( "Hi! This is different!" );
        SwingUtilities.invokeLater( new Runnable(){
            public void run() {
                jl.setText( "hi, different!" );
            }
        });
        //TimeUnit.SECONDS.sleep(2);
    }
}
