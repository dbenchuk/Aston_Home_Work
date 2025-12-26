import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArithmeticOperationsTest {
    @DisplayName("Тестирование суммы")
    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "1, 2, 3",
            "2, 2, 4"
    })
    public void sumTest(int x, int y, int expected) {
        Assertions.assertEquals(expected, ArithmeticOperations.sum(x, y));
    }

    @DisplayName("Тестирование разницы")
    @ParameterizedTest
    @CsvSource({
            "2, 2, 0",
            "1, 2, -1",
            "10, 5, 5"
    })
    public void differenceTest(int x, int y, int expected) {
        Assertions.assertEquals(expected, ArithmeticOperations.difference(x, y));
    }

    @DisplayName("Тестирование произведения")
    @ParameterizedTest
    @CsvSource({
            "2, 2, 4",
            "1, 2, 2",
            "10, -5, -50"
    })
    public void multiplyTest(int x, int y, int expected) {
        Assertions.assertEquals(expected, ArithmeticOperations.multiply(x, y));
    }

    @DisplayName("Тестирование деления")
    @ParameterizedTest
    @CsvSource({
            "2, 2, 1",
            "5, 2, 2.5",
            "10, -5, -2"
    })
    public void divideTest(int x, int y, double expected) {
        Assertions.assertEquals(expected, ArithmeticOperations.divide(x, y));
    }
}