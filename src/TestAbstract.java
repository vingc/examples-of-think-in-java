/**
 * Created by vingc on 2016/12/20.
 */
abstract class Abtrrr {
    private int aaa = 0;
    int bbb = 0;
    protected int ccc = 0;
    public int ddd = 0;
    public abstract void run();
}
class SubAbtrrr extends Abtrrr {
    public void run(){
        System.out.println(bbb+ccc+ddd);
    }
}
public class TestAbstract {
}
