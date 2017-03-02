package debug; /**
 * Created by vingc on 2016/8/28.
 *//**
 * Created by vingc on 2016/8/26.
 */
abstract class Instrument {
    static int i =1;
    public abstract void adjust();
    void play() {
        System.out.println("Instrument play...");
    }
    //int play(){}
}

class Brass extends Instrument {
    public void adjust(){};
    void play() {
        System.out.println("Brass.play()");
    }
}

class Stringed extends Instrument {
    public void adjust(){};
    void play() {
        System.out.println("Stringed.play()");
    }
}

class Wind extends Instrument {
    public void adjust(){};
    void play() {
        System.out.println("Wind.plany()");
    }

}


public class Music {

    static void tune( Instrument i ) {
        i.play();
    }

    public static void main ( String[] args ) {
        //Instrument b = new Instrument();
        Wind x = new Wind();
        Brass bx = new Brass();
        Stringed sx = new Stringed();

        tune( x );
        tune(bx);
        tune(sx);
        System.out.println("@i:"+x.i);
        System.out.println("@i:"+bx.i);
        System.out.println("@i:"+sx.i);

    }
}
