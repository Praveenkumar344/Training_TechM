import java.util.ArrayList;

public class InsertAtFirst {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Emma");

        names.add(0, "Alice");
        System.out.println(names);
    }
}
