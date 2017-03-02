//: io/StoringAndRecoveringData.java
import java.io.*;
import java.nio.charset.Charset;

public class StoringAndRecoveringData {
    public static void main(String[] args)
            throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        //File f = new File("bb").getAbsoluteFile()
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("Data.txt")));
        System.out.println(in.readDouble());
        // Only readUTF() will recover the
        // Java-UTF String properly:
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        //in.read()

        RandomAccessFile raf = new RandomAccessFile("Data.txt","rw");

        System.out.println("Random.....Acess.....File....");
        System.out.println(raf.readDouble());
        System.out.println(raf.readUTF());
        System.out.println(raf.readDouble());
        System.out.println(raf.readUTF());
        raf.getFilePointer();
        System.out.println(Charset.defaultCharset());
    }
} /* Output:
3.14159DN
That was pi
1.41413
Square root of 2
*///:~
