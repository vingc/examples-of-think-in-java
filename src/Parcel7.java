import java.util.Random;

/**
 * Created by vingc on 2016/8/29.
 */
//: Parcel7.java
// An anonymous inner class that calls the
// base-class constructor
//package c07.innerscopes;

class Wrapping {
    private int i;
    Wrapping(int x ) {
        i = x;
    }
    int value(){return i;}
}
public class Parcel7 {
    public Wrapping wrap(int j) {
// Base constructor call:
        return new Wrapping(j) {
            Random t = r;
            int i = j;
            public int value2(){return i;}
            public int value() {

                return super.value() * 47;
            }
        }; // Semicolon required
    }

    Random r = new Random();

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Wrapping w = p.wrap(10);
        System.out.println("value():"+w.value());
        //System.out.println("value2():"+w.value2());
    }
} ///:~
