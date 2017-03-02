/**
 * Created by vingc on 2016/8/26.
 */
class Game {
    private Game(){}
    Game( int i ) {
        this(i,2);
        System.out.println( "Game constructor" );
    }

    Game( int i, int j ) {
        System.out.print( "Game(int,int)\n" );
    }

    int i = 1;
}

class BoardGame extends Game {
    BoardGame( int i ) {
        super( i );
        System.out.println( "BoardGame constructor" );
        yest(4);
    }
   //final
    private  void yest(int j){
        System.out.println( "BoardGame.yest() j="+j );
    }

    int j = super.i+1;
    int i = 3;
}

public class Chess extends BoardGame {
    Chess( int i ) {
        super( i );
        System.out.println( "Chess constructor" );
    }

    void yest( int j ){
        System.out.println( "Chess.yest() j="+j );
        //return j++;
    }

    public static void main( String[] args ) {
        Chess x = new Chess( 1 );
        System.out.println("j="+x.j+" i="+x.i);
        x.yest(3);
    }
}
