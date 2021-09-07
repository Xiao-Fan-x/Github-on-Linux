import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class Message01 {
    public void send() {
        System.out.println("发送信息");
    }
}

class CGLIBProxy implements MethodInterceptor {//拦截器
    private Object target;

    public CGLIBProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object returnData = null;
        if (this.connect()) {
            returnData = method.invoke(this.target, args);
            this.close();
        }
        return returnData;
    }

    public boolean connect() {
        System.out.println("消息代理：进行消息发送通道的连接");
        return true;
    }

    public void close() {
        System.out.println("关闭消息通道");
    }
}


public class Test03 {
    public static void main(String[] args) {
        Message01 messageReal = new Message01();
        Enhancer enhancer = new Enhancer();//负责代理操作的程序类

        enhancer.setSuperclass(messageReal.getClass());
        enhancer.setCallback(new CGLIBProxy(messageReal));
        Message01 proxyObject = (Message01) enhancer.create();
        proxyObject.send();
    }
}
