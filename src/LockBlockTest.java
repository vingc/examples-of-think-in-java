import c03.ObjComp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vingc on 2016/12/20.
 */
class BlockTest {
    private Object  obj1 = new Object();
    private Object  obj2 = new Object();
    private Object  obj3 = new Object();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();
    public void f1() {
        lock1.lock();
        {
            System.out.println("f1: " + Thread.currentThread());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
//            ...
            }
        }
        lock1.unlock();
    }
    public  void f2() {
        lock1.lock();
        {
            System.out.println("f2: " + Thread.currentThread());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
//            ...
            }
        }
        lock1.unlock();
    }
    public synchronized void f3() {
        lock1.lock();
        {
            System.out.println("f3: " + Thread.currentThread());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
//            ...
            }
        }
        lock1.unlock();
    }
}


public class LockBlockTest {
    public static void main( String[] args ) {
        BlockTest  block = new BlockTest();
        new Thread() {
            public void run() {
                block.f1();
            }
        }.start();

        new Thread() {
            public void run() {
                block.f2();
            }
        }.start();

        new Thread() {
            public void run() {
                block.f3();
            }
        }.start();

        try{
            TimeUnit.SECONDS.sleep( 20 );
        }catch( InterruptedException e ) {
//            ...
        }
    }
}
