import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FactorialTest {
    @DisplayName("Тестирование факториала числа")
    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,1",
            "2,2",
            "3,6",
            "4,24",
            "5,120"
    })
    public void factorialTest(int x, int expected) {
        Assertions.assertEquals(expected, Factorial.factorial(x));
    }
}