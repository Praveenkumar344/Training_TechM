import java.util.LinkedList;

public class InsertFirstLast {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Middle");

        list.addFirst("First");
        list.addLast("Last");

        System.out.println(list);
    }
}
