/**
 * Created by vingc on 2016/9/4.
 */
//: Enumerators2.java
// Revisiting Enumerations
import java.util.*;
class PrintData {
    static void print(Enumeration e) {
        while(e.hasMoreElements())
            System.out.println(
                    e.nextElement().toString());
    }
}
class Mouse {
    private int mouseNumber;
    Mouse(int i) {
        mouseNumber = i;
    }
    // Magic method:
    public String toString() {
        return "This is Mouse #" + mouseNumber;
    }
    void print(String msg) {
        if(msg != null) System.out.println(msg);
        System.out.println(
                "Mouse number " + mouseNumber);
    }
}

class Enumerators2 {
    public static void main(String[] args) {
        Vector v = new Vector();
        for(int i = 0; i < 5; i++)
            v.addElement(new Mouse(i));
        Hashtable h = new Hashtable();
        for(int i = 0; i < 5; i++)
            h.put(new Integer(i), new Hamster2(i));
        System.out.println("Vector");
        PrintData.print(v.elements());
        System.out.println("Hashtable");
        PrintData.print(h.elements());
    }
} ///:~
