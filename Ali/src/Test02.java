import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IMessage {
    void send();
}
class MessageReal implements IMessage {
    @Override
    public void send() {
        System.out.println("发送消息");
    }
}

class DynaticProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    public boolean connect(){
        System.out.println("消息代理：进行消息发送通道的连接");
        return true;
    }
    public void close(){
        System.out.println("关闭消息通道");
    }

    @Override
    public Object invoke(Object pro, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法"+method);
        Object returnData = null;
        if (this.connect()){
             returnData = method.invoke(this.target,args);
            this.close();
        }
        return returnData;
    }
}

public class Test02 {
    public static void main(String[] args) {
        IMessage msg = (IMessage) new DynaticProxy().bind(new MessageReal());
        msg.send();
    }
}