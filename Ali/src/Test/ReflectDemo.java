import sun.misc.Unsafe;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo{
    public static void main(String[] args) throws Exception{
        File filePath = new File("C:"+File.separator+"Users"
                +File.separator+"xiao"+File.separator+"Documents"+File.separator+"Test");

        for (int i = 0; i < 500; i++) {
            String name = i+".txt";
            File file = new File(filePath + File.separator + name);
            if (!file.exists()){
                file.createNewFile();
            }
        }
    }
}


class A{
    private String name;

    public A(){}
    public A(String m){
        System.out.println(m);
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }
}