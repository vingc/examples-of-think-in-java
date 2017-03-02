import java.util.Hashtable;

/**
 * Created by vingc on 2016/9/4.
 */
class Count {
    int i = 1;
    public String toString() {
        return Integer.toString( i );
    }
}
public class Statistics {
    public static void main( String[] args ) {
        Hashtable ht = new Hashtable();
        for ( int i = 0; i < 10000; i++ ) {
            Integer key =  new Integer((int)( Math.random()*20 ));
            if ( ht.containsKey( key ) ) {
                ((Count)ht.get( key )).i++;
            }
            else {
                ht.put( key, new Count() );
            }
        }
        System.out.println( ht );
    }
}
