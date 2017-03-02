/**
 * Created by vingc on 2016/9/11.
 */
import java.io.*;

public class FormattedMemoryInput {
    public static void main(String[] args)
            throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read(
                                    "HelloWorld/src/FormattedMemoryInput.java").getBytes()));
            /*while(true)
                System.out.print((char)in.readByte());*/
            while(in.available()!=0)
                System.out.print((char)in.readByte());
        } catch(EOFException e) {
            System.err.println("End of stream");
        }
    }
} /* (Execute to see output) *///:~