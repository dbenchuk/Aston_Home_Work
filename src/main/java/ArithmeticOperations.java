public class ArithmeticOperations {
    public static int sum(int x, int y) {
        return x + y;
    }

    public static int difference(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static double divide(int x, int y) {
        if (y == 0)
            throw new IllegalArgumentException("Деление на 0!!!");
        else
            return (double) x / y;
    }
}