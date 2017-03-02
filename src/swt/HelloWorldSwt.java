package swt;


/**
 * Created by vingc on 2017/3/2.
 */
import org.eclipse.swt.widgets.*;

public class HelloWorldSwt {
    public static void main( String[] args ) {
        Display display = new Display();
        Shell shell = new Shell( display );
        shell.setText( "Hi there, SWT!" );
        shell.open();
        while( !shell.isDisposed() ) {
            if( !display.readAndDispatch() )
                display.sleep();
        }

        display.dispose();
    }
}
