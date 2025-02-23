import java.util.LinkedList;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("X");
        list.add("Y");
        list.add("X");
        list.add("Z");
        list.add("X");

        System.out.println("First occurrence of 'X': " + list.indexOf("X"));
        System.out.println("Last occurrence of 'X': " + list.lastIndexOf("X"));
    }
}
