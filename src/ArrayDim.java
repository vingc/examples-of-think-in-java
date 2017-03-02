/**
 * Created by vingc on 2016/8/23.
 */
import java.util.*;

public class ArrayDim {
    static Random rand = new Random();
    static int pRandom(int mod) {
        return Math.abs(rand.nextInt()) % mod + 1;
    }

    static void prt( String s ) {
        System.out.println( s );
    }
    public static void main( String[] args ) {

        //2-D initialized when declare
        int[][] a = {
                {1,2,3},
                {4,5,6}
        };

        for( int i = 0; i < a.length; i++ )
            for( int j = 0; j < a[i].length; j++ ) {
             prt("a["+i+"]["+j+"] = "+a[i][j]);
            }

        prt("\n");
        //3-D another initialization
        int[][][] b = new int[1][2][3];
        for( int i = 0; i < b.length; i++ )
            for( int j = 0; j < b[i].length; j++ )
                for( int k = 0; k < b[i][j].length; k++ ) {
                prt("b["+i+"]["+j+"]["+k+"] = "+b[i][j][k]);
            }

        //3-D varied-length
        int[][][] c = new int[pRandom(5)][][];
        for( int i = 0; i < c.length; i++ ) {
            c[i] = new int[pRandom(6)][];
            for( int j = 0; j < c[i].length; j++ ) {
                c[i][j] = new int[pRandom(7)];
            }
        }
        prt("\n");
        for( int i = 0; i < c.length; i++ )
            for( int j = 0; j < c[i].length; j++ )
                for( int k = 0; k < c[i][j].length; k++ ) {
                    prt("c["+i+"]["+j+"]["+k+"] = "+c[i][j][k]);
                }

    }
}
