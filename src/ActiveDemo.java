import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by vingc on 2017/1/2.
 */
public class ActiveDemo {
    ExecutorService exec = Executors.newSingleThreadExecutor();
    Random  rand = new Random( 100 );
    private void pause() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        }catch( InterruptedException e ) {
            //exit.....
        }
    }

    void calculateTime() {
         exec.submit( new Callable<Integer>() {
                public Integer call() {
                    long time = System.currentTimeMillis();
                    pause();
                    System.out.println("duration: " + (System.currentTimeMillis() - time));
                    return (int)time;
                }
            }
        );
    }

    public static void main( String[] args ) {
        new ActiveDemo().calculateTime();
    }
}
