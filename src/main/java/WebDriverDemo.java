import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://www.google.com");
            driver.findElement(By.name("q")).sendKeys("java");

            // Get attribute of current active element
            String attr = driver.switchTo().activeElement().getAttribute("title");
            System.out.println(attr);
        } finally {
            driver.quit();
        }
    }
}
