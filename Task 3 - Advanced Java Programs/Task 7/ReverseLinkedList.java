import java.util.LinkedList;
import java.util.Collections;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");

        Collections.reverse(list);
        System.out.println(list);
    }
}
