import sun.security.provider.SHA;

/**
 * Created by vingc on 2016/8/28.
 */
class Shape {
    void draw(){}
    void erase(){}
}

class Circle extends Shape {
    void draw() {
        System.out.println("Circle.draw()");
    }
    void erase() {
        System.out.println("Circle.erase()");
    }
}
class Trangle extends Shape {
    void draw() {
        System.out.println("Trangle.draw()");
    }
    void erase() {
        System.out.println("Trangle.erase()");
    }
}
class Square extends Shape {
    void draw() {
        System.out.println("Square.draw()");
    }
    void erase() {
        System.out.println("Square.erase()");
    }
}

public class ShapeMulti {
    static Shape randShape(){
        switch( (int)(Math.random() * 3) ){
            case 1: return new Circle();
            case 2: return new Square();
            case 0: return new Trangle();
            default: return null;
        }
    }
    public static void main(String[] args) {
        Shape[] s = new Shape[9];

        for( int i = 0; i < s.length; i++ ) {
            s[i] = randShape();
            s[i].draw();
            s[i].erase();
        }

    }
}
