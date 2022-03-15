import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import utils.MyDateUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtilsTest {
    @Test
    public void test() {
        Calendar calendar = null;
        Date date = MyDateUtils.stringToDate("2022-01-04", "yyyy-MM-dd");
        if (date != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        }
        System.out.println(calendar);
    }
    @Test
    public void test1() {
        Calendar calendar = null;
        Date date = MyDateUtils.stringToDate("2022-01-04", "yyyy-MM-dd");
        if (date != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        }
        System.out.println(calendar);
        System.out.println(MyDateUtils.calendarToString(calendar,"yyyy-MM-dd HH:mm"));
        System.out.println(MyDateUtils.calendarToString(calendar,"yyyy-MM-dd HH:mm:ss"));
    }
    @Test
    public void test2() {
        Calendar calendar = null;
        Date date = MyDateUtils.stringToDate("2022-01-04" + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
        if (date != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        }
        System.out.println(calendar);
        System.out.println(MyDateUtils.calendarToString(calendar,"yyyy-MM-dd HH:mm"));
        System.out.println(MyDateUtils.calendarToString(calendar,"yyyy-MM-dd HH:mm:ss"));
    }
    @Test
    public void test3() {
        Calendar calendar = null;
        Date date = MyDateUtils.stringToDate("2022-01-04" + " 23:59:59", "yyyy-MM-dd hh:mm:ss");
        if (date != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        }
        System.out.println(calendar);
        System.out.println(MyDateUtils.calendarToString(calendar,"yyyy-MM-dd hh:mm"));
        System.out.println(MyDateUtils.calendarToString(calendar,"yyyy-MM-dd hh:mm:ss"));
    }
    @Test
    public void test4() {
        Date startDate = new Date();
        startDate = DateUtils.addDays(startDate, -90);
        startDate = DateUtils.addHours(startDate, 8);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
    }
    @Test
    public void test5() {
        Date startDate = new Date();
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        System.out.println(MyDateUtils.calendarToString(startCalendar, "yyyy/MM/dd"));
    }
    @Test
    public void test6() {
        BigDecimal b1 = BigDecimal.valueOf(-3.14);
        System.out.println("b1 double value = " + b1.doubleValue());
    }
}
