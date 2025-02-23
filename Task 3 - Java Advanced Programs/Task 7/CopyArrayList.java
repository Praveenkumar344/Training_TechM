import java.util.ArrayList;

public class CopyArrayList {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        ArrayList<String> list2 = new ArrayList<>(list1);
        System.out.println(list2);
    }
}
