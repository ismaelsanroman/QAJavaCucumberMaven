package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
// import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionsPage {
    protected static WebDriver driver;
    // private static WebDriverWait wait;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        // wait = new WebDriverWait(driver, 10);
    }

    public FunctionsPage(WebDriver driver) {
        FunctionsPage.driver = driver;
        // wait = new WebDriverWait(driver, 10);
    }

    public static void navigateTo(String url) {
        // driver.get(url);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public static void endTest() {
        driver.close();
        driver.quit();
    }
}
