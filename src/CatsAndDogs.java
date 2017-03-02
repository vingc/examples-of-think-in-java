import java.util.Vector;

/**
 * Created by vingc on 2016/9/3.
 */
class Cats {
    private int number = 0;
    Cats( int i ) {
        number = i;
    }
    private void desc() {
        System.out.println( "Cat # " + number );
    }

    public String toString() {
        return "Cat # " + number;
    }

    final int getNUmber(){ return number;}
}

class BlueCats extends Cats {
    BlueCats( int i ) {
        super( i );
    }
    void desc() {
        System.out.println("BlueCats # "+super.getNUmber());
    };

}
class Dogs {
    private int number = 0;
    Dogs( int i ) {
        number = i;
    }

    void desc() {
        System.out.println( "Dog # " + number );
    }
    public String toString() {
        return "Dog # " + number;
    }
}

public class CatsAndDogs {
    public static void main( String[] args ) {
        Vector cats = new Vector();
        for ( int i = 0; i < 7; i++ ) {
            cats.addElement( new Cats( i ) );
        }

        cats.addElement( new Dogs( 10 ) );

        for ( int j = 0; j < cats.size(); j++ ) {
            //( (Cats)cats.elementAt( j ) ).desc();
            cats.elementAt( j ).toString();
        }
    }
}
