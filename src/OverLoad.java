/**
 * Created by vingc on 2016/8/21.
 */
 class initial {
    void f() {
        int i;
        //i++;
    }
}
public class OverLoad {
    //void f1(char i){ System.out.println("f1(char):"+i);}
    //int f1(char i){ System.out.println("f1(char):"+i); return 1;}
    void f1(byte i){ System.out.println("f1(byte):"+i);}
    void f1(short i){System.out.println("f1(short):"+i);}
    void f1(int i){System.out.println("f1(int):"+i);}
    void f1(float i){
        System.out.println("f1(float):"+i);
    }
    void f1(double i){
        System.out.println("f1(double):"+i);
    }
    public static void main(String[] args){
        OverLoad p = new OverLoad();
        char c = 'c';
        p.f1(c);
        byte b = 1;
        p.f1(b);
        int  a = 10;
        p.f1(a);
    }
}
