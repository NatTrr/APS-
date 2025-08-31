package Ispitni;

import java.util.*;

// Класа за еден документ
class Document {
    String name;
    String status;

    public Document(String name) {
        this.name = name;
        this.status = "waiting";
    }
}

// Генеричка класа за Queue
class MyQueue<T> {
    private LinkedList<T> list;

    public MyQueue() {
        list = new LinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public List<T> getList() {
        return list;
    }
}

public class JuniEden {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        MyQueue<Document> queue = new MyQueue<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            switch (parts[0]) {
                case "ADD":
                    String docName = parts[1];
                    int count = Integer.parseInt(parts[2]);
                    for (int j = 0; j < count; j++) {
                        queue.enqueue(new Document(docName));
                    }
                    break;

                case "PRINT":
                    int toPrint = Integer.parseInt(parts[1]);
                    List<Document> tempList = new ArrayList<>();
                    int printed = 0;

                    // вади од ред и менува статус ако е waiting
                    while (!queue.isEmpty() && printed < toPrint) {
                        Document doc = queue.dequeue();
                        if (doc.status.equals("waiting")) {
                            doc.status = "printed";
                            printed++;
                        }
                        tempList.add(doc);
                    }

                    // ги враќаме сите елементи назад во ред
                    for (Document doc : tempList) {
                        queue.enqueue(doc);
                    }
                    break;

                case "STATUS":
                    System.out.println("Current status:");
                    for (Document doc : queue.getList()) {
                        System.out.println(doc.name + " " + doc.status);
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
