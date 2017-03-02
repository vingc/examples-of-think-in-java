/**
 * Created by vingc on 2016/8/17.
 */
public class WhileTest {
    public static void main (String[] args) {
        double a = 0;

        System.out.println( "while" );
        while ( a < 0.99d )
        {
            a = Math.random();
            System.out.println( a );
        }

        System.out.println( "do...while" );
        do
        {
            a = Math.random();
            System.out.println( a );
        }
        while ( a < 0.99d );
    }
}
