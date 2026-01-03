import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AccountReplenishmentForm {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By iFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By link = By.xpath("//a[text()='Подробнее о сервисе']");
    final String newLink = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

    List<By> titleList = new ArrayList<>(List.of(
        By.xpath("//div[@class='pay__wrapper']/h2")
    ));

    List<By> optionsList = new ArrayList<>(List.of(
        By.xpath("//button[@class='select__header']"),
        By.xpath("//p[@class='select__option'][text()='Домашний интернет']"),
        By.xpath("//p[@class='select__option'][text()='Рассрочка']"),
        By.xpath("//p[@class='select__option'][text()='Задолженность']")
    ));

    List<By> phoneNumberFieldList = new ArrayList<>(List.of(
            By.xpath("//input[@id='connection-phone']"),    //услуги связи
            By.xpath("//input[@id='internet-phone']")       //домашний интернет
    ));

    List<By> sumFieldList = new ArrayList<>(List.of(
            By.xpath("//input[@id='connection-sum']"),      //услуги связи
            By.xpath("//input[@id='internet-sum']"),        //домашний интернет
            By.xpath("//input[@id='instalment-sum']"),      //рассрочка
            By.xpath("//input[@id='arrears-sum']")          //задолженность
    ));

    List<By> emailFieldList = new ArrayList<>(List.of(
            By.xpath("//input[@id='connection-email']"),    //услуги связи
            By.xpath("//input[@id='internet-email']"),      //домашний интернет
            By.xpath("//input[@id='instalment-email']"),    //рассрочка
            By.xpath("//input[@id='arrears-email']")        //задолженность
    ));

    List<By> accountNumberFieldList = new ArrayList<>(List.of(
            By.xpath("//input[@id='score-instalment']"),    //рассрочка
            By.xpath("//input[@id='score-arrears']")        //задолженность
    ));

    List<By> continueButtonList = new ArrayList<>(List.of(
            By.xpath("//form[@id='pay-connection']/button"),      //услуги связи
            By.xpath("//form[@id='pay-internet']/button"),        //домашний интернет
            By.xpath("//form[@id='pay-instalment']/button"),      //рассрочка
            By.xpath("//form[@id='pay-arrears']/button")          //задолженность
    ));

    List<By> imagesList = new ArrayList<>(List.of(
        By.xpath("//img[@alt='Visa']"),
        By.xpath("//img[@alt='Verified By Visa']"),
        By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg']"),
        By.xpath("//img[@alt='MasterCard Secure Code']"),
        By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg']")
    ));

    String[] placeholderName = {
            "Номер телефона",
            "Номер абонента",
            "Сумма",
            "E-mail для отправки чека",
            "Номер счета на 44",
            "Номер счета на 2073",
            "Номер карты",
            "Срок действия",
            "CVC",
            "Имя и фамилия на карте"
    };

    String[] phoneAndSum = {
            "297777777",
            "10.00"
    };

    String[] images = {
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg",
            "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/maestro-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system-ru.svg"
    };

    List<By> iframeElements = new ArrayList<>(List.of(
            By.xpath("//span[@class='ng-star-inserted']"), //сумма в верхнем левом углу формы
            By.xpath("//button[@class='colored disabled']"), //сумма на кнопке
            By.xpath("//div[@class='pay-description__text']"), //номер телефона
            By.xpath("//label[@class='ng-tns-c2312288139-2 ng-star-inserted']"), //номер карты
            By.xpath("//label[@class='ng-tns-c2312288139-4 ng-star-inserted']"), //срок действия карты
            By.xpath("//label[@class='ng-tns-c2312288139-5 ng-star-inserted']"), //CVC
            By.xpath("//label[@class='ng-tns-c2312288139-3 ng-star-inserted']"), //Имя и фамилия
            By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']"), //visaImg
            By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"), //mastercardImg
            By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"), //belkartImg
            By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']"), //maestrocardImg
            By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']")  //mirImg
    ));

    public AccountReplenishmentForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getTitleText(List<By> list, int x) {
        WebElement titleName = wait.until(ExpectedConditions.visibilityOfElementLocated(list.get(x)));

        return titleName.getAttribute("textContent");
    }

    public String getImageInfo(List<By> list, int x) {
        WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(list.get(x)));

        return image.getAttribute("src");
    }

    public String getLink() {
        WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(link));
        image.click();

        return driver.getCurrentUrl();
    }

    public void continueButtonClick() {
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberFieldList.get(0)));
        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(sumFieldList.get(0)));
        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(continueButtonList.get(0)));

        phoneNumberField.click();
        phoneNumberField.sendKeys(phoneAndSum[0]);

        sumField.click();
        sumField.sendKeys(phoneAndSum[1]);

        continueButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iFrame));

        driver.switchTo().frame(iframe);
    }

    public String getFieldName(List<By> list, int x) {
        WebElement element = driver.findElement(list.get(x));

        return element.getAttribute("placeholder");
    }

    public AccountReplenishmentForm optionsMenu(int x) {
        wait.until(ExpectedConditions.elementToBeClickable(optionsList.get(0))).click();
        wait.until(ExpectedConditions.elementToBeClickable(optionsList.get(x))).click();

        return this;
    }

    public String removeAllSpaces(String input) {
        return input.replaceAll("\\s+", "");
    }
}