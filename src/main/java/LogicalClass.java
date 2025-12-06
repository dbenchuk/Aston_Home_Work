import java.util.Arrays;

public class LogicalClass {
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static String checkSumSign() {
        int a = 3, b = 5;
        String str;
        return str = (a + b) >= 0 ? "Сумма положительная" : "Сумма отрицательная";
    }

    public static void printColor() {
        int value = 500;

        if (value <= 0)
            System.out.println("Красный");
        else if (value > 0 && value <= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }

    public static String compareNumbers() {
        int a = 50, b = 10;
        String str;

        return str = (a >= b) ? "a >= b" : "a < b";
    }

    public static boolean compareSum(int x, int y) {
        return ((x + y) >= 10 && (x + y) <= 20);
    }

    public static String checkPositive(int x) {
        String str;

        return str = x >= 0 ? "Число положительное" : "Число отрицательное";
    }

    public static boolean checkSign(int x) {
        return !(x >= 0);
    }

    public static void printSomeString(String str, int count) {
        for (int i = 0; i < count; i++)
            System.out.println(str);
    }

    public static boolean cheсkYear(int year) {
        return (((year % 4) == 0) && ((year % 100) != 0) || (year % 400) == 0);
    }

    public static void changeElements() {
        int[] arr = {1,0,0,1,1,0,0,1};

        System.out.println("Исходный массив: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i] == 0 ? 1 : 0;

        System.out.println("Измененный массив: " + Arrays.toString(arr));
    }

    public static int[] fillArray() {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++)
            arr[i] = i + 1;

        return arr;
    }

    public static void multiplyElements() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Исходный массив: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i] < 6 ? arr[i] * 6 : arr[i];

        System.out.println("Измененный массив: " + Arrays.toString(arr));
    }

    public static void fillDiagonalByOne() {
        int[][] arr = new int[9][9];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j)
                    arr[i][j] = 1;
                else if (i + j == arr[i].length - 1)
                    arr[i][j] = 1;

                System.out.print(arr[i][j]);
            }

            System.out.println();
        }
    }

    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++)
            arr[i] = initialValue;

        return arr;
    }
}
