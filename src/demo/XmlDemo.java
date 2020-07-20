package demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class XmlDemo {

    public static void main(String[] args) {
        System.out.println(getNowForFileName(1));
    }

    public static String getNowForFileName(int afterDay) {
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        calendar.set(5, calendar.get(5) + afterDay);
        Date date = calendar.getTime();
        return df.format(date);
    }

}
