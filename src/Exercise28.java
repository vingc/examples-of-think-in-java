/**
 * Created by vingc on 2016/10/1.
 */


public class Exercise28 {
    class Generic1<T> {
        T t;
        void take(T t) { this.t = t; }
    }
    // note that generic type T in Generic1 is not the same as type T in Generic2
    class Generic2<T> {
        T t;
        T give() { return t; }
    }
    <T> void contra(Generic1<? super T> g1t, T t) {
        g1t.take(t);
    }
    <T> T co(Generic2<? extends T> g2t) {
        return g2t.give();
    }
    public static void main(String[] args) {
        Exercise28 e28 = new Exercise28();
        e28.contra(e28.new Generic1<Number>(), 12);
        e28.co(e28.new Generic2<Number>());
    }
}
