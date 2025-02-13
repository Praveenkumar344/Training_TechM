public class javaIOmethod10Feb {
    public static void main(String[] args) {
        print();
        println();
        javaIO10Febmethod obj = new javaIO10Febmethod();
        obj.err();
    }

    static void print() {
        System.out.print("print 1");
        System.out.print("print 2");
    }

    static void println() {
        System.out.println("println 1");
        System.out.println("println 2");
    }

    void err() {
        System.err.println("err 1");
        System.err.println("err 2");
    }
}
