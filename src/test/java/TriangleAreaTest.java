import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleAreaTest {
    @DataProvider
    public Object[][] values() {
        return new Object[][] {
                {2, 3, 3},
                {3, 5, 7.5},
                {5, 8, 20}
        };
    }

    @Test(dataProvider = "values")
    public void triangleAreaTest(int a, int h, double expected) {
        Assert.assertEquals(TriangleArea.triangleArea(a, h), expected);
    }
}