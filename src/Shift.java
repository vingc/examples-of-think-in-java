/**
 * Created by vingc on 2016/8/16.
 */
public class Shift {
    public static void main(String[] args) {
        int a = -1;
        a >>>= 10;
        System.out.println(a);
        long b = -1;
        b >>>= 10;
        System.out.println(b);
        short c = 32;
        c >>= 17;
        System.out.println(c);
        byte d = 011;
        d <<= 7;
        System.out.println(d);
        System.out.println("string"+a);
        System.out.println(a+"string");
    }
}
