/**
 * Created by vingc on 2016/9/29.
 */

interface Cup {
    int height();
}

interface Iron {
    int weight();
}

class IronCup implements Cup,Iron {
    private int h,w;
    IronCup( int h, int w ) {
        this.h = h;
        this.w = w;
    }

    public int height() { return h; }
    public int weight() { return w; }

}
public class Exercise25 {

    public static <T extends Cup> void fix_h( T c ) {
//        h = h / 2;
        System.out.println( "fixed h:" + c.height() );
    }
    public static <T extends Iron> void fix_w( T i ) {
//        w = w * 2;
        System.out.println( "fixed w:" + i.weight() );
    }

    public static void main(String[] args) {
        IronCup ic = new IronCup(10, 20);
        fix_h(ic);
        fix_w(ic);
    }
}
