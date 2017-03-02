import java.util.ArrayList;
import java.util.concurrent.*;
//import java.util.concurrent.Executor;


/**
 * Created by vingc on 2016/12/13.
 */

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult( int id ) {
        this.id = id;
    }

    public String call() {
        return "TaskWithResult " + id;
    }

}

public class CallableDemo {
    public static void main( String[] args ) {
        ExecutorService bigExec= Executors.newCachedThreadPool();
        ArrayList<Future<String>> aL = new ArrayList<>();
        for( int i = 0; i < 5; i++ ) {
            aL.add( bigExec.submit( new TaskWithResult( i ) ) );
        }

        for( Future<String> fs: aL ) {
            try{
                //get will be blocked until completion
                System.out.println( fs.get() );
            }catch( InterruptedException e ) {
                System.out.println( e );
                return;
            }catch( ExecutionException e ) {
                System.out.println( e );
                return;
            }finally {
                bigExec.shutdown();
            }
        }
    }
}
