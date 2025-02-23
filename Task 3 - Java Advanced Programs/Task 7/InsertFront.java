import java.util.LinkedList;

public class InsertFront {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Second");

        list.addFirst("First");
        System.out.println(list);
    }
}
