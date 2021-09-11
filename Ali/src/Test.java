import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {
//        Map.Entry<String,Integer> entry = Map("da",1);

        C num = new B();
        System.out.println(num.getClass());

//        Map<String, String> map = new HashMap<String, String>();
//        map.put("hollis", "hollischuang");
//
//        Class<?> mapType = map.getClass();
//        Method capacity = mapType.getDeclaredMethod("capacity");
//        capacity.setAccessible(true);
//        System.out.println("capacity : " + capacity.invoke(map));
//
//        Field size = mapType.getDeclaredField("size");
//        size.setAccessible(true);
//        System.out.println("size : " + size.get(map));

    }
}

class C {
    private int m = 1;
}

class B extends C {
    private int n = 2;
}
