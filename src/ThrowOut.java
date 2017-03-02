/**
 * Created by vingc on 2016/9/8.
 */
//: ThrowOut.java
public class ThrowOut {
    public static void
    main(String[] args) throws Throwable {
        try {
            throw new Throwable();
        } catch(Throwable e) {
            System.out.println("Caught in main()");
        }

        ThrowOut t = new ThrowOut();
        System.out.println("getClass().getName():"+t.getClass().getName()+" "+t.getClass().toString());
    }
} ///:~