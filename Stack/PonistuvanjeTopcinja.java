import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MmyStack<T> {
    private LinkedList<T> list;

    public MmyStack() {
        list = new LinkedList<>();
    }

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.removeLast();
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public List<T> getAll() {
        return new ArrayList<>(list);
    }
}

public class PonistuvanjeTopcinja {

    public static boolean canCancel(String ch, String cch) {
        return (ch.equals("R+") && cch.equals("R-")) || (ch.equals("R-") && cch.equals("R+"))
                || (ch.equals("G+") && cch.equals("G-")) || (ch.equals("G-") && cch.equals("G+"))
                || (ch.equals("B+") && cch.equals("B-")) || (ch.equals("B-") && cch.equals("B+"));
    }

    public static String partnerInCrime(String ch) {
        return switch (ch) {
            case "R+" -> "R-";
            case "R-" -> "R+";
            case "G+" -> "G-";
            case "G-" -> "G+";
            case "B+" -> "B-";
            case "B-" -> "B+";
            default -> "";
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();
        String[] tokens = token.split("\\s+");

        MmyStack<String> reds = new MmyStack<>();
        MmyStack<String> greens = new MmyStack<>();
        MmyStack<String> blues = new MmyStack<>();

        for (String t : tokens) {
            if (t.charAt(0) == 'R') {
                if (!reds.isEmpty() && canCancel(reds.peek(), t)) reds.pop();
                else reds.push(t);
            } else if (t.charAt(0) == 'G') {
                if (!greens.isEmpty() && canCancel(greens.peek(), t)) greens.pop();
                else greens.push(t);
            } else if (t.charAt(0) == 'B') {
                if (!blues.isEmpty() && canCancel(blues.peek(), t)) blues.pop();
                else blues.push(t);
            }
        }

        int remaining = reds.size() + greens.size() + blues.size();
        System.out.println(remaining);

        for (String r : reds.getAll()) System.out.print(partnerInCrime(r) + " ");
        for (String g : greens.getAll()) System.out.print(partnerInCrime(g) + " ");
        for (String b : blues.getAll()) System.out.print(partnerInCrime(b) + " ");
    }
}
