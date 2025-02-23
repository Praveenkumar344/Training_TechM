import java.util.ArrayList;

public class IterateArrayList {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");

        for (String item : items) {
            System.out.println(item);
        }
    }
}
