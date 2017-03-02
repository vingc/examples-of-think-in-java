/**
 * Created by vingc on 2016/8/21.
 */
public class Constructor2 {
    Constructor2( int i, String j ){
        System.out.println("new Constructor!" + i);
    };

    Constructor2( String j, int i ){
        System.out.println("new Constructor!" + i);
    };


    public static void main ( String[] args ) {
        for( int i = 0; i < 10; i++ )
        {
            new Constructor2( i,"i" );
        }
    }
}
