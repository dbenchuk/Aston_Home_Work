public class Main {
    public static void main(String[] args) {
        String[][] firstArray = {
                {"1", "2", "3", "4"},
                {"4", "1", "5", "5"},
                {"6", "7", "1", "8"},
                {"9", "10", "11", "12"}
        };

        String[][] seecondArray = {
                {"1", "2", "3"},
                {"4", "a", "5"},
                {"6", "7", "b"}
        };

        String[][] thirdArray = {
                {"1", "2", "3", "4"},
                {"4", "a", "5", "5"},
                {"6", "7", "1", "8"},
                {"9", "10", "11", "12"}
        };

        try {
            getArray(firstArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            getArray(seecondArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            getArray(thirdArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        int[] someArray = {1,2,3,4,5,6,7,8,9};

        try {
            findArrayIndexOutOfBoundsException(someArray, 15);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (array.length != 4)
            throw new MyArraySizeException("Размер массива не равен 4х4");

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException("Размер массива не равен 4х4");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не удалось преобразовать ячейку " + i + " " + j);
                }
            }
        }

        System.out.println("Сумма равна " + sum);
    }

    public static void findArrayIndexOutOfBoundsException(int[] array, int a) throws ArrayIndexOutOfBoundsException {
        if (a > array.length)
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        else
            System.out.println(array[a]);
    }
}