import java.util.ArrayList;
import java.util.Iterator;

public class TestLess {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3}; // Iterable
        ar[0] = 22;

        for (int a : ar) {
            System.out.println(a);
        }

        Ar myar = new Ar();
        myar.add(11);
        myar.add(22);
        myar.add(33);
        myar.add(55);
        myar.add(44);
        myar.add(77);
        for (int a : myar) {
            System.out.println(a);
        }
    }
}

class Ar implements Iterable<Integer> {
    private int[] ar = new int[10];
    private int len;

    public void add(int num) {
        ar[len] = num;
        len++;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public Integer next() {
                return ar[index++];
            }
        };
    }
}
