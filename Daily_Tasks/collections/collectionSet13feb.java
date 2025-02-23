import java.util.*;

public class collectionSet13feb {
    public static void main(String[] args) {
        HashSet<Integer> hs1 = new HashSet<>();
        LinkedHashSet<String> hs2 = new LinkedHashSet<>();
        TreeSet<Double> hs3 = new TreeSet<>();
        setSample(hs1);
        setSample(hs2);
        setSample(hs3);
    }

    public static void setSample(HashSet<Integer> hs) {
        hs.add(5);
        hs.add(6);
        hs.add(49);
        hs.add(14);
        hs.add(43);
        hs.add(25);
        hs.add(67);
        System.out.println("HashSet Size: " + hs.size());
        System.out.println("Elements in HashSet: " + hs);
        hs.remove(67);
        System.out.println("Elements in HashSet after removing: " + hs);
        System.out.print("Using foreach : ");
        for (int i : hs) {
            if (i % 7 == 0)
                System.out.print(i + " ");
        }
        System.out.println();

    }

    public static void setSample(LinkedHashSet<String> hs) {
        hs.add("A");
        hs.add("sdfgsdfB");
        hs.add("ABCD");
        hs.add("SPfgg");
        hs.add("AIffgA");
        hs.add("MDA");
        hs.add("B");

        System.out.println("Linked HashSet Size: " + hs.size());
        System.out.println("Elements in Linked HashSet: " + hs);
        hs.remove("MDA");
        System.out.println("Elements in Linked HashSet after removing: " + hs);
        System.out.println("Element greater than len 5 : ");
        for (String i : hs) {
            if (i.length() > 5)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void setSample(TreeSet<Double> hs) {
        hs.add(23.455);
        hs.add(54.3453);
        hs.add(345.45);
        hs.add(3.0);
        hs.add(5.8);
        hs.add(19.99);
        hs.add(45.8);

        System.out.println("TreeSet Size: " + hs.size());
        System.out.println("Elements in TreeSet: " + hs);
        hs.remove(5.8);
        System.out.println("Elements in TreeSet after removing: " + hs);
        System.out.println("Element greater than 20 : ");
        for (Double i : hs) {
            if (i > 20)
                System.out.print(i + " ");
        }
        System.out.println();

    }

}