/**
 * Created by vingc on 2016/9/26.
 */
public class Holder3<T> {
    private T a,b,c;
    public Holder3( T a, T b, T c ) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void set_a( T a ) { this.a = a; }
    public void set_b( T b ) { this.b = b; }
    public void set_c( T c ) { this.c = c; }

    public T get_a() { return a; }
    public T get_b() { return b; }
    public T get_c() { return c; }

    public void pack( T[] st ) {
//        st.set(st,0,a);
        for( T temp: st) {

        }
    }
    public static void main( String[] args ) {
        Holder3<String> hs = new Holder3<String>( "First", "Second", "Third" );
        System.out.println("a:"+hs.get_a()+" b:"+hs.get_b()+" c:"+hs.get_c());

    }
}
