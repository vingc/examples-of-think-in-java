/**
 * Created by vingc on 2016/12/18.
 */
import java.io.IOException;
import java.lang.*;

public class ResponsiveUI extends Thread {
    private static volatile double d;
    public ResponsiveUI() {
        setDaemon( true );
        start();
    }
    public void run() {
        while(true) {
            d = d+(Math.PI+Math.E)/2;
        }
    }

   public static void main( String[] args ) throws IOException {
        new ResponsiveUI();
        int x = System.in.read();
        System.out.println( d );
        System.out.println( "input:"+x );
   }
}
