package Pages;

import Base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NewWindowsPages extends BasePages {
    public NewWindowsPages(RemoteWebDriver driver) {
        super(driver);
    }

    public String handleNewWindow(){

        String learnMoreLink = "//*[@id=\"__next\"]/div[1]/section[8]/div/div/div/div[2]/div/div[4]/div/div[2]/span/a";

        // Get the link from attribute and store in the list
        String learnMoreLinkUrl = driver.findElement(By.xpath(learnMoreLink)).getAttribute("href");

        //open new window
        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handle = driver.getWindowHandles();
        List<String> ls = new ArrayList<String>(handle);

        String parentWindowId = ls.get(0);

        //navigate to url
        driver.get(learnMoreLinkUrl);

        //Get current url
        String currentUrl = driver.getCurrentUrl();

        //Scroll to the bottom
        js.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));");

        //Scroll to the top
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

        // Close the new window
        driver.close();

        // Switch back to original browser(first window)
        driver.switchTo().window(parentWindowId);

        return currentUrl;
    }
}
