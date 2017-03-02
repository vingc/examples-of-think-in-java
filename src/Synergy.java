import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by vingc on 2016/12/25.
 */
class WaitSynergy implements Runnable{

    public void run()  {
        try {
            System.out.println( " Begin Waiting..." );
            waits();
            System.out.println( " End Waiting..." );
        }catch( InterruptedException e ) {
            System.out.println( this + ": " + e );
        }

        System.out.println(" exit WaitSynergy..." );
    }

    public synchronized void waits() throws InterruptedException {
        wait();
    }
}
public class Synergy implements Runnable{
    private WaitSynergy ws = null;

    public Synergy( WaitSynergy ws ) {
        this.ws = ws;
    }

    public void run() {
        try {
            System.out.println( " sleeping..." );
            TimeUnit.MILLISECONDS.sleep(100 );
        } catch ( InterruptedException e ) {
            System.out.println( this + ": " + e );
        }
        synchronized ( ws ) {
            ws.notifyAll();
        }

        System.out.println(" exit Synergy..." );
    }

    public static void main( String[] args ) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        WaitSynergy ws  = new WaitSynergy();
        exec.execute( ws );
        exec.execute( new Synergy( ws ) );

        TimeUnit.MILLISECONDS.sleep( 1000 );
        exec.shutdownNow();
    }
}

//---------------------------------------------------------------------------------------------------

class CondWait implements Runnable {
//    public static Boolean
    public void run() {
        while( true ) {
            try {
                TimeUnit.MILLISECONDS.sleep( 100 );
                BusyWait.flag = true;
            }catch( InterruptedException e ) {
                System.out.println( this + ": " + e );
            }
        }

//        System.out.println( "exiting.." + Thread.currentThread().isInterrupted() );
    }
}

class BusyWait implements Runnable {
    public static Boolean flag = false;
    public void run() {
        while( true ) {
            if ( BusyWait.flag ) {
                BusyWait.flag = false;
            }
        }

//        System.out.println( "exiting.." + Thread.currentThread().isInterrupted() );
    }

    public static void main ( String[] args ) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute( new CondWait() );
        exec.execute( new BusyWait() );

        TimeUnit.SECONDS.sleep( 10 );
        exec.shutdownNow();
    }
}
