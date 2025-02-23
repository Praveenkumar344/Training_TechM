import java.util.LinkedList;

public class InsertAtPosition {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("E");

        list.add(2, "C");
        list.add(3, "D");

        System.out.println(list);
    }
}
