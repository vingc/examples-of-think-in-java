import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vingc on 2016/12/18.
 */
class ConflictTest1 {
    private int count1 = 0;
    private double count2 = 0;

    public synchronized int increCount1() { count1++; return count1; }
    public double increCount2() { count2++; return count2; }
}

class MutileTask1 implements Runnable {
    private ConflictTest1 confT1;
    private int count;
    public MutileTask1( ConflictTest1 confT1 ) {
        this.confT1 = confT1;
    }

    public void run() {
        while( true ) {
            count = confT1.increCount1();
            if ( count > 5 ) {
                System.out.println( this+": "+count );
                return;
            }
        }
    }
}

public class SynchronizedTest1 {
    public static void main( String[] args ) {
        ConflictTest1 conf = new ConflictTest1();
        ExecutorService exec = Executors.newCachedThreadPool();
        for ( int i = 0; i < 15; i++ ) {
            exec.execute( new MutileTask1( conf ) );
        }
    }
}
