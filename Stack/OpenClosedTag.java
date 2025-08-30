//EXERCISE 1: From One dimensional data structures - Courses
//We are given code in a modified programming language is given,
// where functions are represented by an opening and closing tag
// ("functionName" and "endfunctionName").
// Your task is to determine whether the given code is valid.
//Input: Code in a modified programming language, where each tag is written in a new line.
// Tags are entered until "x" is entered.
//Output: "Valid" if the code is valid, "Invalid" if the code is not valid.

import java.util.*;

// Прво ја дефинираме твојата класа стек
class MyStack<T> {
    private LinkedList<T> list;

    public MyStack() {
        list = new LinkedList<>();
    }

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

// Потоа главниот клас за проверка на функции
public class OpenClosedTag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack<String> stack = new MyStack<>();

        while (true) {
            String line = sc.nextLine();
            if (line.equals("x")) break;

            if (!line.startsWith("end")) {
                // отворен таг
                stack.push(line);
            } else {
                // затворен таг
                if (stack.isEmpty()) {
                    System.out.println("Invalid");
                    return;
                }
                String openTag = stack.pop();
                String expectedEnd = "end" + openTag;
                if (!line.equals(expectedEnd)) {
                    System.out.println("Invalid");
                    return;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
