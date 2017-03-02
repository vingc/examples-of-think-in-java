import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by vingc on 2016/12/24.
 */

class SleepLong {
    public static void block () throws InterruptedException {
        TimeUnit.SECONDS.sleep( 10 );
    }
}

class SleepTask2 implements Runnable {

    public void run() {
        try{
            SleepLong.block();
        }catch( InterruptedException e ) {
            System.out.println( "SleepTask2: " + e );
        }
        System.out.println( "Exiting from " + Thread.currentThread() );
    }
}

class ThrowInterupt {
    ThrowInterupt() {
        System.out.println( "create ThrowInterupt..." );
        try {
            try {
                throw new InterruptedException("test");
            } finally {
                System.out.println("finally");
            }
        }catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
public class InterruptTest {
    public static void main(String[] args) {
        /*ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> future = exec.submit( new SleepTask2() );
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        }catch(InterruptedException e ) {
            System.out.println( "main " + e );
        }

        future.cancel( true );*/

        new ThrowInterupt();
    }
}
