package testapp.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author xinln
 * @description:
 * @date 2020/6/3
 */
public class MainPage extends BasePage{

    public MainPage() {

    }

    public SearchPage toSearchPage () {
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        el2.click();
        return new SearchPage(driver);
    }


}
