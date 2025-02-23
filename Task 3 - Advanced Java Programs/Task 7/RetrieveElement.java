import java.util.ArrayList;

public class RetrieveElement {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Paris");
        cities.add("London");
        cities.add("New York");

        System.out.println(cities.get(1));
    }
}
