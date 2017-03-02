/**
 * Created by vingc on 2016/8/21.
 */
package c03;

class Number1{
    int i;
    int getNumber(){ return i; }
};

public class ObjComp {
    int cnt;
    ObjComp increment()
    {
        cnt++;
        System.out.println("count:"+cnt);
        return this;
    }
    ObjComp increment(int a)
    {
        cnt++;
        System.out.println("count:"+cnt+","+a);
        return this;
    }

    static void T1()
    {
        System.out.println("t1...");
        Number1 b = new Number1();
        System.out.println("t1.getNumber():"+ b.getNumber());
        return;
    }
    public static void main(String[] args){
        ObjComp a = new ObjComp();
        ObjComp b = new ObjComp();
        ObjComp c = a;
        System.out.println("a==b:"+(a==b));
        System.out.println("a==c:"+(a==c));
        a.increment().increment(1).increment(2).increment(3);
        T1();
    }
}
