import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseSetup {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;


    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("appPackage", "com.pozitron.hepsiburada");
        caps.setCapability("appActivity", "com.hepsiburada.ui.startup.SplashActivity");
        caps.setCapability("noReset", "false");
        caps.setCapability("autoDissmissAlerts", "true");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void searchTest()  {
        search();
    }

    public void search()  {

        WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(By.id("imageViewLogo")));
        logo.click();
        WebElement arama = wait.until(ExpectedConditions.elementToBeClickable(By.id("textViewSearchBox")));
        arama.click();
        WebElement aramaText = wait.until(ExpectedConditions.elementToBeClickable(By.id("etACBSearchBox")));
        aramaText.click();
//        WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(By.id("com_appboy_inappmessage_modal_close_button")));
//        popup.click();
        aramaText.sendKeys("siyah şapka");
        WebElement aramaTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView")));
        aramaTextbox.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

