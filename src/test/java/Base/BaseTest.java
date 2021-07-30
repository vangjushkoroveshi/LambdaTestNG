package Base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public RemoteWebDriver driver;
    private final String username = "vangjushkoroveshi";
    private final String accessKey = "hvHHh4MLrulWRIrqfwQW1arpxxHYNNbraAXnx1YFVpq06Wokij";

    @BeforeClass
    @Parameters({"platform","browser","version"})
    public void lunchBrowser(String platform, String browser, String version) throws MalformedURLException {

        if (browser.equalsIgnoreCase("Chrome")){
            ChromeOptions capabilities = new ChromeOptions();
            capabilities.setCapability("user",username);
            capabilities.setCapability("accessKey",accessKey);
            capabilities.setCapability("build", "Lambda TestNG");
            capabilities.setCapability("name", "LambdaTestNG Test");
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("browserName", browser);
            capabilities.setCapability("browserVersion", version); // If this cap isn't specified, it will just get the any available one
            capabilities.setCapability("network", true); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("video", true); // To enable video recording
            capabilities.setCapability("console", true); // To capture console logs
            driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);

        } else if (browser.equalsIgnoreCase("Firefox")){
            FirefoxOptions capabilities = new FirefoxOptions();
            capabilities.setCapability("user",username);
            capabilities.setCapability("accessKey",accessKey);
            capabilities.setCapability("build", "Lambda TestNG");
            capabilities.setCapability("name", "LambdaTestNG Test");
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("browserName", browser);
            capabilities.setCapability("browserVersion", version); // If this cap isn't specified, it will just get the any available one
            capabilities.setCapability("network", true); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("video", true); // To enable video recording
            capabilities.setCapability("console", true); // To capture console logs
            driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);

        }else if (browser.equalsIgnoreCase("Internet Explorer")){
            InternetExplorerOptions capabilities = new InternetExplorerOptions();

            capabilities.setCapability("user",username);
            capabilities.setCapability("accessKey",accessKey);
            capabilities.setCapability("build", "Lambda TestNG");
            capabilities.setCapability("name", "LambdaTestNG Test");
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("browserName", browser);
            capabilities.setCapability("browserVersion", version); // If this cap isn't specified, it will just get the any available one
            capabilities.setCapability("ie.compatibility",11001);
            capabilities.setCapability("network", true); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("video", true); // To enable video recording
            capabilities.setCapability("console", true); // To capture console logs
            driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);

        } else if (browser.equalsIgnoreCase("MicrosoftEdge")){
            EdgeOptions capabilities = new EdgeOptions();
            capabilities.setCapability("user",username);
            capabilities.setCapability("accessKey",accessKey);
            capabilities.setCapability("build", "Lambda TestNG");
            capabilities.setCapability("name", "LambdaTestNG Test");
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("browserName", browser);
            capabilities.setCapability("browserVersion", version); // If this cap isn't specified, it will just get the any available one
            capabilities.setCapability("network", true); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("video", true); // To enable video recording
            capabilities.setCapability("console", true); // To capture console logs
            driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);

        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
