/**
 * Created by vingc on 2016/9/13.
 */
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;

public class Echo1 {
    public static void main(String[] args)
            throws IOException {
        try {
            InputStream is = new FileInputStream("HelloWorld/src/Echo1.java");
            System.setIn(is);
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

            String s;
            while ((s = stdin.readLine()) != null) System.out.println(s.toUpperCase());
            // An empty line or Ctrl-Z terminates the program

            //exercise

//        BufferedReader stdin2 = new BufferedReader(
//                new InputStreamReader(System.in = new FileInputStream("HelloWorld/src/Echo1.java"));
            //)
            PrintWriter pw = new PrintWriter(System.out, true);
            is.close();
            //System.exit(1);
        }catch(IOException e )
        {
            System.out.println("IOE:"+e.toString());
        }finally {
            System.out.println("finally");
        }
    }
} ///:~
