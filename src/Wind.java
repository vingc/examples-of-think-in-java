import java.util.Random;

/**
 * Created by vingc on 2016/8/26.
 */
interface Instrument {
    int len = (int)(Math.random()*20);
    //int len2;
    void play();
    void adjust();
    void what();
    Random si = new Random();
}

class Brass implements Instrument {
    public void play( ) {
        System.out.println("Brass.play()");
    }
    public void adjust() {
        System.out.println("Brass.adjust()");
    }
    public void what() {
        System.out.println("Brass");
    }
}

class Stringed implements Instrument {
    public void play( ) {
        System.out.println("Stringed.play()");
    }
    public void adjust() {
        System.out.println("Stringed.adjust()");
    }
    public void what() {
        System.out.println("Stringed");
    }
}

public class Wind implements Instrument {
    public void play( ) {
        System.out.println("Wind.play()");
    }
    public void adjust() {
        System.out.println("Wind.adjust()");
    }
    public void what() {
        System.out.println("Wind");
    }
}
class WoodWind extends Wind {
    public static void tune(Instrument x ) {
        x.play();
    }
    public static void main(String[] args) {
        Stringed a = new Stringed();
        Brass b = new Brass();
        Wind c = new Wind();
        WoodWind d = new WoodWind();
        a.what();b.what();c.what();d.what();
        tune(a);
        tune(b);
        tune(c);
        tune(d);
        System.out.println(Instrument.len);
        //a.len=2;\
    }
}
