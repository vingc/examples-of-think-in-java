/**
 * Created by vingc on 2016/9/9.
 */
class ExException extends Exception{
    private String g;
    ExException(){}
    ExException(String msg){ g = msg; }
    public String getMessage(){return g;}
}
class TryException {
    public void f() throws ExException {
        throw new ExException("TryException.f()");
    }
}

class AssException extends RuntimeException{
    AssException(String msg){ super(msg); }
}

 class Assert2 {
    private static void perr(String msg) {
        throw new AssException(msg);
    }
    public final static void is_true(boolean exp) {
        if(!exp) perr("Assertion failed");
    }
    public final static void is_false(boolean exp){
        if(exp) perr("Assertion failed");
    }
    public final static void
    is_true(boolean exp, String msg) {
        if(!exp) perr("Assertion failed: " + msg);
    }
    public final static void
    is_false(boolean exp, String msg) {
        if(exp) perr("Assertion failed: " + msg);
    }
} ///:~

public class ExerciseNine {
    public static void main(String[] args) {
        try {
            //throw new ExException("Main.Exception");
            //new TryException().f();
            Assert2.is_false(true);
        }catch(Exception e){
            System.out.println("Catch Exception,e.printStackTrace:");
            e.printStackTrace();
            System.out.println(" "+e.getMessage()+", "+e.toString());
        }finally{
            System.out.println("finally");
        }
    }
}
