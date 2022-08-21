import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestBookHouseWebPageExistingUser {
    public static final String EMAIL_ID = "2021ct93022@wilp.bits-pilani.ac.in";
    public static final String PASSWORD = "Hello12#";
    public static final String BASE_WEB_URL = "https://www.sapnaonline.com/";
    public static final String FIREFOX_DRIVER_ABSOLUTE_PATH = "C:\\webdrivers\\chromedriver.exe";
    WebDriver driver;

    @BeforeTest
    void setUp() {
        System.setProperty("webdriver.chrome.driver", FIREFOX_DRIVER_ABSOLUTE_PATH);
        driver = new ChromeDriver();
    }

    @Test
    void exit_Email_blankTest() {
        driver.get(BASE_WEB_URL);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys(" ");
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Email is required')]"));
        assertEquals("Email is required",element.getText());

    }
@Test
     void exit_InvalidEmailTest() {
        driver.get(BASE_WEB_URL);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys("ksnmdksfmn");
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Please enter a valid email')]"));
        assertEquals("Please enter a valid email",element.getText());
    }

    @Test
    void exit_Invalid_lenpwdTest() {
        driver.get(BASE_WEB_URL);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys(EMAIL_ID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys("snfl");
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Password length should be between 6 and 20 characters')]"));
        assertEquals("Password length should be between 6 and 20 characters",element.getText());

    }

//    @Test
//    void exit_Incorrect_pwdTest() {
//
//        driver.get(BASE_WEB_URL);
//        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
//        WebElement emailElement = driver.findElement(By.id("email"));
//        emailElement.sendKeys(" ");
//        WebElement passwordElement = driver.findElement(By.id("pass"));
//        passwordElement.sendKeys("your password here");
//        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();
//
//    }




    @AfterTest
    void tearDown() {
        driver.close();
    }
}

