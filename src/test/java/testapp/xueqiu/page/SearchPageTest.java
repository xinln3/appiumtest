package testapp.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SearchPageTest {
    static MainPage mainPage;
    static  SearchPage searchPage;
    @BeforeAll()
    public static void beforeAll () {
        mainPage = new MainPage();
        searchPage = mainPage.toSearchPage();
    }
    @ParameterizedTest
    @CsvSource({
            "alibab,    阿里巴巴",
            "jd,    京东"
    })
    public void testSearch (String key,String value) throws InterruptedException {
        assertEquals(searchPage.search(key).getSearchList().get(0),value);
    }
    @Test
    public void testGetPrice () {
        assertTrue(searchPage.getPrice()>2000);
    }

   /* @AfterAll
    public void afterAll(){

    }*/



}