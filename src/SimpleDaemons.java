import java.util.concurrent.TimeUnit;

/**
 * Created by vingc on 2016/12/14.
 */
public class SimpleDaemons implements Runnable {
    public void run() {
        try {
            while( true ) {
                TimeUnit.MILLISECONDS.sleep( 200 );
                System.out.println( Thread.currentThread() + ": " + this );
            }

        }catch( InterruptedException e ) {
            System.out.println( "sleep: " + e );
            return;
        }
    }

    public static void main( String[] args ) {
        for( int i = 0; i < 10; i++ ) {
            Thread daemon = new Thread( new SimpleDaemons() );
            daemon.setDaemon( true );
            daemon.start();
        }
        System.out.println( "All Daemons start..." );
        try {
            TimeUnit.MILLISECONDS.sleep(150 );
        }catch( InterruptedException e ) {
            ///do noting
        }

    }
}
