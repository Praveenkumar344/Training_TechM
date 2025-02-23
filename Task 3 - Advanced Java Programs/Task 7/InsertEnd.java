import java.util.LinkedList;

public class InsertEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Start");

        list.addLast("End");
        System.out.println(list);
    }
}
