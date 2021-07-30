package Pages;

import Base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewsletterPages extends BasePages {
    public NewsletterPages(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickOnLetMeReadItFirst(){

        String letMeReadCssSelector = "#__next > section > div > div > div.w-6\\/12.smtablet\\:w-full > div > div.mt-30 > a";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(letMeReadCssSelector)))).click();

    }
}
