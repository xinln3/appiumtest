package testapp.wework.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author xinln
 * @description:
 * @date 2020/6/6
 */
public class BasePage {
    private final int timeOutInSecondsDefault = 60;

    public AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    String packageName;
    String activityName;

    public BasePage(String packageName, String activityName) {
        this.packageName = packageName;
        this.activityName = activityName;
        startApp(this.packageName, this.activityName);
    }

    public void waitElement () {

    }
    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSecondsDefault);
    }

    public BasePage(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void startApp (String packageName,String activityName) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "testxueqiu");
        desiredCapabilities.setCapability("appPackage", packageName);
        desiredCapabilities.setCapability("appActivity", activityName);
        desiredCapabilities.setCapability("newCommandTimeout", 0);
        desiredCapabilities.setCapability("udid", "");
        desiredCapabilities.setCapability("dontStopAppOnReset", "true");
        desiredCapabilities.setCapability("skipLogcatCapture", "true");

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public BasePage() {


    }



    public void click(By by){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
        driver.findElement(by).click();
    }

    public MobileElement find (By by) {
        return driver.findElement(by);
    }

    public void sendKeys (By by,String keyWords) {
        driver.findElement(by).sendKeys(keyWords);
    }

    public void quit () {
        driver.quit();;
    }

    //基于文本定位
    public MobileElement find(String text) {
        return driver.findElement(byText(text));
    }

    public By byText(String text){
        return By.xpath("//*[@text='"+ text + "']");
    }

}
