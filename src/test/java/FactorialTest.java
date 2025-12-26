import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest {
    @DataProvider
    public Object[][] values() {
        return new Object[][] {
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6}
        };
    }

    @Test(dataProvider = "values")
    public void factorialTest(int x, int expected) {
        Assert.assertEquals(Factorial.factorial(x), expected);
    }
}