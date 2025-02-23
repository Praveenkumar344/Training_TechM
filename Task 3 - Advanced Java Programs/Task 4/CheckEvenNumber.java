class OddNumberException extends Exception {
    public OddNumberException(String message) {
        super(message);
    }
}

public class CheckEvenNumber {
    public static void checkEven(int num) throws OddNumberException {
        if (num % 2 != 0) {
            throw new OddNumberException("Number is odd!");
        }
        System.out.println("Number is even.");
    }

    public static void main(String[] args) {
        try {
            checkEven(5);
        } catch (OddNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
