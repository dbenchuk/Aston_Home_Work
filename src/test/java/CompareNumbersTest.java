import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CompareNumbersTest {
    @DisplayName("Тестирование сравнения чисел")
    @ParameterizedTest
    @CsvSource({
            "1, 1, true",
            "1, 2, false",
            "2, 1, false"
    })
    public void compareNumbersTest(int x, int y, boolean expected) {
        Assertions.assertEquals(expected, CompareNumbers.compareTwoNumbers(x, y));
    }
}