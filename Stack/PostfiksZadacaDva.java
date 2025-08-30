//Да се напише алгоритам коj ке врши евалуациjа на израз во постфикс нотациjа.
//Пример 5 9 + 2 * 6 5 * + изразот е во постфикс нотациjа, и го претставува
//изразот (5 + 9) * 2 + 6 * 5, со што по евалуациjата резултатот треба да биде 14
//* 2 + 30 = 58.
//Влез: Во влезот е даден изразот коj се внесува.
//Излез:На излез треба да се испечати резултатот од евалуациjата на изразот.
//Пример:
//Влез: 5 9 + 2 * 6 5 * +
//Излез: Rezultatot e 58.0

import java.util.*;

class myyStack<T>
{
    private LinkedList<T> lista;
    public myyStack()
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
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        return lista.getLast();
    }
}

public class PostfiksZadacaDva {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        myyStack<Double> stek=new myyStack<>();
        String izraz=sc.nextLine();

        String[] tokens=izraz.split(" ");

        for(String token: tokens)
        {
            if(isNumber(token))
            {
                stek.push(Double.parseDouble(token));
            }else {
                double b=stek.pop();
                double a=stek.pop();
                double resultat=0;

                switch (token)
                {
                    case "+": resultat=a+b; break;
                    case "-": resultat=a-b; break;
                    case "*": resultat=a*b; break;
                    case "/": resultat=a/b; break;
                    default:
                            System.out.println("Nepoznatt operator: "+token);
                            return;
                }
                stek.push(resultat);
            }
        }
        double rezultatot=stek.pop();
        System.out.println("Rezultatot e: "+rezultatot);
    }

    private static boolean isNumber(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }catch (NumberFormatException e)
        {
            return false;
        }
    }
}
