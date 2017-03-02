/**
 * Created by vingc on 2016/9/8.
 */
public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("Originating f() exception");
        throw new Exception();
    }

    public static void g() throws Throwable {
        try{
            f();
        }catch(Exception e) {
            System.out.println("g() catch Exception, e.printStackTrace:");
            e.printStackTrace();
            throw e;
            //fillInStackTrac();
        }
    }

    public static void main(String[] args) throws Throwable {
        try{
            g();
        }catch(Exception e) {
            System.out.println("main() catch Exception, e.printStackTrace:");
            e.printStackTrace();
        }
    }
}
