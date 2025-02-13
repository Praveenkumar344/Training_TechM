import java.lang.Thread;

public class Thread11feb {
    public static void main(String[] args) {

        ThreadRunnableThree t3 = new ThreadRunnableThree();
        ThreadRunnableTwo t2 = new ThreadRunnableTwo();
        ThreadRunnableOne t1 = new ThreadRunnableOne();
        t3.start();
        t3.start();
        t3.start();

        t2.start();
        t2.start();

        t1.start();
    }
}

class ThreadRunnableThree extends Thread {
    public void run() {
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
    }
}

class ThreadRunnableTwo extends Thread {
    public void run() {
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
    }
}

class ThreadRunnableOne extends Thread {
    public void run() {
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
    }
}
