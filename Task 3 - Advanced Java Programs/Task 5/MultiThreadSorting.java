import java.util.Arrays;

class SortThread extends Thread {
    private int[] arr;

    public SortThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        Arrays.sort(arr);
    }

    public int[] getSortedArray() {
        return arr;
    }
}

public class MultiThreadSorting {
    public static void main(String[] args) throws InterruptedException {
        int[] arr1 = { 8, 3, 5, 1, 9 };
        int[] arr2 = { 7, 2, 4, 6, 0 };

        SortThread thread1 = new SortThread(arr1);
        SortThread thread2 = new SortThread(arr2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Sorted Array 1: " + Arrays.toString(thread1.getSortedArray()));
        System.out.println("Sorted Array 2: " + Arrays.toString(thread2.getSortedArray()));
    }
}
