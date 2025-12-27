import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.mts.by/");

        WebElement cookie = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn_black cookie__ok']")));

        cookie.click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @BeforeEach
    public void precondition() {
        driver.get("https://www.mts.by/");
    }

    @DisplayName("Проверка названия формы")
    @Test
    public void titleTest() {
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']/h2")));

        Assertions.assertEquals("Онлайн пополнение без комиссии", title.getAttribute("textContent"));
    }

    @DisplayName("Проверка логотипов платежных систем")
    @Test
    public void logoTest() {
        WebElement visaLogo = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg']"));
        WebElement verifiedByVisaLogo = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg']"));
        WebElement masterCard = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg']"));
        WebElement masterCardSecureCode = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg']"));
        WebElement belkart = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg']"));

        Assertions.assertEquals("https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg", visaLogo.getAttribute("src"));
        Assertions.assertEquals("https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg", verifiedByVisaLogo.getAttribute("src"));
        Assertions.assertEquals("https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg", masterCard.getAttribute("src"));
        Assertions.assertEquals("https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg", masterCardSecureCode.getAttribute("src"));
        Assertions.assertEquals("https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg", belkart.getAttribute("src"));
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
    public void buttonTest() throws InterruptedException {
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement sumField = driver.findElement(By.xpath("//input[@placeholder='Сумма'][@id='connection-sum']"));
        WebElement button = driver.findElement(By.xpath("//form[@id='pay-connection']//button[text()='Продолжить']"));

        phoneNumberField.click();
        phoneNumberField.sendKeys("297777777");

        sumField.click();
        sumField.sendKeys("10");

        button.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));

        driver.switchTo().frame(iframe);

        WebElement secondForm = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app-wrapper__content ng-tns-c4113268976-0']")));

        driver.switchTo().defaultContent();
    }
}