/**
 * Created by vingc on 2016/10/1.
 */
abstract  class Cup1<T extends Cup1<T>> {
    abstract T filter( T t );

    T bigFilter( T g ) {
        System.out.println("cup1.bigFilter()");
        return filter( g );
    }

}

public class Exercise34 extends Cup1<Exercise34>{
    Exercise34 filter( Exercise34 t ) {
        System.out.println("Exercise34.filter()");
        return t;
    }
    public static void main(String[] args) {
        Exercise34 e = new Exercise34();
        e.filter(e);
        e.bigFilter(e);
    }
}
