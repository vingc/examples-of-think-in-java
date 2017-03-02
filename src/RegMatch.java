import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vingc on 2016/9/17.
 */
public class RegMatch {
    public static void CheckMatch(String src) {
        System.out.println(src.matches("^\\p{Upper}\\p{Graph}*\\.$"));
    }
    public static void main(String[] args) {
//        CheckMatch("Big.workd_ie!,.");
//        CheckMatch("bg.workd_ie!,.");
//        CheckMatch("Big.workd_ie!,.s");
//        CheckMatch("Java now has regular expressions");
        //System.out.println("Java now has regular expressions".matches("^Java.*"));

        /* String input = "Java now has regular expressions";
        //for(String arg : args) {
            System.out.println("Regular expression: \"" + input + "\"");
            Pattern p = Pattern.compile("n.w\\s+h(a|i)s");
            Matcher m = p.matcher(input);
            while(m.find()) {
                System.out.println("Match \"" + m.group() + "\" at positions " +
                        m.start() + "-" + (m.end() - 1));
            }
        //}*/
        String input = "abcabcabcabc";
        //for(String arg : args) {
        System.out.println("Regular expression: \"" + input + "\"");
        Pattern p = Pattern.compile("abcabc");
        Matcher m = p.matcher(input);
        while(m.find()) {
            System.out.println("Match \"" + m.group() + "\" at positions " +
                    m.start() + "-" + (m.end() - 1));
        }
        //}
    }

}
