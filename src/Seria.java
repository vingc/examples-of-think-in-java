import java.io.*;

/**
 * Created by vingc on 2016/9/15.
 */
class Phone implements Serializable {
    private String s;
    private static String s2 = new String( "Static.s2" );
    Phone( String x ) {
        s = x;
    }
    public String toString(){
        return s+s2;
    }
}
public class Seria implements Serializable {
    Phone p = new Phone( "dynamic" );
    String t;
    Seria( String y ) {
        t = y;
    }
    public String toString(){
        return p+t;
    }

    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        Seria s = new Seria( "main" );
        FileOutputStream fos = new FileOutputStream( "Input.txt" );
        ObjectOutputStream oos = new ObjectOutputStream( fos );
        oos.writeInt( 21 );
        oos.writeObject( s );
        System.out.println("Begin:"+s);
        oos.close();

        FileInputStream fis = new FileInputStream( "Input.txt" );
        ObjectInputStream ois = new ObjectInputStream( fis );
        int a = ois.readInt();
        System.out.println("int:"+a);
        Seria s2 = (Seria)ois.readObject();
        System.out.println("after:"+s2);
        ois.close();
    }
}
