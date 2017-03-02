import java.util.Iterator;

/**
 * Created by vingc on 2016/9/26.
 */
public class IterableFibonacci implements Iterable<Integer> {
    private int count = 0;
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }

    private int size;
    public IterableFibonacci( int size ) { this.size = size; }
    public IterableFibonacci(  ) {  }

    class IteratorFibnonaaci implements Iterator<Integer> {
        private int curCount = size;
        @Override
        public boolean hasNext() {
            return curCount > 0;
        }

        @Override
        public Integer next() {
            curCount--;
            return IterableFibonacci.this.next();//fib(count++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException( "remove " );
        }
    }

    public Iterator<Integer> iterator(){
        return new IteratorFibnonaaci();
    }
    public static void main(String[] args) {
        IterableFibonacci gen = new IterableFibonacci();
        for(int i = 0; i < 18; i++)
            System.out.print(gen.next() + " ");

        System.out.println();
        for( Integer j: new IterableFibonacci(18) ) {
            System.out.print(j+" ");
        }
    }
}
