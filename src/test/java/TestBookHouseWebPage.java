import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestBookHouseWebPage {
    public static final String EMAIL_ID = "2021ct93022@wilp.bits-pilani.ac.in";
    public static final String PASSWORD = "Hello12#";
    public static final String BASE_WEB_URL = "https://www.sapnaonline.com/";
    public static final String FIREFOX_DRIVER_ABSOLUTE_PATH = "C:\\Users\\KR-PC\\Desktop\\BITS Mtech. Software Engineering program\\Sem-2\\3.Software-Testing-Methodologies\\Assignment\\geckodriver.exe";
    WebDriver driver;

    @BeforeTest
    void setUp() {
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_ABSOLUTE_PATH);
        driver = new FirefoxDriver();
    }

    @Test
    void titleTest() {
        String expectedWebsiteTitle = "Buy Books Online , Bookstore India, Shop for 2022 Books";
        String actualWebsiteTitle = "";

        driver.get(BASE_WEB_URL);
        actualWebsiteTitle = driver.getTitle();

        assertEquals(actualWebsiteTitle, expectedWebsiteTitle);
    }

    @Test
    void loginFormTest() {
        driver.get(BASE_WEB_URL);
        //User login
        loginWithUserCredentials();
    }

    @Test
    void searchTextbookFromSearchBar() {
        driver.get(BASE_WEB_URL);

        //Search S/W Testing Book.
        driver.findElement(By.id("keyword")).sendKeys("Software Testing – A Craftsman’s Approach, Fourth Edition, Paul C Jorgenson, CRC Press");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Assert with no of results found for the search of Books.
        String searchFoundText = driver.findElement(By.xpath("//div[@class='sc-Axmtr gsVDHI']")).getText();
        assertEquals("(175 results found)", searchFoundText);
    }


    @Test
    void logOutTest() {
        driver.get(BASE_WEB_URL);
        //User login
        loginWithUserCredentials();
        //CLick on My Account
        clickOnMyAccountElement();

        // Add code for log-out.
        driver.findElement(By.xpath("//div[contains(text(),'Logout')]")).click();
    }

    @Test
    void validateProfileDetailsPostLogin() {
        driver.get(BASE_WEB_URL);
        //User login
        loginWithUserCredentials();

        clickOnMyAccountElement();

        driver.findElement(By.xpath("//div[contains(text(),'My Profile')]")).click();
        WebElement fullNameElement;
        WebDriverWait wait = new WebDriverWait(driver, 100);
        fullNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sc-AxirZ iiXpac']//div[@class='ui input web-rx input sc-fznZeY cAabCB']//input[@type='text']")));
        assertEquals("Karthik R", fullNameElement.getText());
    }

    private void loginWithUserCredentials() {
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr cTkVAB']")).click();
        driver.findElement(By.cssSelector("a[class = 'item']")).click();
        driver.findElement(By.cssSelector("input[type = email]")).sendKeys(EMAIL_ID);
        driver.findElement(By.cssSelector("input[type = password]")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("div[class = 'sc-Axmtr iPDAko ButtonText']")).click();
    }

    private void clickOnMyAccountElement() {
        WebElement myAccountElement;
        WebDriverWait wait = new WebDriverWait(driver, 100);
        myAccountElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//div[@class='sc-AxhCb ghXQuW']"))));
        myAccountElement.click();
    }

    @AfterTest
    void tearDown() {
        driver.close();
    }
}
