/**
 * Created by vingc on 2016/12/13.
 */
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

class SleepTask implements Runnable {
    private Random rand = new Random();
    private int time = rand.nextInt( 10 ) + 1; //1 -- 10;exclusive 10
    private int id;

    public SleepTask( int id ) { this.id = id; }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(time);
            System.out.println( " task " + id + " sleep " + time + "s" );
        }catch ( InterruptedException e ) {
            System.out.println( e );
        }
    }
}
public class SleepingTask {
    public static void main( String[] args ) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for( int i = 0; i < 10; i++ ) {
            exec.execute( new SleepTask( i ) );
        }

        exec.shutdown();
    }
}
