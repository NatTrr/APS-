import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class mmyySStack<T> {
    private LinkedList<T> lista;

    public mmyySStack() {
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

class Book
{
    public String title;
    public int takenOut;

    Book(String title, int takenOut)
    {
        this.title=title;
        this.takenOut=takenOut;
    }

    public String toString()
    {
        return title+" "+takenOut;
    }
}

public class Ispitna {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] parts = input.split(" ");

        int n = Integer.parseInt(parts[0].trim()); // број на книги
        int m = Integer.parseInt(parts[1].trim()); // број на испити

        input = br.readLine();
        String[] books = input.split(" "); // насловите
        input = br.readLine();
        String[] exams = input.split(" "); // таргет

        mmyySStack<Book> bookStack = new mmyySStack<>();
        mmyySStack<Book> helper = new mmyySStack<>();

        Book[] bookArr = new Book[n];
        for (int i = 0; i < n; i++) {
            bookArr[i] = new Book(books[i], 0); // вака го запазувам редот на појавување
            bookStack.push(bookArr[i]); // исти референци имаат и во стек и во низа
        }

        for (String exam : exams) {
            while (!bookStack.isEmpty() && !bookStack.peek().title.equals(exam)) { // се додека не те најдам
                Book book = bookStack.pop(); // вади
                book.takenOut++; // зголеми
                helper.push(book); // стави во помошниот стек
            }
            Book theBook = bookStack.pop(); // супер те најдов те извадов
            theBook.takenOut++; // зголеми
            while (!helper.isEmpty()) { // да знаеме до кога да враќаме
                bookStack.push(helper.pop()); // ги враќам старите назад
            }
            bookStack.push(theBook); // те враќам тебе најгоре
        }

        for (Book book : bookArr) {
            System.out.println(book); // истите референци, па како се зголемуваат во стек така и во низа ќе се зголемуваат
            // takenOut
        }

    }
}
