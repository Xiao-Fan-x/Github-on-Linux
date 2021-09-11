import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDemo{
    public static void main(String[] args) throws Exception{
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafeObject = (Unsafe)field.get(null);
        //利用Unsafe类绕过了JVM的管理机制，可以在没有实例化对象的情况下获取一个Singletion类实例化对象
        Singletion instance = (Singletion) unsafeObject.allocateInstance(Singletion.class);
        instance.print();
    }
}

class Singletion{
//    private static final Singletion INSTANCE = new Singletion();
//    public Singletion() {
//    }
    private Singletion(){
        System.out.println("Singletion构造");
    }
//    public static Singletion getInstance(){
//        return INSTANCE;
//    }
    public void print(){
        System.out.println("www.baidu.com");
    }
}
