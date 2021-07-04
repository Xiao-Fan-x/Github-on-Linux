import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Test {
    public static void main(String[] args) throws Exception{
        Locale loc = new Locale("en","US");
        ResourceBundle resource = ResourceBundle.getBundle("ali.message.Message",loc);
        String val = resource.getString("info");
        System.out.println(MessageFormat.format(val,"csdn",new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
    }
}