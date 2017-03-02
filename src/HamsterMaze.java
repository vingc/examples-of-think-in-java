/**
 * Created by vingc on 2016/9/3.
 */
//: HamsterMaze.java
// Using an Enumeration
import java.util.*;
class Hamster2 {
    private int hamsterNumber;
    Hamster2(int i) {
        hamsterNumber = i;
    }
    public String toString() {
        return "This is Hamster #" + hamsterNumber;
    }
}
class Printer {
    static void printAll(Enumeration e) {
        while(e.hasMoreElements())
            System.out.println(
                    e.nextElement().toString());
    }
}
public class HamsterMaze {
    public static void main(String[] args) {
        Vector v = new Vector();
        for(int i = 0; i < 3; i++)
            v.addElement(new Hamster2(i));
        Printer.printAll(v.elements());
    }
} ///:~
