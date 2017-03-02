/**
 * Created by vingc on 2016/9/1.
 */

interface Rodent {
    void run();
    void eat();
}

class Mourse implements Rodent {
    public void run() {
        System.out.println( "Mourse.run()" );
    }
    public void eat() {
        System.out.println( "Mourse.eat()" );
    }
}

class Gerbil implements Rodent {
    public void run() {
        System.out.println( "Gerbil.run()" );
    }
    public void eat() {
        System.out.println( "Gerbil.eat()" );
    }
}

class Hamster implements Rodent {
    public void run() {
        System.out.println( "Hamster.run()" );
    }
    public void eat() {
        System.out.println( "Hamster.eat()" );
    }
}

public class ExerciseSeven {
    public static void main( String[] args ) {
        Rodent[] ra = new Rodent[] {
            new Mourse(),new Gerbil(),new Hamster()
        };

        for ( int i = 0; i < ra.length; i++ ) {
            ra[i].run();
            ra[i].eat();
        }
    }
}
