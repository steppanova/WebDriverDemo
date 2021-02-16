import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverDemoTest {
    WebDriverDemo webDriver = new WebDriverDemo();
    SearchForm searchForm;
    PageHomeBrowser page;
    String result;
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new PageHomeBrowser(driver);
        page.initialized();
        searchForm = new SearchForm(driver);
        searchForm.setName();
        result = searchForm.findResult();
    }
    @Test
    public void findInBrowse() {
        String title = webDriver.findInBrowse(page.search);
        Assert.assertEquals(result, title);
    }
    @AfterTest
    public void afterSuite() {
        driver.quit();
    }
}
class SearchForm{
    WebDriver driver;
    By name = By.name("q");
    String wordSearch = "java";
    String findWord = "title";
    public SearchForm(WebDriver driver) {
        this.driver = driver;
    }
    public void setName (){
        driver.findElement(name).sendKeys(wordSearch);
    }
    public String findResult() {
        return driver.switchTo().activeElement().getAttribute(findWord);
    }
}
class PageHomeBrowser{
    WebDriver driver;
    SearchDetails search = new SearchDetails();
    public void initialized(){
        search.setBrowserName("http://www.google.com");
        driver.get(search.getBrowserName());
    }
    public PageHomeBrowser(WebDriver driver) {
        this.driver = driver;
    }
}
