import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vingc on 2016/9/13.
 */
public class BinaryMap {
    public static void main(String[] args) throws IOException{
        DataInputStream br = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("HelloWorld/src/BinaryMap.java")));
        HashMap<Byte,Integer> mbi = new HashMap<Byte, Integer>();
        byte b;
        Integer cnt;

        try {

            while( br.available() != 0 ) {
                b = (byte)br.readByte();
                if ( ( cnt = mbi.get(b) ) != null ) {
                    mbi.put(b,++cnt);
                }
                else {
                    mbi.put(b,1);
                }
            }
            System.out.println("Size:"+mbi.size());
            System.out.println(mbi);
        }catch(IOException e){
            System.out.println("IOE:"+e.toString());
        }finally {
            br.close();
        }
    }
}
