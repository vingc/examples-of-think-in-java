/**
 * Created by vingc on 2016/9/8.
 */
class MyException extends  Exception {
    public MyException() {};
    public MyException(String msg) {
        super(msg);
    }
}
public class InheritException {
    public static void f() throws MyException {
        System.out.println("f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        System.out.println("g()");
        throw new MyException("g().MyException");
    }
    public static void main(String[] args) {
        try{
            f();
        }catch(MyException e){
            e.printStackTrace();
            System.out.println("MyException from f");
        }

        try{
            g();
        }catch(MyException e){
            System.out.println("MyException from g");
            e.printStackTrace();
        }
    }
}
