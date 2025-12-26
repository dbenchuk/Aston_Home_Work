import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompareNumbersTest {
    @DataProvider
    public Object[][] values() {
        return new Object[][] {
                {1, 1, 0},
                {1, 2, -1},
                {2, 1, 1}
        };
    }

    @Test(dataProvider = "values")
    public void compareNumbersTest(int x, int y, int expected) {
        Assert.assertEquals(CompareNumbers.compareTwoNumbers(x, y), expected);
    }
}