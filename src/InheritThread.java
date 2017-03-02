/**
 * Created by vingc on 2016/12/18.
 */
import java.util.concurrent.*;

// class i{}
 class InnerThread1 {
    private int countDown = 5;
    private Inner inner;
    private class Inner extends Thread {
        Inner ( String name ) {
            super( name );
            start();
        }

        public void run() {
            try{
                while( true ) {
                    System.out.println( this );
                    if( --countDown == 0 ) return;
                    sleep( 10 );
                }
            }catch ( InterruptedException e ) {
                System.out.println("sleep() break;");
            }
        }

        public String toString() {
            return getName()+":"+countDown +getClass().getName();
        }
    }

    public InnerThread1( String name ) {
        inner = new Inner( name );
    }
}

class InnerThread2 {
    private int countDown = 5;
    private Thread tH;

    public InnerThread2(String name) {
        tH = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("sleep() break;");
                }
            }

            public String toString() {
                return getName() + ":" + countDown + getClass().getName();
            }
        };
        tH.start();
    }
}

public class InheritThread {
    public static void main( String[] args ) {
        //new InnerThread1( "test1" );
        new InnerThread2( "test1" );

    }
}
