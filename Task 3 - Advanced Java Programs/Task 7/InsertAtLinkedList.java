import java.util.LinkedList;

public class InsertAtLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");

        list.add(1, "Inserted");
        System.out.println(list);
    }
}
