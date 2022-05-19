package day_06_时间集合.课堂;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class 时间类 {
    @Test
    public void data() throws ParseException {
        // 确定时间
        String birthday = "1997-10-15";
        // 格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data1 = simpleDateFormat.parse(birthday);
        System.out.println(data1);

        // 得到当前时间
        Date date2 = new Date();
        long date2Time = date2.getTime();

        // 计算两个时间的差值
        long time = date2Time - data1.getTime();

        System.out.println(time);


    }

    @Test
    public void Calendar() {
        // 日历类无法实例化
        Calendar calendar = Calendar.getInstance();

        // 得到 年 月 日
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DATE));

    }

    @Test
    public void LocalDateTime() {
        // 创建时间对象
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        // 直接创建时间
        LocalDate of = LocalDate.of(2020, 9, 1);
        System.out.println(of);

        // 时间上修改
        System.out.println(of.minusYears(2));
        System.out.println(of.plusYears(-2));
        System.out.println(of.plusYears(2));

        // 解析字符串为日期特定的格式 失败
//        String data1 = "1997-10-15";
//        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        DateTimeFormatter dateTimeFormatter2 = new DateTimeFormatterBuilder()
//                .appendPattern("yyyy年MM月dd日")
//                .toFormatter();
//        LocalDate parse1 = LocalDate.parse(data1,dateTimeFormatter2);
//        System.out.println(parse1);


        // 日期装化为字符串
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String now2Format = now2.format(dateTimeFormatter3);
        System.out.println(now2Format);

        // 计算两个时间之间的茶差值 ChronoUnit
        LocalDate now = LocalDate.now();
        LocalDate of1 = LocalDate.of(2020, 9, 1);
        long between = ChronoUnit.DAYS.between(of1, now);
        System.out.println(between);

    }
}
