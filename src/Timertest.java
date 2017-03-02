import c03.ObjComp;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by vingc on 2016/12/19.
 */
class TimerTaskTest extends TimerTask {
    private int count = 0;
    public TimerTaskTest( int cnt ) {
        count = cnt;
    }
    public void run() {
        System.out.println(" Timer-"+count+" end!" );
    }
}
public class Timertest {
    public static void main( String[] args ) {
        Timer time = new Timer();
        time.schedule( new TimerTaskTest(1), 1000,100 );

//        time = new Timer();
        time.schedule( new TimerTaskTest(2), 1000 );

//        time = new Timer();
        time.schedule( new TimerTaskTest(3), 1000 );
        time.cancel();

        System.out.println( String.format("%1$03d",4));
        System.out.println( Calendar.getInstance() );
        System.out.println( Integer.valueOf(10000) );
        int iii = new Integer(1000);
    }
}
