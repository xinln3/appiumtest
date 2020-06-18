package testapp.wework.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @author xinln
 * @description:待办
 * @date 2020/6/14
 */
public class TodoPage extends BasePage{
    //待办-添加按钮元素
    private By add =By.id("gym");
    //代办输入框
    private By todo =By.id("b2k");


    public TodoPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void add (String todoInfo) {
        click(add);
        sendKeys(todo,todoInfo);
    }
}
