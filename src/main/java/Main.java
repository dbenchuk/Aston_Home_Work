import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("____Task_1____\n***************");
        LogicalClass.printThreeWords();
        System.out.println("***************\n");

        System.out.println("____Task_2____\n***************");
        System.out.println(LogicalClass.checkSumSign());
        System.out.println("***************\n");

        System.out.println("____Task_3____\n***************");
        LogicalClass.printColor();
        System.out.println("***************\n");

        System.out.println("____Task_4____\n***************");
        System.out.println(LogicalClass.compareNumbers());
        System.out.println("***************\n");

        System.out.println("____Task_5____\n***************");
        System.out.println(LogicalClass.compareSum(5,25));
        System.out.println("***************\n");

        System.out.println("____Task_6____\n***************");
        System.out.println(LogicalClass.checkPositive(2));
        System.out.println("***************\n");

        System.out.println("____Task_7____\n***************");
        System.out.println(LogicalClass.checkSign(-5));
        System.out.println("***************\n");

        System.out.println("____Task_8____\n***************");
        LogicalClass.printSomeString("Hello World", 3);
        System.out.println("***************\n");

        System.out.println("____Task_9____\n***************");
        System.out.println(LogicalClass.cheсkYear(2025));
        System.out.println("***************\n");

        System.out.println("____Task_10____\n***************");
        LogicalClass.changeElements();
        System.out.println("***************\n");

        System.out.println("____Task_11____\n***************");
        System.out.println(Arrays.toString(LogicalClass.fillArray()));
        System.out.println("***************\n");

        System.out.println("____Task_12____\n***************");
        LogicalClass.multiplyElements();
        System.out.println("***************\n");

        System.out.println("____Task_13____\n***************");
        LogicalClass.fillDiagonalByOne();
        System.out.println("***************\n");

        System.out.println("____Task_14____\n***************");
        System.out.println(Arrays.toString(LogicalClass.createArray(5,1)));
        System.out.println("***************\n");
    }
}