import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormTest {
    private static WebDriver driver;
    private static String baseUrl = "https://www.mts.by/";

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get(baseUrl);

        WebElement cookie = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn_black cookie__ok']")));

        cookie.click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @BeforeEach
    public void precondition() {
        driver.get(baseUrl);
    }

    @DisplayName("Проверка названия формы")
    @Test
    public void titleTest() {
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']/h2")));

        Assertions.assertEquals("Онлайн пополнение без комиссии", title.getAttribute("textContent"));
    }

    @DisplayName("Проверка логотипов платежных систем")
    @ParameterizedTest
    @CsvSource({
            "//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg'], https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg",
            "//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg'], https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg",
            "//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg'], https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg",
            "//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg'], https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg",
            "//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg'], https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg"
    })
    public void logoTest(String actual, String expected) {
        WebElement element = driver.findElement(By.xpath(actual));
        Assertions.assertEquals(expected, element.getAttribute("src"));
    }

    @DisplayName("Работоспособность ссылки \"Подробнее о сервисе\"")
    @Test
    public void linkTest() {
        WebElement link = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));

        link.click();

        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @DisplayName("Проверка кнопки \"Продолжить\"")
    @Test
    public void buttonTest() {
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement sumField = driver.findElement(By.xpath("//input[@placeholder='Сумма'][@id='connection-sum']"));
        WebElement button = driver.findElement(By.xpath("//form[@id='pay-connection']//button[text()='Продолжить']"));

        phoneNumberField.click();
        phoneNumberField.sendKeys("297777777");

        sumField.click();
        sumField.sendKeys("10");

        button.click();

        WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='payment-widget-iframe']")));
        driver.switchTo().frame(iframe);

        WebElement secondForm = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app-wrapper__content ng-tns-c4113268976-0']")));

        assertTrue(secondForm.isDisplayed());

        driver.switchTo().defaultContent();
    }
}