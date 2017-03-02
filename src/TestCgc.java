/**
 * Created by vingc on 2016/10/3.
 */
class BaseHold<T> {}
class SeniorBaseHold extends BaseHold<SeniorBaseHold> {}

public class TestCgc {
    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1000;
        System.out.println("Integer 1:"+(a==b));
        System.out.println("Integer 1:"+a.equals(b));

        Integer aa = 127;
        Integer bb = 127;
        System.out.println("Integer 2:"+(aa==bb));
        System.out.println("Integer 2:"+aa.equals(bb));

        Integer a4 = new Integer(127);
        Integer b4 = new Integer(127);
        System.out.println("Integer 4:"+(a4==b4));

        Integer a3 = 128;
        Integer b3 = 128;
        System.out.println("Integer 3:"+ (a3==b3) );
    }
}
