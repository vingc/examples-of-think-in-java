import java.util.Date;
import java.util.EnumSet;
import java.util.Random;

/**
 * Created by vingc on 2016/10/4.
 */

// class Vig{}

enum Shrubbery {
    HIGH{
    public void getInfo(){ System.out.println("HIGH.getInfo()"); }
},
    TALL{
    public void getInfo(){ System.out.println("TALL.getInfo()"); }
},
    BIG{
        public void getInfo(){ System.out.println("BIG.getInfo()"); }
    },
    LITTLE{
        public void getInfo(){ System.out.println("LITTLE.getInfo()"); }
    },
    SHORT{
        public void getInfo(){ System.out.println("SHORT.getInfo()"); }
    };
    private static Random rand = new Random(System.currentTimeMillis());
    abstract void getInfo();
public static Shrubbery next(){
    return values()[rand.nextInt(values().length)];
}
}

public class EnumClass {
    public static void sw(Shrubbery s) {
        switch( s ) {
            case HIGH: System.out.println("HIGH case");return;
            case TALL: System.out.println("TALL.case");return;
//            case TALLA: System.out.println("TALL.case");break;
//            default:break;
        }
    }
    public static void main(String[] args) {
        for(Shrubbery s : Shrubbery.values() ) {
            System.out.print(s.getDeclaringClass()+" ");
            System.out.println(s.ordinal()+": "+s.toString());
            s.getInfo();
        }
        System.out.println(Shrubbery.HIGH);
        System.out.println(Shrubbery.valueOf("TALL"));
        sw(Shrubbery.HIGH);
        System.out.println("random: "+Shrubbery.next());

        //enumSet;
        EnumSet<Shrubbery> es = EnumSet.allOf(Shrubbery.class);
        System.out.println("Enumset:"+es);
    }
}
