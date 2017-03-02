/**
 * Created by vingc on 2016/8/27.
 */
/* 衍生类在清零衍生类空间之后，把所有的变量设置为对应类型的默认值，
* 1. 会优先调用基础类的默认构建器（如果有），
* 2. 执行衍生类变量的初始化，
* 3. 执行衍生类的构建器随后的部分*/
class A {
    int i = 1;
    A( int i){
        System.out.println("A con.. i="+i);}
}

class B {
    B(int i){
        System.out.println("B con..");
    }
}

class C extends A {
    B b = new B(2);

    C() {
        super(1);
        System.out.println("C con..");
    }

}

public class ExerciseSix {
    public static void main( String[] args ) {
        C c = new C();
    }
}
