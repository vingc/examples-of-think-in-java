// generics/ClassTypeCreator22.java
// TIJ4 Chapter Generics, Exercise 22, page 667
/* Use a type tag along with reflection to create a method that uses the
* argument version of newInstance() to create an object of a class with
* a constructor that has arguments.
*/
//package c03;

import java.util.*;
import java.lang.reflect.*;
//import static org.greggordon.tools.Print.*;


class Building2 {}
class House2 extends Building2 {
    private String location;
    private Integer area;
    public House2() { location = null; }
    public House2(Integer area) { this.area = area; }
    public House2(String location) {
        this.location = location;
    }
    public House2(String location, Integer area) {
        this.location = location;
        this.area = area;
    }
    public String toString() {
        return "House2" + ((location == null) ? "" :  " in " + location) +
                ((area != null) ? (", "+ area + " sqft") : "");
    }
}

public class ClassTypeCreator22<T> {
    Class<?> kind;
    public ClassTypeCreator22(Class<?> kind) {
        this.kind = kind;
    }
    public Object createNew(String typename)
            throws 	IllegalAccessException,
            InstantiationException,
            ClassNotFoundException {
        return Class.forName(typename).newInstance();
    }
    /** To create instance of typename with constructors taking arguments args: */
    public Object createNew(String typename, Object... args)
            throws 	IllegalAccessException,
            InstantiationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException {
        switch(args.length) {
            case 1 : return Class.forName(typename).getConstructor(args[0].getClass()).newInstance(args[0]);
            case 2 : return Class.forName(typename).getConstructor(args[0].getClass(), args[1].getClass()).
                    newInstance(args[0], args[1]);
        }
        return null;
    }
    public static void main(String[] args) {
        ClassTypeCreator22<Building2> ctcb = new ClassTypeCreator22<Building2>(Building2.class);
        ClassTypeCreator22<House2> ctch = new ClassTypeCreator22<House2>(House2.class);
        try {
            Building2 b = (Building2)ctcb.createNew("Building2");
            // To show we can access and print House2 constructors:
            System.out.println("House2 constructors:");
            Constructor[] ctors = House2.class.getConstructors();
            for(Constructor ctor : ctors) System.out.println(ctor);
            // create 3 new House2 objects:
            House2 h = (House2)ctch.createNew("House2", "Hawaii");
            House2 h2 = (House2)ctch.createNew("House2", 3000);
            House2 h3 = (House2)ctch.createNew("House2", "Manila", 5000);
            System.out.println("Constructed House2 objects:");
            System.out.println(h);
            System.out.println(h2);
            System.out.println(h3);
        } catch(IllegalAccessException e) {
            System.out.println("IllegalAccessException in main");
        } catch(InstantiationException e) {
            System.out.println("InstantiationException in main");
        } catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException in main");
        } catch(NoSuchMethodException e) {
            System.out.println("NoSuchMethodException in main");
        } catch(InvocationTargetException e) {
            System.out.println("InvocationTargetException in main");
        }
    }
}