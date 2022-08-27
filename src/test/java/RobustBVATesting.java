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

public class RobustBVATesting {
    public static final String EMAIL_ID = "2021ct93022@wilp.bits-pilani.ac.in";
    public static final String PASSWORD = "Hello12#";
    public static final String BASE_WEB_URL = "https://www.sapnaonline.com/";
    public static final String CHROME_DRIVER_ABSOLUTE_PATH = "C:\\webdrivers\\chromedriver.exe";
    WebDriver driver;

    @BeforeTest
    void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_ABSOLUTE_PATH);
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
        assertEquals("Email is required", element.getText());

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
        assertEquals("Please enter a valid email", element.getText());
    }

    // less than 6
    @Test
    void pwdlenlessthansix_Test1() {
        driver.get(BASE_WEB_URL);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys(EMAIL_ID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys("snflu");
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Password length should be between 6 and 20 characters')]"));
        assertEquals("Password length should be between 6 and 20 characters", element.getText());

    }

// pwd length more than 20

    @Test
    void Invalid_lenpwd_twenty_Test2() {
        driver.get(BASE_WEB_URL);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys(EMAIL_ID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys("dfngkdlgnkdfgnngjyhjj");
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Password length should be between 6 and 20 characters')]"));
        assertEquals("Password length should be between 6 and 20 characters", element.getText());
    }

    // pwd length seven
    @Test
    void pwdlenlessthanmorethansix_Test3() {
        driver.get(BASE_WEB_URL);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys(EMAIL_ID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys("snfluui");
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();

    }

    // pwd length six
    @Test
    void pwdlensix_Test4() {
        driver.get(BASE_WEB_URL);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys(EMAIL_ID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys("snfluu");
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();

    }

    // pwd length nineteen
    @Test
    void valid_lenpwd_nineteen_Test5() {
        driver.get(BASE_WEB_URL);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys(EMAIL_ID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys("dfngkdlgnkdfgnngjyh");
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();
    }

//pwd length twenty

    @Test
    void valid_lenpwd_twenty_Test6() {
        driver.get(BASE_WEB_URL);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys(EMAIL_ID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys("dfngkdlgnkdfgnngjyhj");
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();
    }


    //nominal
    @Test
    void valid_nominal_Test7() {
        driver.get(BASE_WEB_URL);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys(EMAIL_ID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys("dfngkdlgnkdfg");
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();
    }


    @AfterTest
    void tearDown() {
        driver.close();
    }
}

