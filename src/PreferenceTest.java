import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.prefs.Preferences;

/**
 * Created by vingc on 2016/9/16.
 */
public class PreferenceTest {
    public static void main(String[] args) throws Exception {
        System.out.println(PreferenceTest.class);
        Preferences p = Preferences.userNodeForPackage( PreferenceTest.class );
        p.put("PATH",System.getenv("PATH"));
        p.put("user.dir", System.getProperty("user.dir"));
        for( String key : p.keys() ) {
            System.out.println( key + ":" +p.get(key,null) );
        }
    }
}
