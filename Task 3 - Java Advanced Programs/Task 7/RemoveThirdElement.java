import java.util.ArrayList;

public class RemoveThirdElement {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Elephant");
        animals.add("Tiger");

        animals.remove(2);
        System.out.println(animals);
    }
}
