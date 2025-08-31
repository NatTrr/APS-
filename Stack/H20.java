import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class mmyyStack<T> {
    private LinkedList<T> lista;

    public mmyyStack() {
        lista = new LinkedList<>();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public void push(T item) {
        lista.addLast(item);
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return lista.removeLast();
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return lista.getLast();
    }

    public int size() {
        return lista.size();
    }

    @Override
    public String toString() {
        return lista.toString();
    }

    public Iterable<T> elements() {
        return lista;
    }
}

public class H20 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();
        String[] tokens = token.split(" ");

        mmyyStack<Character> h = new mmyyStack<>();
        mmyyStack<Character> o = new mmyyStack<>();

        int counter = 0;

        for (String atom : tokens) {
            if (atom.equals("H")) {
                if (h.isEmpty())
                    h.push('H');
                else if (h.size() >= 2 && !o.isEmpty()) {
                    h.pop();
                    o.pop();
                    counter++;
                } else h.push('H');
            }

            if (atom.equals("O")) {
                if (o.isEmpty()) {
                    if (h.size() >= 2) {
                        h.pop();
                        h.pop();
                        counter++;
                    } else o.push('O');
                } else {
                    if (h.size() >= 2) {
                        h.pop();
                        h.pop();
                        counter++;
                    } else o.push('O');
                }
            }
        }

        // last check (ако на крај останало доволно)
        if (h.size() >= 2 && !o.isEmpty()) {
            h.pop();
            h.pop();
            o.pop();
            counter++;
        }

        // output
        System.out.println("Molecules created: " + counter);

        System.out.print("Left atoms: ");
        for (Character hh : h.elements()) System.out.print(h + " ");
        for (Character oo : o.elements()) System.out.print(o + " ");
    }
}



//i have either H or O
//to make one molecule i need two H and one O
//random sequence
//how many are completed
//how many left
