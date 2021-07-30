package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePages {

    public final RemoteWebDriver driver;
    public String baseUrl;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions actions;

    public BasePages(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        baseUrl = "https://www.lambdatest.com/selenium-automation/";
    }

}
