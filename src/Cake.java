/**
 * Created by vingc on 2016/8/25.
 */

import debug.*;

class StrawBerryPie extends Pie {
    int radius;
    int diameter;
    int perimeter;
    void eFoo() {
        foo();
    }
/*
    void foo() {
        System.out.println("StrawBerryPie.foo()");
    }
    */
}

public class Cake {
    Cake(){};
    public static void main(String[] args) {
        Pie p = new Pie();
        StrawBerryPie sbp = new StrawBerryPie();
        sbp.eFoo();
        //System.out.print(Noodle.length);
        //int a = Noodle.length;

    }
}
