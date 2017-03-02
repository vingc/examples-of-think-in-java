/**
 * Created by vingc on 2016/9/20.
 */
class SigalTai {
    public void test(){System.out.println("SigalTai");}
}
public class Duotai extends SigalTai {
    public void test(){System.out.println("DuoTai");}
    public static void main(String[] args){
        SigalTai st = new Duotai();
        st.test();
        System.out.println("IsInstanceOf(SigalTai):"+(st instanceof SigalTai));
        System.out.println("IsInstanceOf(Duotai):"+(st instanceof Duotai));
        System.out.println("Class:"+st.getClass().getSuperclass());
}
}
