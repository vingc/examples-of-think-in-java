import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by vingc on 2016/9/11.
 */
public class ExerciseTenPoint1 {
    public static void main(String[] args) {
        LinkedList ld = new LinkedList();
        try {
            BufferedReader br = new BufferedReader( new FileReader("Input.txt") );
            PrintWriter pw = new PrintWriter("Output.txt");
            LineNumberReader lnr = new LineNumberReader(br);
            int lineCnt = 0;
            String s;
            /*while((s = br.readLine()) != null) {
                ld.add(s);
                pw.println(++lineCnt+": "+s);
            }

            pw.close();

            ListIterator li = ld.listIterator(ld.size());
            while(li.hasPrevious()){
                System.out.println(li.previous());
            }*/

            while( (s = lnr.readLine()) != null ) {
                System.out.println(lnr.getLineNumber()+": "+s);
            }

        }catch(EOFException e ){
            System.out.println("EOFException:"+e.toString());
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException:"+e.toString());
        }catch(IOException e){
            System.out.println("IOException:"+e.toString());
        }
    }
}
