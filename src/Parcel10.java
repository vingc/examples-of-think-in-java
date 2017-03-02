/**
 * Created by vingc on 2016/8/29.
 */
//: Parcel10.java
// Static inner classes
package c03;

import java.util.Random;

abstract class Contents {
    abstract public int value();
}
interface Destination {
    String readLabel();
}
public class Parcel10 {
    private static class PContents
            extends Contents {
        private int i = 11;
        public int value() { return i; }
    }
    protected static class PDestination
            implements Destination {
        private String label;
        private PDestination(String whereTo) {
            label = whereTo;
        }
        public String readLabel() { return label; }

        private Random t = r;
    }

    static Random r = new Random();

    public static Destination dest(String s) {
        return new PDestination(s);
    }
    public static Contents cont() {
        return new PContents();
    }
    public static void main(String[] args) {
        Contents c = cont();
        Destination d = dest("Tanzania");
        System.runFinalizersOnExit(true);
    }
} ///:~