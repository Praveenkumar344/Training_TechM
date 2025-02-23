import java.util.LinkedList;

public class AppendToLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Item1");
        list.add("Item2");

        list.addLast("Item3");
        System.out.println(list);
    }
}
