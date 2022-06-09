package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// --import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    
    protected static WebDriver driver;
    // private static WebDriverWait wait;

    static {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        // --WebDriverManager.chromedriver().setup();
        // --WebDriver driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver(chromeOptions);
        // wait = new WebDriverWait(driver, 10);
    }

    public BasePage (WebDriver driver){
        BasePage.driver = driver;
        // wait = new WebDriverWait(driver, 10)
    }

    public static void navigateTo(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }
}
