import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompareNumbersTest {
    @DataProvider
    public Object[][] values() {
        return new Object[][] {
                {1, 1, true},
                {1, 2, false},
                {2, 1, false}
        };
    }

    @Test(dataProvider = "values")
    public void compareNumbersTest(int x, int y, boolean expected) {
        Assert.assertEquals(CompareNumbers.compareTwoNumbers(x, y), expected);
    }
}