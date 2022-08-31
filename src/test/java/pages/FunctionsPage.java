package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionsPage {
    protected static WebDriver driver;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        
        //Headless activo (No arranque el navegador, desactivar en el caso de querer visualizar)
        chromeOptions.addArguments ("--headless", "--disable-gpu", "--window-size=1920,1080",
        		"--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
        
        driver = new ChromeDriver(chromeOptions);
    }

    public FunctionsPage(WebDriver driver) {
        FunctionsPage.driver = driver;
    }

    public static void navigateTo(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public static void sendTo(String tag, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tag)));

        driver.findElement(By.xpath(tag)).clear();
        driver.findElement(By.xpath(tag)).sendKeys(text);
    }

    public static void clickId(String tag) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id(tag)));

        driver.findElement(By.id(tag)).click();
    }

    public static void clickDesp(String tag, String nameBar) {

    	new WebDriverWait(driver, Duration.ofSeconds(5))
        	.until(ExpectedConditions.elementToBeClickable(By.id(tag)));
    	driver.findElement(By.id(tag)).click();
    	
    	new WebDriverWait(driver, Duration.ofSeconds(5))
    	.until(ExpectedConditions.elementToBeClickable(By.linkText(nameBar)));
    	driver.findElement(By.linkText(nameBar)).click();
    }

    public static void clickXpath(String tag) {
    	new WebDriverWait(driver, Duration.ofSeconds(5))
        	.until(ExpectedConditions.elementToBeClickable(By.id(tag)));

    	driver.findElement(By.xpath(tag)).click();
    }
    
    public static void specialClick(String tag) {
    	new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tag)));
    	
    	Actions action = new Actions(driver);
        action.click(driver.findElement(By.xpath(tag))).build().perform();
    }
    
    public static String getText(String tag) {
    	new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tag)));
    	
    	return driver.findElement(By.xpath(tag)).getText();
    	
    }

    public static void impWaith(int ntime) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ntime));

    }
}