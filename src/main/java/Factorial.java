public class Factorial {
    public static int factorial(int x) {
        int result = 1;

        if (x > 0) {
            for (int i = 1; i <= x; i++)
                result *= i;
        }
        else if (x == 0)
            result = 1;
        else
            throw new IllegalArgumentException("x не может быть отрицательным");

        return result;
    }
}