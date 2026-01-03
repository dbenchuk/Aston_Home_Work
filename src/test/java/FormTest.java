import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
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
        AccountReplenishmentForm title = new AccountReplenishmentForm(driver);

        Assertions.assertEquals("Онлайн пополнение без комиссии", title.getTitleText(title.titleList,0));
    }

    @DisplayName("Проверка логотипов платежных систем")
    @Test
    public void logoTest() {
        AccountReplenishmentForm image = new AccountReplenishmentForm(driver);

        Assertions.assertEquals(image.images[0], image.getImageInfo(image.imagesList, 0));
        Assertions.assertEquals(image.images[1], image.getImageInfo(image.imagesList, 1));
        Assertions.assertEquals(image.images[2], image.getImageInfo(image.imagesList, 2));
        Assertions.assertEquals(image.images[3], image.getImageInfo(image.imagesList, 3));
        Assertions.assertEquals(image.images[4], image.getImageInfo(image.imagesList, 4));
    }

    @DisplayName("Работоспособность ссылки \"Подробнее о сервисе\"")
    @Test
    public void linkTest() {
        AccountReplenishmentForm link = new AccountReplenishmentForm(driver);

        Assertions.assertEquals(link.newLink, link.getLink());
    }

    @DisplayName("Проверка кнопки \"Продолжить\"")
    @Test
    public void buttonTest() {
        AccountReplenishmentForm form = new AccountReplenishmentForm(driver);

        form.continueButtonClick();

        WebElement secondForm = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app-wrapper__content ng-tns-c4113268976-0']")));

        Assertions.assertEquals(form.phoneAndSum[1] + "BYN", form.removeAllSpaces(form.getTitleText(form.iframeElements, 0)));
        Assertions.assertEquals("Оплатить" + form.phoneAndSum[1] + "BYN", form.removeAllSpaces(form.getTitleText(form.iframeElements, 1)));
        Assertions.assertTrue(form.getTitleText(form.iframeElements, 2).contains("375" + form.phoneAndSum[0]));
        Assertions.assertEquals(form.placeholderName[6], form.getTitleText(form.iframeElements, 3));
        Assertions.assertEquals(form.placeholderName[7], form.getTitleText(form.iframeElements, 4));
        Assertions.assertEquals(form.placeholderName[8], form.getTitleText(form.iframeElements, 5));
        Assertions.assertEquals(form.placeholderName[9], form.getTitleText(form.iframeElements, 6));
        Assertions.assertEquals(form.images[5], form.getImageInfo(form.iframeElements, 7));
        Assertions.assertEquals(form.images[6], form.getImageInfo(form.iframeElements, 8));
        Assertions.assertEquals(form.images[7], form.getImageInfo(form.iframeElements, 9));
        Assertions.assertEquals(form.images[8], form.getImageInfo(form.iframeElements, 10));
        Assertions.assertEquals(form.images[9], form.getImageInfo(form.iframeElements, 11));

        driver.switchTo().defaultContent();
    }

    @DisplayName("Проверка названия полей в \"Услуги связи\"")
    @Test
    public void connectionFieldsNameTest() {
        AccountReplenishmentForm fieldName = new AccountReplenishmentForm(driver);
        Assertions.assertEquals(fieldName.placeholderName[0], fieldName.getFieldName(fieldName.phoneNumberFieldList, 0));
        Assertions.assertEquals(fieldName.placeholderName[2], fieldName.getFieldName(fieldName.sumFieldList, 0));
        Assertions.assertEquals(fieldName.placeholderName[3], fieldName.getFieldName(fieldName.emailFieldList, 0));
    }

    @DisplayName("Проверка названия полей в \"Домашний интернет\"")
    @Test
    public void internetFieldsNameTest() {
        AccountReplenishmentForm fieldName = new AccountReplenishmentForm(driver);

        fieldName.optionsMenu(1);

        Assertions.assertEquals(fieldName.placeholderName[1], fieldName.getFieldName(fieldName.phoneNumberFieldList, 1));
        Assertions.assertEquals(fieldName.placeholderName[2], fieldName.getFieldName(fieldName.sumFieldList, 1));
        Assertions.assertEquals(fieldName.placeholderName[3], fieldName.getFieldName(fieldName.emailFieldList, 1));
    }

    @DisplayName("Проверка названия полей в \"Рассрочка\"")
    @Test
    public void instalmentFieldsNameTest() {
        AccountReplenishmentForm fieldName = new AccountReplenishmentForm(driver);

        fieldName.optionsMenu(2);

        Assertions.assertEquals(fieldName.placeholderName[4], fieldName.getFieldName(fieldName.accountNumberFieldList, 0));
        Assertions.assertEquals(fieldName.placeholderName[2], fieldName.getFieldName(fieldName.sumFieldList, 2));
        Assertions.assertEquals(fieldName.placeholderName[3], fieldName.getFieldName(fieldName.emailFieldList, 2));
    }

    @DisplayName("Проверка названия полей в \"Задолженность\"")
    @Test
    public void arrearsFieldsNameTest() {
        AccountReplenishmentForm fieldName = new AccountReplenishmentForm(driver);

        fieldName.optionsMenu(3);

        Assertions.assertEquals(fieldName.placeholderName[5], fieldName.getFieldName(fieldName.accountNumberFieldList, 1));
        Assertions.assertEquals(fieldName.placeholderName[2], fieldName.getFieldName(fieldName.sumFieldList, 3));
        Assertions.assertEquals(fieldName.placeholderName[3], fieldName.getFieldName(fieldName.emailFieldList, 3));
    }
}