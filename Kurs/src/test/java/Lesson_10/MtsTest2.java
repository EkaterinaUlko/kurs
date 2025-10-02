package Lesson_10;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class MtsTest2
{
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resourses/chromedriver-win64.zip");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://mts.by");
    }

    @Test
    public void testPlaceholder()
    {
        WebElement dropdown = driver.findElement(By.id("pay"));
        Select select = new Select(dropdown);

        WebElement servicesphone = driver.findElement(By.id("connection-phone"));
        WebElement servicesamount = driver.findElement(By.id("connection-sum"));
        WebElement servicesemail = driver.findElement(By.id("connection-email"));
        WebElement internetphone = driver.findElement(By.id("internet-phone"));
        WebElement internetamount = driver.findElement(By.id("internet-sum"));
        WebElement internetemail = driver.findElement(By.id("internet-email"));
        WebElement installmentphone = driver.findElement(By.id("score-instalment"));
        WebElement installmentamount = driver.findElement(By.id("instalment-sum"));
        WebElement installmentemail = driver.findElement(By.id("instalment-email"));
        WebElement debtphone = driver.findElement(By.id("score-arrears"));
        WebElement debtamount = driver.findElement(By.id("arrears-sum"));
        WebElement debtemail = driver.findElement(By.id("arrears-email"));

        select.selectByVisibleText("Услуги связи");
        String placeholderText = servicesphone.getAttribute("placeholder");
        Assertions.assertEquals("Номер телефона", placeholderText);
        placeholderText = servicesamount.getAttribute("placeholder");
        Assertions.assertEquals("Сумма", placeholderText);
        placeholderText = servicesemail.getAttribute("placeholder");
        Assertions.assertEquals("E-mail для отправки чека", placeholderText);

        select.selectByVisibleText("Домашний интернет");
        placeholderText = internetphone.getAttribute("placeholder");
        Assertions.assertEquals("Номер абонента", placeholderText);
        placeholderText = internetamount.getAttribute("placeholder");
        Assertions.assertEquals("Сумма", placeholderText);
        placeholderText = internetemail.getAttribute("placeholder");
        Assertions.assertEquals("E-mail для отправки чека", placeholderText);

        select.selectByVisibleText("Рассрочка");
        placeholderText = installmentphone.getAttribute("placeholder");
        Assertions.assertEquals("Номер счета на 44", placeholderText);
        placeholderText = installmentamount.getAttribute("placeholder");
        Assertions.assertEquals("Сумма", placeholderText);
        placeholderText = installmentemail.getAttribute("placeholder");
        Assertions.assertEquals("E-mail для отправки чека", placeholderText);

        select.selectByVisibleText("Задолженность");
        placeholderText = debtphone.getAttribute("placeholder");
        Assertions.assertEquals("Номер счета на 2073", placeholderText);
        placeholderText = debtamount.getAttribute("placeholder");
        Assertions.assertEquals("Сумма", placeholderText);
        placeholderText = debtemail.getAttribute("placeholder");
        Assertions.assertEquals("E-mail для отправки чека", placeholderText);

        select.selectByVisibleText("Услуги связи");
    }

    @Test
    public void testContinueButton()
    {
        WebElement buttonContinue = driver.findElement(By.name("Продолжить"));
        WebElement phoneNumber = driver.findElement(By.id("connection-phone"));
        WebElement price = driver.findElement(By.id("connection-sum"));
        WebElement phoneString = driver.findElement(By.xpath("//div[@class='pay-description__text']"));
        String phoneText = phoneString.getText();
        WebElement priceString = driver.findElement(By.xpath("//span[@class='ng-star-inserted' and text()='1.00 BYN']"));
        String priceText = priceString.getText();
        WebElement buttonPay = driver.findElement(By.xpath("//span[@_ngcontent-ng-c377538805 and text()='Оплатить 1.00 BYN']"));
        String buttonText = buttonPay.getText();
        WebElement cardNumber = driver.findElement(By.xpath("//input@formcontrolname='creditCard'"));
        WebElement cardDate = driver.findElement(By.xpath("//input@formcontrolname='expirationDate'"));
        WebElement cardName = driver.findElement(By.xpath("//input@formcontrolname='holder'"));
        WebElement cardCvc = driver.findElement(By.xpath("//input@formcontrolname='cvc'"));


        phoneNumber.sendKeys("297777777");
        price.sendKeys("1");
        buttonContinue.click();

        wait.until(ExpectedConditions.titleContains("BePaidWidget"));
        Assertions.assertTrue(driver.getTitle().contains("BePaidWidget"));

        Assert.assertEquals(phoneText, "Оплата: Услуги связи Номер:375297777777");
        Assert.assertEquals(priceText, "1.00 BYN");
        Assert.assertEquals(buttonText, "Оплатить 1.00 BYN");

        String placeholderText = cardNumber.getAttribute("placeholder");
        Assertions.assertEquals("Номер карты", placeholderText);
        placeholderText = cardDate.getAttribute("placeholder");
        Assertions.assertEquals("Срок действия", placeholderText);
        placeholderText = cardName.getAttribute("placeholder");
        Assertions.assertEquals("Имя и фамилия на карте", placeholderText);
        placeholderText = cardCvc.getAttribute("placeholder");
        Assertions.assertEquals("CVC", placeholderText);

        Assertions.assertTrue(driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']")).isDisplayed());
    }
}
