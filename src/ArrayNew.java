/**
 * Created by vingc on 2016/8/23.
 */
import java.util.*;

class a { int i; }

public class ArrayNew {
    static Random rand = new Random();
    static int pRandom(int mod) {
        return Math.abs(rand.nextInt()) % mod + 1;
    }

    static void prt( String s ) {
        System.out.println( s );
    }

    static void f( Object[] x ) {
        for ( int i = 0; i < x.length; i++ ) {
            System.out.println(x[i]);
        }
    }

    public static void main ( String[] args ) {
        int[] a = new int[pRandom(20)];
        prt( "length of array a is "+a.length );
        for ( int i = 0; i < a.length; i++ ) {
            prt("a["+i+"] = "+a[i]);
        }

        Integer[] b = new Integer[pRandom(10)];

        prt( "length of array b is "+b.length );
        for ( int i = 0; i < b.length; i++ ) {
            b[i] = new Integer(pRandom(200));
            prt("b["+i+"] = "+b[i]);
        }

        Integer[] c = { new Integer(1), new Integer(2), new Integer(3) };
        Integer[] d = new Integer[] { new Integer(1), new Integer(2), };

        f(new Object[]{ new Integer(1), new Float(2.1), new Object()});
        f( new Object[]{ new a(), new a(), new a(),});
    }
}
