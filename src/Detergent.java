/**
 * Created by vingc on 2016/8/25.
 */

class Cleanser {
    int i = 1;
    Cleanser(){ System.out.println("Cleanser constructor"); }

    private String s = new String("begin");
    public void append( String a ) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    private void scrub() { append(" scrub()"); }
    public void print() { System.out.println( s ); }
    public void TestMo(){System.out.println("Cleanser.TestMo()");}

    public static void main( String[] s ) {
        Cleanser pC = new Cleanser();
        pC.dilute();
        pC.apply();
        pC.scrub();
        pC.print();
    }
}
public class Detergent extends Cleanser {
    int i = 2;
    Cleanser bb = new Cleanser();
    Detergent() { System.out.println("Detergent constructor"); }

    public void scrub() {
        append(" Detergent.scrub()");
        //super.scrub(); //call base-calss method
    }
    public void foam() { append(" foam()"); }

    public void TestMo(){System.out.println("Detergent.TestMo()");}

    public static void main( String[] args ) {
        Detergent pD = new Detergent();
        pD.dilute();
        pD.apply();
        pD.scrub();
        pD.foam();
        pD.print();
        Cleanser.main(args);

        System.out.println("Ext:"+pD.i);
        System.out.println("Base:"+((Cleanser)pD).i);

        pD.TestMo();
        ((Cleanser)pD).TestMo();
        pD.bb.TestMo();
    }
}
