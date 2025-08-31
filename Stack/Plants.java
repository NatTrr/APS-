import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class mmmmyyStack<T> {
    private LinkedList<T> lista;

    public mmmmyyStack() {
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

public class Plants
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        mmyyStack<Integer> stack=new mmyyStack<Integer>();

        ArrayList<Integer> plants=new ArrayList<Integer>();
        ArrayList<Integer> markers=new ArrayList<>();

        int days=-1;

        for(int i=0;i<n;i++)
        {
            plants.add(sc.nextInt());
            markers.add(1);
        }

        for(int i=0;i<plants.size();i++)
        {
            if(stack.isEmpty())
                stack.push(plants.get(i));
            else
            if(plants.get(i)<=stack.peek())
                stack.push(plants.get(i));
        }

        while (!stack.equals(plants))
        {
            for (int i=1;i<plants.size();i++)
            {
                if(plants.get(i)>plants.get(i-1))
                    markers.set(i,0);
            }

            for(int i=0;i<plants.size();i++)
            {
                if(markers.get(i)==0)
                {
                    plants.remove(i);
                    markers.remove(i);
                    i--;
                }
            }
            days++;
        }

        if(days<=0)
            System.out.println(0);
        else System.out.println(days);
    }
}

//odreden br rastenija
//ako rastenie ima povekje pesticid od to levo od nego umira
//


//infix
//postfix