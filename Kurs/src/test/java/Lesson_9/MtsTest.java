package Lesson_9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsTest
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
    public void testTitle()
    {
        String correctTitle = "Онлайн пополнение без комиссии";
        WebElement validTitle = driver.findElement(By.name("Онлайн пополнение без комиссии"));
        Assertions.assertEquals(correctTitle, validTitle.getText());
    }

    @Test
    public void testLogos()
    {
        Assertions.assertTrue(driver.findElement(By.name("Visa")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.name("Verified By Visa")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.name("MasterCard")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.name("MasterCard Secure Code")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.name("Белкарт")).isDisplayed());
    }

    @Test
    public void testInfoLink()
    {
        WebElement moreInfo = driver.findElement(By.name("Подробнее о сервисе"));
        String originalWindow = driver.getWindowHandle();

        moreInfo.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles())
        {
            if (!windowHandle.equals(originalWindow))
            {
                driver.switchTo().window(windowHandle);
                Assertions.assertTrue(driver.getTitle().contains("Порядок оплаты и безопасность интернет платежей"));
                driver.close();
            }
        }
        driver.switchTo().window(originalWindow);
    }

    @Test
    public void testContinueButton()
    {
        WebElement buttonContinue = driver.findElement(By.name("Продолжить"));
        WebElement phoneNumber = driver.findElement(By.name("+375"));
        phoneNumber.sendKeys("297777777");
        WebElement price = driver.findElement(By.name("Руб."));
        price.sendKeys("1");
        buttonContinue.click();

        wait.until(ExpectedConditions.titleContains("BePaidWidget"));
        Assertions.assertTrue(driver.getTitle().contains("BePaidWidget"));
    }
}
