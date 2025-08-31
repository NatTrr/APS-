import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

class myyyStack<T>
{
    private LinkedList<T> lista;
    public myyyStack()
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

public class PonistuvanjeTopcinja
{
    //Help function that will check if they are valid to cancel out
    public static boolean canCancelOut(String chOne, String chTwo)
    {
        if((chOne.equals("R+") && chTwo.equals("R-")) ||
                chOne.equals("R-") && chTwo.equals("R+")) return true;

        if((chOne.equals("G+") && chTwo.equals("G-")) ||
                chOne.equals("G-") && chTwo.equals("G+")) return true;

        if((chOne.equals("B+") && chTwo.equals("B-")) ||
                chOne.equals("B-") && chTwo.equals("B+")) return true;

        return false;
    }

    //This function based on the input ball will give me the
    //opposite one so i can check if i have the opposite

    public static String opositeOfInputBall(String ch)
    {
        return switch (ch)
        {
            case "R+" -> "R-";
            case "R-" -> "R+";
            case "G+" -> "G-";
            case "G-" -> "G+";
            case "B+" -> "B-";
            case "B-" -> "B+";
            default -> "";
        };
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String token=br.readLine();
        String[] tokens=token.split("\\s+"); // \\s+ means split after one or more empty spaces

        myyyStack<String> reds=new myyyStack<>();
        myyyStack<String> greens=new myyyStack<>();
        myyyStack<String> blues=new myyyStack<>();

        for(int i=0;i<tokens.length;i++) {
            if (tokens[i].charAt(0) == 'R') {
                //if the character is from the R it goes into the
                //red domain
                //if the red domain is empty i put it in the red stack

                if (reds.isEmpty())
                    reds.push(tokens[i]);

                    //if it is not empty it means there is some ball i can
                    //check if they cancel out with
                else if (canCancelOut(reds.peek(), tokens[i]))
                    reds.pop();
                else
                    reds.push(tokens[i]);
            }

            if (tokens[i].charAt(0) == 'G') {
                if (greens.isEmpty())
                    greens.push(tokens[i]);
                else if (canCancelOut(greens.peek(), tokens[i]))
                    greens.pop();
                else
                    greens.push(tokens[i]);
            }

            if (tokens[i].charAt(0) == 'B') {
                if (blues.isEmpty())
                    blues.push(tokens[i]);
                else if (canCancelOut(blues.peek(), tokens[i]))
                    blues.pop();
                else
                    blues.push(tokens[i]);
            }
        }

        //System.out.println(reds);
        // System.out.println(greens);
        // System.out.println(blues);

        int counter = reds.size() + greens.size() + blues.size();

        System.out.println(counter);

        for (String ball : reds.elements()) {
            System.out.print(opositeOfInputBall(ball) + " ");
        }

        for (String ball : greens.elements()) {
            System.out.print(opositeOfInputBall(ball) + " ");
        }

        for (String ball : blues.elements()) {
            System.out.print(opositeOfInputBall(ball) + " ");
        }
    }
}


//test : R+ R+ G- B+ B-
//output: 3
//R- R- G+