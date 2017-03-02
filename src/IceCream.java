/**
 * Created by vingc on 2016/8/25.
 */
class Sundae {
    private Sundae(){
        System.out.println("Sundae constructor");
    }
    static Sundae makeSundae() {
        return new Sundae();
    }
}

public class IceCream {
    public static void main(String[] args) {
        Sundae p = Sundae.makeSundae();
    }
}
