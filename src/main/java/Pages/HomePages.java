package Pages;

import Base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class HomePages extends BasePages {

    public HomePages(RemoteWebDriver driver) {
        super(driver);
    }

    public void visit() {
        driver.get(baseUrl);
    }

    public List<WebElement> isLoaded(){

        String inputEmails = "//input[@name='email']";
        return wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(inputEmails))));
    }

    public void clickCICD(){
        String ci_cd = "//div[contains(text(), 'CI/CD Tools')]";

        //Click CI/CD
        driver.findElement(By.xpath(ci_cd)).click();
    }

    public void resource(){
        String resourceBtn = "//button[contains(text(),'Resources ')]";
        String newsletter = "//ul/a[contains(text(),'Newsletter')]";

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(resourceBtn)))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(newsletter)))).click();

    }


}
