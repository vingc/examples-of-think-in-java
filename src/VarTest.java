/**
 * Created by vingc on 2016/8/15.
 */
public class VarTest {
    public static void main(String[] args){
        int index;
        int len = args.length;
        for( index = 0; index < len; index++ )
        {
            if( args[index] != null )
            {
                System.out.println("Variable" + index + " = " + args[index]);
            }
        }
    }
}
