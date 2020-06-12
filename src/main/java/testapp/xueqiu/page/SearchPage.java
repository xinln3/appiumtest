package testapp.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xinln
 * @description:
 * @date 2020/6/3
 */
public class SearchPage extends BasePage{

    private By nameLocator = By.id("name");

    public SearchPage() {
        super();
    }

    public SearchPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public SearchPage search(String keyword) throws InterruptedException {
//        do {
//            driver.findElement(By.id("search_input_text")).sendKeys("阿里巴巴");
            MobileElement el3 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
            el3.sendKeys(keyword);
//            sendKeys(By.id("search_input_text"), keyword);
//        } while (driver.findElements(nameLocator).size()<=0);
        return this;
    }

    @Override
    public void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

    public List<String> getSearchList () {
        List<String> nameList = null;
        List<MobileElement> wes = driver.findElements(nameLocator);
        nameList = wes.stream().map(str ->str.getText()).collect(Collectors.toList());
        return nameList;
    }

    public double getPrice () {
        MobileElement el4 = (MobileElement) driver.findElement(nameLocator);
                   el4.click();
       return Double.valueOf(driver.findElement(By.id("current_price")).getText());
    }
}
