/**
 * Created by vingc on 2016/8/29.
 */

//: Parcel3.java
// Returning a handle to an inner class
//package c07.parcel3;

abstract class Contents {
    abstract public int value();
}

interface Destination {
    String readLabel();
}

public class Parcel3 {
    static int cnt = 0;
    Parcel3(){
        cnt++;
        System.out.println("Parcel3..."+cnt);
    }
    private class PContents extends Contents {
        private int i = 11;
        public int value() { return i; }
    }
    protected  class PDestination
            implements Destination {
        private String label;
        private PDestination(String whereTo) {
            new Parcel3();
            label = whereTo;
        }
        public int retCnt(){return cnt;}
        public String readLabel() { return label; }
    }
    public PDestination dest(String s) {
        return new PDestination(s);
    }
    public PContents cont() {
        return new PContents();
    }
}
class Test {
    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Contents c = p.cont();
        Destination d = p.dest("Tanzania");
        Parcel3.PDestination e = p.dest("d");
        Parcel3.PDestination f = p.dest("s");
// Illegal -- can't access private class:
 //Parcel3.PContents e = p.new PContents();
   //     Parcel3.PDestination f = p.new PDestination();

        System.out.println("e.cnt:"+e.retCnt());
        System.out.println("f.cnt:"+e.retCnt());
    }
} ///:~
