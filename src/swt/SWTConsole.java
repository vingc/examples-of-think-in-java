package swt;

/**
 * Created by vingc on 2017/3/2.
 */
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Composite;

public class SWTConsole {
    public static void run( SWTApplication app, int width, int height ) {
        Display display = new Display();
        Shell shell = new Shell( display );
        shell.setText( app.getClass().getSimpleName() );
        app.createContents( shell );
        shell.open();

        while( !shell.isDisposed() ) {
            if( !display.readAndDispatch() ) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
