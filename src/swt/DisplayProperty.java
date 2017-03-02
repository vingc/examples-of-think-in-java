package swt;

/**
 * Created by vingc on 2017/3/2.
 */
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

public class DisplayProperty implements SWTApplication {
    public void createContents( Composite parent ) {
        parent.setLayout( new FillLayout() );
        Text text = new Text( parent, SWT.WRAP | SWT.V_SCROLL );
        StringWriter props = new StringWriter();
        System.getProperties().list( new PrintWriter( props ) );
        text.setText( props.toString() );

        text.append("------------------------------------------------\n");
        Properties pert = System.getProperties();
        Set<String> keys = pert.stringPropertyNames();
        for( String key: keys ) {
            text.append( key + ": " + pert.getProperty( key ) + "\n" );
        }

        text.append("------------------------------------------------\n");
        Enumeration en = pert.propertyNames();
        while( en.hasMoreElements() ) {
            String key = (String)en.nextElement();
            text.append( key +  ": " + pert.getProperty( key ) + "\n" );
        }

    }

    public static void main( String[] args ) {
        SWTConsole.run( new DisplayProperty(), 800, 600 );
    }
}
