package Base;

import org.openqa.selenium.remote.DesiredCapabilities;
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

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", platform);
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version", version); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "Test");
        capabilities.setCapability("name", "LambdaTestNG Test");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
