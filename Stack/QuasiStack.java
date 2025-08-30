import java.util.*;

// ова е структурата, НЕ е public
class QuasiStackStruct {
    private Deque<Integer> deque;

    public QuasiStackStruct() {
        deque = new LinkedList<>();
    }

    // вметнување на врв
    public void push(int x) {
        deque.addLast(x);
    }

    // вадење од врв или дно, поголемиот
    public int pop() {
        if (isEmpty()) throw new NoSuchElementException();

        int top = deque.peekLast();
        int bottom = deque.peekFirst();

        if (top > bottom) {
            return deque.removeLast();
        } else if (bottom > top) {
            return deque.removeFirst();
        } else {
            // ако се исти → вадам од дното
            return deque.removeFirst();
        }
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int top() {
        if (isEmpty()) throw new NoSuchElementException();
        return deque.peekLast();
    }

    public int bottom() {
        if (isEmpty()) throw new NoSuchElementException();
        return deque.peekFirst();
    }
}

// ова е главната класа со main → мора да е public и да има исто име со фајлот
public class QuasiStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        QuasiStackStruct qs = new QuasiStackStruct();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(sc.nextLine());
            qs.push(x);
        }

        // печати врв и дно
        System.out.println(qs.top() + " " + qs.bottom());

        // вади ги сите елементи
        while (!qs.isEmpty()) {
            System.out.print(qs.pop());
            if (!qs.isEmpty()) System.out.print(" ");
        }
    }
}
