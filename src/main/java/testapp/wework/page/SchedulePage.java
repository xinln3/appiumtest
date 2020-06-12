package testapp.wework.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xinln
 * @description:日程page
 * @date 2020/6/11
 */
public class SchedulePage extends BasePage{
    private final By taskName = By.id("b2k");
    private final By save = byText("保存");
    private final By taskList = By.id("gg_");
    private By add =By.id("gym");

    public SchedulePage() {
    }

    public SchedulePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public SchedulePage add (String name,String time) {
        click(add);
        sendKeys(taskName,name);
        click(save);
        return this;
    }

    public List<String> getScheduleList(String day){
        if(day!=null){
            //todo:选择日期
        }
        return driver.findElements(taskList).stream().map(x->x.getText()).collect(Collectors.toList());
    }
}
