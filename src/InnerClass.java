/**
 * Created by vingc on 2016/8/29.
 */
 class Parcel {
    class Contents {
        private int i = 11;
        void setValue( int j ) {
            i = j;
        }
    }

    static class Dest {
        private static String addr = null;
        Dest(String to) {
            addr = to;
        }

    }

    public Contents cons() {
        return new Contents();
    }

    public Dest to(String to) {
        return new Dest(to);
    }
    public void ship(String to) {
        Contents c = new Contents();
        Dest d = new Dest(to);
    }

}

public class InnerClass {
    class Dest{}
    public static void main(String[] args) {
        Parcel p = new Parcel();
        p.ship("Beijing");

        Parcel.Dest d = p.to("shanghai");
        Parcel.Contents c = p.cons();
        //Parcel.Dest b = new Dest("from");
        //Parcel.Dest e=new Dest("to");
    }
}
