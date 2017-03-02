import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by vingc on 2016/9/11.
 */
public class CompPerfFile {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Output_Buf.txt") );
        FileWriter fw = new FileWriter("Output_noBuf.txt");

        long t1 = System.currentTimeMillis();

        for( int i = 0; i < 100000; i++ )
        {
            int a = (int)Math.random()*128;
            bw.write(a);
        }
        bw.close();

        long t2 = System.currentTimeMillis();
        System.out.println("Buffer output time: "+(t2-t1) );

        t1 = System.currentTimeMillis();

        for( int j = 0; j < 100000; j++ ) {
            int a = (int)Math.random()*128;
            fw.write(a);
        }
        fw.close();

        t2 = System.currentTimeMillis();
        System.out.println("pure output time: "+(t2-t1) );
    }
}
