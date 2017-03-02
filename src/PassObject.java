/**
 * Created by vingc on 2016/8/16.
 */
class Letter {
    char c;
}
public class PassObject {
    static void f( Letter x )
    {
        x.c += 1;
        //return;
    }
    public static void main(String[] args) {
        Letter y = new Letter();
        y.c = 'a';
        System.out.println( "1. y.c=\'" + y.c + "\'");
        f( y );
        System.out.println( "2. y.c=\'" + y.c + "\'" );
        //return;

        Letter x = new Letter();
        Letter z = new Letter();
        System.out.println( x == y );
        System.out.println( x != y );
        System.out.println( x.equals( x ) );
        x.c = z.c = 'a';
        System.out.println( x.equals( z ) );
        System.out.println(x);
        System.out.println(z);

        Integer e = new Integer(12);
        Integer f = new Integer(12);
        System.out.println( e.equals( f ) );
        System.out.println(e);
        System.out.println(f);
    }
}
