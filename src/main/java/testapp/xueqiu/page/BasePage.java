package testapp.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
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
    public AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    public void waitElement () {

    }
    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public BasePage(AndroidDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public BasePage() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "testxueqiu");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", "com.xueqiu.android.common.MainActivity");
//        desiredCapabilities.setCapability();
        desiredCapabilities.setCapability("newCommandTimeout", 0);

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    public void click(By by){
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
}
