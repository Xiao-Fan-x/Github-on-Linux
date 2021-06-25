import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str = "iaodjsadjosa#{dasd}()dsdad";
        String regex = "#\\{\\w+\\}";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(str);
        while (mat.find()){
            System.out.println(mat.group(0).replaceAll("#|\\{|\\}",""));
        }
    }
}


