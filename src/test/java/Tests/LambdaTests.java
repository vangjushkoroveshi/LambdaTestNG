package Tests;

import Base.BaseTest;
import Pages.AllEditionsPages;
import Pages.HomePages;
import Pages.NewWindowsPages;
import Pages.NewsletterPages;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class LambdaTests extends BaseTest {

    @Test(timeOut = 20000)
    public void lambdaTest(){

        HomePages homepage = new HomePages(driver);
        NewWindowsPages windows = new NewWindowsPages(driver);
        NewsletterPages newsletter = new NewsletterPages(driver);
        AllEditionsPages  allEditions = new AllEditionsPages(driver);

        homepage.visit();
        assertTrue(homepage.isLoaded().size() > 0);

        homepage.clickCICD();
        try{
            assertEquals(windows.handleNewWindow(), "https://www.lambdatest.com/support/docs/integrations-with-ci-cd-tools/");
        }
        catch (Exception e){
            throw new AssertionError();
        }

        homepage.resource();

        newsletter.clickOnLetMeReadItFirst();

        try {
            assertTrue(allEditions.allEditionIsDisplayed());
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError();
        }
    }
}
