package testapp.wework.page;

import org.openqa.selenium.By;

/**
 * @author xinln
 * @description:企业微信主页面
 * @date 2020/6/6
 */
public class WeWork extends BasePage{

    private final By TAG_SCHEDULE = By.xpath("//*[@text='日程']");

    private final By TAG_TODO = By.xpath("//*[@text='待办']");


    public WeWork() {
        super("com.tencent.wework", ".launch.LaunchSplashActivity");
    }

    /**
     * 跳转到日程页面
     * @return
     */
    public SchedulePage toSchedulePage(){
        click(TAG_SCHEDULE);
        return new SchedulePage(driver);
    }

    /**
     * 跳转到待办页面
     * @return
     */
    public TodoPage toTodoPage () {
        click(TAG_TODO);
        return new TodoPage(driver);
    }
}
