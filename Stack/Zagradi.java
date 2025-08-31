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

public class Zagradi {
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

//Check for each ( or { or [
//if there is ), }, ]

//Да се провери коректноста на заградите во еден израз. Еден израз има коректни
//загради ако:
//- За секоjа лева заграда, подоцна следува соодветна десна заграда - За секоjа
//десна заграда претходно постои лева заграда
//- Секоj под-израз ме´гу пар од две загради содржи коректен броj на загради.
//Примери на изрази со коректни и некоректни загради: s x (s – a) x (s – b) x
//(s - c) коректни
//(– b + sqrt[b2 – 4ac]) / 2a коректни
//s x (s – a) x (s – b x (s – c) некоректни
//s x (s – a) x s – b) x (s – c) некоректни
//(– b + sqrt[b2 – 4ac)] / 2a некоректни
//Влез: Во влезот е даден изразот коj се внесува.
//Излез: На излез треба да се испечати дали заградите во изразот се коректни
//или не.
//Пример:
//Влез: s x (s - a) x (s - b) x (s - c)
//Излез: s x (s - a) x (s - b) x (s - c) ima korektni zagradi.