package debug;

/**
 * Created by vingc on 2016/8/25.
 */
final class Noodle {
    public static int length;
    int shape;
    private  Noodle(){};
}

public class Pie {
    public String s;
    int a = Noodle.length;
    protected void foo() {
        System.out.println( "Pie.foo()" );
    }

    protected void bar() {
        System.out.println("Pie.bar()");
    }
}
