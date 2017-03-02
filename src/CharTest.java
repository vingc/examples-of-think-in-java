/**
 * Created by vingc on 2016/8/18.
 */
public class CharTest {
    public static void main(String[] args)
    {
        char c;
        for( c = 0; c < 128; c++ )
        {
            //System.out.println( "val: " + (int)c + ", char: " + c );
            System.out.printf("val: %d, char: %#x\n", (short)c, (short)c );
        }
    }
}
