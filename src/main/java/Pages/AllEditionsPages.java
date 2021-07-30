package Pages;

import Base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllEditionsPages extends BasePages {
    public AllEditionsPages(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean allEditionIsDisplayed(){

       return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h1")))).isDisplayed();

    }
}
