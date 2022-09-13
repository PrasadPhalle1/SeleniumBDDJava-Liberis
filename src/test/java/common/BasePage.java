package common;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class BasePage {
    public static WebDriver driver;
    protected static Properties prop;
    private WebDriverWait wait;
    private static String browserName;
    protected static JavascriptExecutor js;

    static {
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        browserName = prop.getProperty("browser");
    }

    public void setBrowser() {
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-gpu");
            System.setProperty("webdriver.chrome.silentOutput", "true");
            options.addArguments("--disable-crash-reporter");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-in-process-stack-traces");
            options.addArguments("--disable-logging");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--log-level=3");
            options.addArguments("--output=/dev/null");
            System.setProperty("webdriver.chrome.verboseLogging", "false");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
    }

    public void clickElement(WebElement webElement) {
        try{
            waitForElementVisibility(webElement);
            webElement.click();
        } catch (Exception e){
        }
    }

    protected <TPage extends BasePage> TPage getInstance(Class<TPage> pageInstance) {
        try {
            return PageFactory.initElements(driver, pageInstance);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating new page instance", e);
        }
    }

    public void waitForElementVisibility(WebElement webElement) {
        try {
            waitForPageLoaded();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(180));
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            System.out.println("Time limit exceeded for waiting the element " + webElement);
            e.printStackTrace();
        }
    }

    public void loadUrl(String url) {
        driver.get(url);
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void javaScriptClick(WebElement webElement) {
        try {
            Thread.sleep(1000);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", webElement);
            Thread.sleep(1000);
        }  catch (Exception e){
        }
    }

    public void closeDriver() {
        driver.close();
    }

}
