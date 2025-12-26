import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleAreaTest {
    @DisplayName("Тестирование площади треугольника")
    @ParameterizedTest
    @CsvSource({
            "2, 3, 3",
            "3, 5, 7.5",
            "5, 8, 20"
    })
    public void triangleAreaTest(int a, int h, double expected) {
        Assertions.assertEquals(expected, TriangleArea.triangleArea(a, h));
    }
}