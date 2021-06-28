import java.util.Locale;
import java.util.ResourceBundle;

public class Test {
    public static void main(String[] args) {
        ResourceBundle resource = ResourceBundle.getBundle("cn.mldn.demo");
        String val = resource.getString("info");
        System.out.println(val);
    }
}


