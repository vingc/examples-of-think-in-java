/**
 * Created by vingc on 2016/8/26.
 */
class Table {
    void thow() {
        System.out.println("throw..");
    }
}
public class FinalArgument {
    void playTable( final Table g ){
        g.thow();
    }

    void playTable2( Table g ) {
        g = new Table();
        g.thow();
    }

    public static void main( String[] args ) {
        FinalArgument x = new FinalArgument();
        x.playTable(null);
        x.playTable2(null);
    }
}
