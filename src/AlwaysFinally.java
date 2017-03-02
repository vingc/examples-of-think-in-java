/**
 * Created by vingc on 2016/9/9.
 */
//: AlwaysFinally.java
// Finally is always executed
class Ex extends Exception {}
public class AlwaysFinally {
    public static void main(String[] args) {
        int i = 0;
        while( i++ < 2 ) {
            System.out.println("Entering first try block");
            try {
                System.out.println("Entering second try block");
                try {
                    throw new Ex();
                } finally {
                    System.out.println("finally in 2nd try block");
                }
            } catch (Ex e) {
                if(i == 1 )
                {
                    break;
                }
                System.out.println("Caught Ex in first try block");
            } finally {
                System.out.println("finally in 1st try block");
            }
        }
    }
} ///:~