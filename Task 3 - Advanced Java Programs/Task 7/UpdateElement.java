import java.util.ArrayList;

public class UpdateElement {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Toyota");
        cars.add("Honda");
        cars.add("BMW");

        cars.set(1, "Ford");
        System.out.println(cars);
    }
}
