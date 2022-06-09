package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    protected static WebDriver driver;
    // private static WebDriverWait wait;

    static {
        // ---- ChromeOptions chromeOptions = new ChromeOptions();
        // ---- driver = new ChromeDriver(chromeOptions);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // wait = new WebDriverWait(driver, 10);
    }

    public BasePage (WebDriver driver){
        BasePage.driver = driver;
        // wait = new WebDriverWait(driver, 10)
    }

    public static void navigateTo(String url){
        driver.get(url);
    }
}
