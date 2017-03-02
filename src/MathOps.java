import java.util.*;

public class MathOps {
    static void prt( String s ) {
        System.out.println( s );
    }

    static void pInt( String s, int t ) {
        prt( s + " = " + t );
    }

    static void pFlt( String s, float t ) {
        prt ( s + " = " + t );
    }

    public static Boolean test1() {
        prt("test1");
        return true;
    }
    public static Boolean test2() {
        prt("test2");
        return false;
    }
    public static Boolean test4() {
        prt("test4");
        return true;
    }

    public static void main ( String[] args ) {
        //Create random generator
        //seeds is current time as default
        Random rand = new Random();
        int i, j, k;
        //i  = rand.getClass()
        //%limit the number of random less than 100
        j = rand.nextInt() % 99;
        k = rand.nextInt() % 99;
        pInt( "j", j );
        pInt( "k", k );

        pInt( "-j = ", -j );
        pInt( "+k = ", +k );
        i = -j;
        pInt( "+i = ", +i );
        pInt( "-i = ", -i );

        // int operation
        i = j + k;
        pInt( "j + k", i );
        i = j - k;
        pInt( "j - k", i );
        i = j / k;
        pInt( "j / k", i );
        i = j * k;
        pInt( "j * k", i );
        i = j % k;
        pInt( "j % k", i );
        j %= k;
        pInt( "j %= k", j );

        //float operation
        float u, v, w;
        v = rand.nextFloat();
        w = rand.nextFloat();
        pFlt( "v", v );
        pFlt( "w", w );

        u = v + w;
        pFlt( "v + w", u );
        u = v - w;
        pFlt( "v - w", u );
        u = v / w;
        pFlt( "v / w", u );
        u = v * w;
        pFlt( "v * w", u );
        v -= w;
        pFlt( "v -= w", v );
        v += w;
        pFlt( "v += w", v );
        v *= w;
        pFlt( "v *= w", v );

        prt("j > k is " + (j > k) );
        prt("j < k is " + (j < k) );
        prt("j <= k is " + (j <= k) );
        prt("j >= k is " + (j >= k) );

        //prt("j && k is " + (j && k) );
        //prt("j || k is " + (j || k) );
        //prt("!k is " + (!k) );

        if ( test1() || test2() && test4() )
        {
            prt( "test return true ");
        }
        else {
            prt("test return false");
        }

        Boolean c,d;
        c = true;
        d = false;
        prt("c^d = " + ( c^d ));
        prt("c&d = " + ( c&d ));
        prt("c|d = " + ( c|d ));

    }
}