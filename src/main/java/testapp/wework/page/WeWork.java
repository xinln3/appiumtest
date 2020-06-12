package testapp.wework.page;

import org.openqa.selenium.By;

/**
 * @author xinln
 * @description:企业微信主页面
 * @date 2020/6/6
 */
public class WeWork extends BasePage{

    private final By TAG_SCHEDULE = By.xpath("//*[@text='日程']");

    public WeWork() {
        super("com.tencent.wework", "com.tencent.wework.launch.WwMainActivity");
    }

    //日程页
    public SchedulePage toSchedulePage(){
        click(TAG_SCHEDULE);
        return new SchedulePage(driver);
    }
}
