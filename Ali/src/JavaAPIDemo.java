


public class JavaAPIDemo {
    public static void main(String[] args) {
        new Thread(()->{
            Message msg1 = new Message();
            msg1.setInfo("第一个线程");
            Channel.setMessage(msg1);
            Channel.send();
        },"线程一").start();
        new Thread(()->{
            Message msg2 = new Message();
            msg2.setInfo("第二个线程");
            Channel.setMessage(msg2);
            Channel.send();
        },"线程二").start();
        new Thread(()->{
            Message msg3 = new Message();
            msg3.setInfo("第三个线程");
            Channel.setMessage(msg3);
            Channel.send();
        },"线程三").start();
    }
}

class Channel{
    private static final ThreadLocal<Message> THREADLOCAL = new ThreadLocal<Message>();
    private Channel(){}
    public static void setMessage(Message m){
        THREADLOCAL.set(m);
    }
    public static void send(){
        System.out.println(Thread.currentThread().getName()+"[消息发送]"+ THREADLOCAL.get().getInfo());
    }
}

class Message{
    private String info;
    public void setInfo(String info){
        this.info = info;
    }
    public String getInfo() {
        return info;
    }

}