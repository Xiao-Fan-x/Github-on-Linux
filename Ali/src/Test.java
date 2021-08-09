package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws IOException {
//        String str = "www.baidu.com";
//        InputStream input = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//        int data = 0;
//        while ((data = input.read()) != -1){
//            output.write(Character.toUpperCase((char) data));
//        }
//        byte result[] = output.toByteArray();
//        System.out.println(output);
//        System.out.println(new String(result));
//
//        output.close();
//        input.close();


        URL url = new URL("http://www.bing.com");

        /* 字节流 */
        InputStream is = url.openStream();

        /* 字符流 */
        InputStreamReader isr = new InputStreamReader(is, "utf-8");

        /* 提供缓存功能 */
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();

    }
}

/**
 * @description 将普通变量升级为原子变量
 **/
//class AtomicIntegerFieldUpdaterTest implements Runnable {
//
//    static Goods phone;
//    static Goods computer;
//
//    AtomicIntegerFieldUpdater<Goods> atomicIntegerFieldUpdater =
//            AtomicIntegerFieldUpdater.newUpdater(Goods.class, "price");
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10000; i++) {
//            phone.price++;
//            atomicIntegerFieldUpdater.getAndIncrement(computer);
//        }
//    }
//
//    static class Goods {
//        //商品定价
//        volatile int price;
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        phone = new Goods();
//        computer = new Goods();
//        AtomicIntegerFieldUpdaterTest atomicIntegerFieldUpdaterTest = new AtomicIntegerFieldUpdaterTest();
//        Thread thread1 = new Thread(atomicIntegerFieldUpdaterTest);
//        Thread thread2 = new Thread(atomicIntegerFieldUpdaterTest);
//        thread1.start();
//        thread2.start();
//        //join()方法是为了让main主线程等待thread1、thread2两个子线程执行完毕
//        thread1.join();
//        thread2.join();
//        System.out.println("CommonInteger price = " + phone.price);
//        System.out.println("AtomicInteger price = " + computer.price);
//    }
//}
//

//class CountdownLatchExample {
//
//    public static void main(String[] args) throws InterruptedException {
//        final int totalThread = 10;
//        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < totalThread; i++) {
//            executorService.execute(() -> {
//                System.out.print("run..");
//                countDownLatch.countDown();
//            });
//        }
//        countDownLatch.await();
//        System.out.println("end");
//        executorService.shutdown();
//    }
//}