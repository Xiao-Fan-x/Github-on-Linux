import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test05 {
    public static void main(String[] args) {
        MessageService messageService = new MessageService();
        messageService.send("www.baidu");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface UseMessage{
    public Class<?> clazz();
}

@UseMessage(clazz = MessageImpl.class)
class MessageService {
    private IMessage01 message;

    public MessageService() {
        UseMessage use = MessageService.class.getAnnotation(UseMessage.class);

        this.message = (IMessage01) Factory.getInstance(use.clazz());
    }

    public void send(String msg) {
        this.message.send(msg);
    }
}

class Factory {
    private Factory() {
    }

    public static <T> T getInstance(Class<T> clazz) {
        try {
            return (T) new MessageProxy().bind(clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

interface IMessage01 {
    void send(String msg);
}

class MessageImpl implements IMessage01 {
    @Override
    public void send(String msg) {
        System.out.println("send" + msg);
    }
}

class MessageProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public boolean connect() {
        System.out.println("代理操作 - 通道连接");
        return true;
    }

    public void close() {
        System.out.println("代理操作 - 关闭通道");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (this.connect()) {
                return method.invoke(this.target, args);
            } else {
                throw new Exception("消息无法发送！");
            }
        } finally {
            this.close();
        }
    }
}




