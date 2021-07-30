import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date resultDate = new Date();
        String starttime = sdf.format(resultDate);
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.YEAR, +1); // 年份减1
        resultDate = ca.getTime(); // 结果
        String endtime = sdf.format(resultDate);
        System.out.println(starttime+"  "+endtime);

//         System.out.println(sdf.format(date));
    }
}