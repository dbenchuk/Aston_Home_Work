import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CompareNumbersTest {
    @DisplayName("Тестирование сравнения чисел")
    @ParameterizedTest
    @CsvSource({
            "1, 1, 0",
            "1, 2, -1",
            "2, 1, 1"
    })
    public void compareNumbersTest(int x, int y, int expected) {
        Assertions.assertEquals(expected, CompareNumbers.compareTwoNumbers(x, y));
    }
}