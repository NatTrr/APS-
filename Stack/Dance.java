import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class mS<T> {
    private LinkedList<T> lista;

    public mS() {
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


public class Dance {

    public static String theOther (String str1) {
        return switch (str1) {
            case "LM" -> "LZ";
            case "LZ" -> "LM";
            case "OM" -> "OZ";
            case "OZ" -> "OM";
            case "SM" -> "SZ";
            case "SZ" -> "SM";
            default -> "";
        };
    }

    public static void main(String[] args) throws IOException {
//    основни танци О, стандардни танци S и латино танци L

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] tokens = input.split(" ");

        mS<String> O = new mS<String>();
        mS<String> S = new mS<String>();
        mS<String> L = new mS<String>();

        for (String token : tokens) {
            if (token.charAt(0) == 'O') {
                if (O.isEmpty()) O.push(token); // ако си празен стави го
                else {
                    if (!O.peek().equals(token)) O.pop();     // инаку, ако овој што дошол и овој што е внатре може да се спојат,
                        // (не се еднакви), тогаш извади го
                    else O.push(token);                     // инаку стави го
                }
            }
            else if (token.charAt(0) == 'S') {
                if (S.isEmpty()) S.push(token);
                else {
                    if (!S.peek().equals(token)) S.pop();
                    else S.push(token);
                }
            }
            else if (token.charAt(0) == 'L') {
                if (L.isEmpty()) L.push(token);
                else {
                    if (!L.peek().equals(token)) L.pop();
                    else L.push(token);
                }
            }
        }

        System.out.println(O.size() + S.size() + L.size());
        for (String token : L.elements()) System.out.print(theOther(token) + " ");
        for (String token : S.elements()) System.out.print(theOther(token) + " ");
        for (String token : O.elements()) System.out.print(theOther(token) + " ");

        // Потполно идентична како cancellingOutBalls.java
        // Тука направив мала промена а тоа е кога проверувам дали можат да се спојат.
        // Идејата е, ако се еднакви тогаш не можат да се спојат, ако не се еднакви значи се од спротивен пол
        // следува дека можат да се спојат
    }


}