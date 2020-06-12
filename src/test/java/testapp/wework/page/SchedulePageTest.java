package testapp.wework.page;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchedulePageTest {

    private static WeWork wework;

    @BeforeAll
    static void beforeAll(){
        wework = new WeWork();

    }

    @Test
    void add() {
        assertTrue(wework.toSchedulePage().add("上班打卡", null).getScheduleList(null).contains("上班打卡")
        );
    }

    @Test
    void getScheduleList() {
    }
}