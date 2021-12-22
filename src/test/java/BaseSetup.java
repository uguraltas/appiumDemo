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
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("appPackage", "com.pozitron.hepsiburada");
        caps.setCapability("appActivity","com.hepsiburada.ui.startup.SplashActivity");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void loginTest () throws InterruptedException {

//        dialogsCloseAndCloseAnimation();
        loginAccount();
    }

    public void loginAccount() throws InterruptedException {

        WebElement el1 =  wait.until(ExpectedConditions.elementToBeClickable(By.id("imageViewLogo")));
        el1.click();
//        WebElement loginSimgesi =  wait.until(ExpectedConditions.elementToBeClickable(By.id("account_icon")));
//        loginSimgesi.click();
//        WebElement el3 =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"account_menu_button_1\"]/android.view.ViewGroup/android.widget.Button")));
//        el3.click();


        WebElement arama = wait.until(ExpectedConditions.elementToBeClickable(By.id("textViewSearchBox")));
        arama.click();
        WebElement aramaText = wait.until(ExpectedConditions.elementToBeClickable(By.id("etACBSearchBox")));
        aramaText.click();
        aramaText.sendKeys("telefon");
        WebElement aramaTextbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")));
        aramaTextbox.click();



//        WebElement account = wait.until(ExpectedConditions.elementToBeClickable(By.id("account_icon")));
//        account.click();
//        WebElement userLogin = wait.until(ExpectedConditions.elementToBeClickable(By.id("llUserAccountLogin")));
//        userLogin.click();
//        WebElement loginEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("etLoginEmail")));
//        loginEmail.sendKeys("mb@mb.com");
//        WebElement loginPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("etLoginPassword")));
//        loginPassword.sendKeys("123456");
//        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnLoginLogin")));
//        loginButton.click();
    }

    public void dialogsCloseAndCloseAnimation() throws InterruptedException {
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]");
        el1.click();
//        WebElement noButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("button2")));
//        noButton.click();
//        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("button1")));
//        okButton.click();
//        //Click animation close buton
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("close_button")));
//        element.click();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

