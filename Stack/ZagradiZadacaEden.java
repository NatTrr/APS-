import java.util.*;

class myStack<T>
{
    private LinkedList<T> lista;
    public myStack()
    {
        lista=new LinkedList<>();
    }

    public boolean isEmpty()
    {
        return lista.isEmpty();
    }

    public void push(T item)
    {
        lista.addLast(item);
    }

    public T pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        return lista.removeLast();
    }

    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return lista.getLast();
    }
}

public class ZagradiZadacaEden {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        myStack<Character> stek=new myStack<>();

        String izraz=sc.nextLine();

        boolean validno=true;

        for(int i=0;i<izraz.length();i++)
        {
            char c=izraz.charAt(i);

            if(c=='(' || c=='{' || c=='[')
            {
                stek.push(c);
            }else if(c==')' || c=='}' || c==']')
            {
                if (stek.isEmpty())
                {
                    validno=false;
                    break;
                }
                char open=stek.pop();
                if(!matches(open, c))
                {
                    validno=false;
                    break;
                }
            }
        }

        if(!stek.isEmpty())
        {
            validno=false;
        }

        if(validno)
        {
            System.out.println("Okej");
        }else {
            System.out.println("Ne e okej");
        }
    }

    public static boolean matches(char open, char close)
    {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
