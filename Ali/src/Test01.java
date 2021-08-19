package src;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        new Thread(()->lockDemo.m1(5)).start();
        new Thread(()->lockDemo.m2(10)).start();
    }

}

class LockDemo{
    public synchronized void m1(int m){
        System.out.println("m1 "+ new
                SimpleDateFormat("HH:mm:ss").format(new Date())+m);

        m2(m);
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public synchronized void m2(int m){
        System.out.println("m2 "+ new
                SimpleDateFormat("HH:mm:ss").format(new Date())+m);

        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}