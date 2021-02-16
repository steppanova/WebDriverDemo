import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverDemoTest {
    SearchDetails search = new SearchDetails();
    WebDriverDemo webDriver = new WebDriverDemo();
    String result;
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        search.setBrowserName("http://www.google.com");
        search.setFindWord("java");
        search.setProperty("webdriver.chrome.driver");
        search.setUrl("E:\\ChromeDriver\\chromedriver.exe");
    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty(search.getProperty(), search.getUrl());
        driver = new ChromeDriver();
        driver.get(search.getBrowserName());
        driver.findElement(By.name("q")).sendKeys(search.getFindWord());
        // Get attribute of current active element
        result = driver.switchTo().activeElement().getAttribute("title");

    }

    @Test
    public void findInBrowse() {
        String title = webDriver.findInBrowse(search);
        Assert.assertEquals(result, title);

    }

    @AfterTest
    public void afterSuite() {
        driver.quit();

    }

}
