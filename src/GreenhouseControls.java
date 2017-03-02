import java.awt.*;

/**
 * Created by vingc on 2016/9/1.
 */
abstract class Event {
    private long evtTime;
    public Event(long eventTime) {
        evtTime = eventTime;
    }
    public boolean ready() {
        return System.currentTimeMillis() >= evtTime;
    }
    abstract public void action();
    abstract public String description();
} ///:~

// This is just a way to hold Event objects.
class EventSet {
    private Event[] events = new Event[100];
    private int index = 0;
    private int next = 0;
    public void add(Event e) {
        if(index >= events.length)
            return; // (In real life, throw exception)
        events[index++] = e;
    }
    public Event getNext() {
        boolean looped = false;
        int start = next;
        do {
            next = (next + 1) % events.length;
// See if it has looped to the beginning:
            if(start == next) looped = true;
// If it loops past start, the list
// is empty:
            if((next == (start + 1) % events.length)
                    && looped)
                return null;
        } while(events[next] == null);
        return events[next];
    }
    public void removeCurrent() {
        events[next] = null;
    }
}
class Controller {
    private EventSet es = new EventSet();
    public void addEvent(Event c) { es.add(c); }
    public void run() {
        Event e;
        while((e = es.getNext()) != null) {
            if(e.ready()) {
                e.action();
                System.out.println(e.description());
                es.removeCurrent();
            }
        }
    }
} ///:~

public class GreenhouseControls extends Controller{
    private boolean  fan = false;
    private class FanOn  extends Event {
        public FanOn( long eventTime ) {
            super( eventTime );
        }

        public void action() {
            fan = true;
        }
        public String description() {
            return "Fan is on";
        }
    }
    private class FanOff extends Event {
        public FanOff( long eventTime ) {
            super( eventTime );
        }
        public void action() {
            fan = false;
        }
        public String description() {
            return "Fan is off";
        }
    }
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        long tm = System.currentTimeMillis();

        gc.addEvent(gc.new FanOn(tm + 1000));
        gc.addEvent(gc.new FanOff(tm + 2000));
        //gc.addEvent(gc.new Restart(tm));
        gc.run();
    }

}
