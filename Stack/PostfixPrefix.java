import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class mmmyyStack<T> {
    private LinkedList<T> lista;

    public mmmyyStack() {
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

public class PostfixPrefix {
    public static boolean isNumber(String str)
    {
        return !(str.charAt(0)=='+' || str.charAt(0)=='-'
                ||str.charAt(0)=='/' || str.charAt(0)=='*'
                || str.charAt(0)=='^' ||
                str.charAt(0)=='(' || str.charAt(0)==')');
    }

    public static int priority(Character ch)
    {
        if (ch == '(') return 4;
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return 0;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String infix=br.readLine();
        String[] tokens=infix.split("\\s+");
        Stack<Character> stack=new Stack<Character>();

        StringBuilder postfix=new StringBuilder();

        for(String token: tokens)
        {
            if(isNumber(token))
                postfix.append(token).append(" ");
            else
            if(token.charAt(0)=='(')
                stack.push(token.charAt(0));
            else
            if(token.charAt(0)==')')
            {
                while (!stack.isEmpty() && stack.peek()!='(')
                    postfix.append(stack.pop()).append(" ");
                stack.pop();
            }
            else {
                while (!stack.isEmpty() &&
                        stack.peek()!='(' &&
                        priority(stack.peek())>=priority(token.charAt(0)))
                    postfix.append(stack.pop()).append(" ");
                stack.push(token.charAt(0));
            }
        }

        while (!stack.isEmpty())
            postfix.append(stack.pop()).append(" ");
        System.out.println(postfix);
    }
}


//infix
//postfix