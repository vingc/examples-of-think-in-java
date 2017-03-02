/**
 * Created by vingc on 2016/8/23.
 */

public class ExerciseFour {
    ExerciseFour() {
        System.out.println( "run ExerciseFour()..." );
    }
    ExerciseFour( String s ) {
        System.out.println( s + " run ExerciseFour()..." );
    }

    protected  void finalize() {
        System.out.print("run finalize()");
    }

    public static void main( String[] args ) {
        //ExerciseFour exF = new ExerciseFour("main");
        ExerciseFour[] arr;
        ExerciseFour[] arr2 = new ExerciseFour[] {
                new ExerciseFour("1"), new ExerciseFour("2")
        };

        if ( args.length < 1 ) {
            System.out.println("Usage: java ExerciseFour [before|after|none]");
            return;
        }

        if ( args[0].equals("before") ) {
            System.out.print( args[0] );
            System.gc();
            System.runFinalization();
        }
        else if ( args[0].equals("after") ) {
            System.out.println( args[0] );
            System.runFinalization();
            System.gc();
        }
        else if ( args[0].equals("none") ) {
            //do nothing
        }

        int[] slArray = new int[10];
        return;
    }
}
