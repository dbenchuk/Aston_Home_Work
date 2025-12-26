import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArithmeticOperationTest {
    @DataProvider
    public Object[][] sumValues() {
        return new Object[][] {
                {1, 1, 2},
                {2, 2, 4},
                {5, 2, 7}
        };
    }

    @Test(dataProvider = "sumValues")
    public void sumTest(int x, int y, int expected) {
        Assert.assertEquals(ArithmeticOperations.sum(x, y), expected);
    }

    @DataProvider
    public Object[][] differenceValues() {
        return new Object[][] {
                {2, 2, 0},
                {1, 2, -1},
                {10, 5, 5}
        };
    }

    @Test(dataProvider = "differenceValues")
    public void differenceTest(int x, int y, int expected) {
        Assert.assertEquals(ArithmeticOperations.difference(x, y), expected);
    }

    @DataProvider
    public Object[][] multiplyValues() {
        return new Object[][] {
                {2, 2, 4},
                {1, 2, 2},
                {10, -5, -50}
        };
    }

    @Test(dataProvider = "multiplyValues")
    public void multiplyTest(int x, int y, int expected) {
        Assert.assertEquals(ArithmeticOperations.multiply(x, y), expected);
    }

    @DataProvider
    public Object[][] divideValues() {
        return new Object[][] {
                {2, 2, 1},
                {5, 2, 2.5},
                {10, -5, -2}
        };
    }

    @Test(dataProvider = "divideValues")
    public void divideTest(int x, int y, double expected) {
        Assert.assertEquals(ArithmeticOperations.divide(x, y), expected);
    }
}