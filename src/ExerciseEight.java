import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by vingc on 2016/9/7.
 */
class Gerbil2 {
    private int  gerbilNumber;
    String name;


    Gerbil2( int x, String y ) { gerbilNumber = x;  name = y; }

    void hop() { System.out.println("Hop():" + gerbilNumber +" "+ name ); }

}

public class ExerciseEight {
    public static void main( String[] args ) {
        Vector vG = new Vector();
        for ( int i = 0; i < 10; i++ ){
            vG.add( new Gerbil2( i, Array1.randString( 4 ) ) );
        }
/*
        for ( int j = 0; j < vG.size(); j++ ) {
            ((Gerbil2)vG.elementAt( j )).hop();
        }
        Enumeration e = vG.elements();

        while( e.hasMoreElements() ) {
            ((Gerbil2)e.nextElement()).hop();
        }
*/
/*
        //public static void main(String[] args)
       {
            Hashtable  aa = new Hashtable();
            for(char c = 'a'; c <= 'z'; c++)
                aa.put(String.valueOf(c),
                        String.valueOf(c)
                                .toUpperCase());
            char[] ca = { 'a', 'e', 'i', 'o', 'u' };
            for(int i = 0; i < ca.length; i++)
                System.out.println("Uppercase: " +
                        aa.get(String.valueOf(ca[i])));
        }
*/
        {
            Hashtable ht = new Hashtable();

            for ( int i = 0; i < 10; i++ ) {
                Gerbil2 g2 = new Gerbil2( i, Array1.randString( 4 ) );
                ht.put( g2.name, g2  );
            }

            Enumeration e = ht.keys();
            while( e.hasMoreElements() ) {
                Gerbil2 g3 = (Gerbil2)ht.get( e.nextElement() );
                g3.hop();
            }
        }
    }
}
