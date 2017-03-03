package netprogram;

/**
 * Created by vingc on 2017/3/3.
 */
import java.net.*;

public class WhoAmI {
    public static void main( String[] args ) {
        if( args.length < 1 ) {
            System.err.println( "Usage: java WhoAmi myMachineName" );
            System.exit( 1 );
        }

        try {
            InetAddress netAddr = InetAddress.getByName( args[ 0 ] );
            System.out.println( netAddr );
            netAddr = InetAddress.getByName(null);
            System.out.println( netAddr );
            netAddr = InetAddress.getByName( "127.0.0.1" );
            System.out.println( netAddr );
            netAddr = InetAddress.getByName( "www.baidu.com" );
            System.out.println( netAddr );
            netAddr = InetAddress.getLocalHost();
            System.out.println( netAddr );
            netAddr = InetAddress.getLoopbackAddress();
            System.out.println( netAddr );
            InetAddress[] netAddrs = InetAddress.getAllByName("www.baidu.com");
            System.out.println( netAddrs );
        } catch ( UnknownHostException e ) {
            e.printStackTrace();
        }
    }
}
