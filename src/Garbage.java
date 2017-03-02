/**
 * Created by vingc on 2016/8/22.
 */
class Chair {
    static Boolean isGcRun = false;
    static Boolean isStopCreate = false;
    static int createdChairs;
    static int finalizedChairs;

    int chairNum;

    Chair() {
        chairNum = ++createdChairs;
        if ( chairNum == 47 ) {
            System.out.println("Created "+chairNum+ " chairs!");
        }
    }

    protected  void finalize() {
        if ( isGcRun == false ) {
            isGcRun = true;
            System.out.println("Beginning finalizing chairs..."+"created " +createdChairs+" chairs");
        }

        if ( chairNum == 47 ) {
            System.out.println("Stop creating chairs..." + "created "+createdChairs+" charis");
            isStopCreate = true;
        }

        finalizedChairs++;
        if( finalizedChairs >= createdChairs ) {
            System.out.println("All chairs "+finalizedChairs+" have been finalized");
        }

    }
}
public class Garbage {

    public static void main(String[] args) {
        if ( args.length == 0 ) {
            System.out.println("Usage:\n"+
            "java Garbage [Before|After]");
            return;
        }

        while( !Chair.isStopCreate ) {
            new Chair();
            new String("To take memory space......................................");
        }

        System.out.println("After all chairs have been created!\n"+
        "Total created "+Chair.createdChairs+"\n"+
        "Total finalized "+Chair.finalizedChairs);

        if ( args[0].equals("Before") ) {
            System.out.println("gc:");
            System.gc();
            System.out.println("run finalization:");
            System.runFinalization();
        }

        System.out.println("Byte!");

        if ( args[0].equals("After") ) {
            System.out.println("run finalization after exit");
            //System.runFinalizersOnExit();
        }
    }
}
