// Property.java
/** Created by Vingc in 2016/08/15
 *  published by MIT license
 *  @version 1.0
 *  @author Vingc
 */

import java.util.*;

/**
 * @see System
 * @see Runtime#getRuntime()
 * @see Date
 */
public class Property {
    /**
     *
     * @param args array of String
     */
    public static void main(String[] args) {
        System.out.println(new Date());
        Properties p = System.getProperties();
        p.list(System.out);
        System.out.println("--- Memory Usage:");
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total Memory = "
                + rt.totalMemory()
                + " Free Memory = "
                + rt.freeMemory()
                + " Used Memory = "
                + ( rt.totalMemory() - rt.freeMemory())/1024);

        System.out.println("cp:"+p.getProperty("java.class.path"));
    }
}
