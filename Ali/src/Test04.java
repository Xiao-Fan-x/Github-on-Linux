import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface DefaultAnnotation {
    String title();

    String url() default "www.baidu.com";

}

class Message04 {
    @DefaultAnnotation(title = "d")
    public void send(String msg) {
        System.out.println("send message" + msg);
    }
}

public class Test04 {
    public static void main(String[] args) throws Exception{


        Method method = Message04.class.getMethod("send", String.class);
        DefaultAnnotation annotation = method.getAnnotation(DefaultAnnotation.class);
        System.out.println(annotation.title());
        System.out.println(annotation.url());

        String msg = annotation.title()+annotation.url();
        method.invoke(Message04.class.getDeclaredConstructor().newInstance(),msg);


    }

}
