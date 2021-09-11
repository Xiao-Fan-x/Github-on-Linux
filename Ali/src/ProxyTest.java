import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 被代理的主体需要实现的接口
 */
interface Subject {
    String doSomething(String thingsNeedParm);

    String doOtherNotImportantThing(String otherThingsNeedParm);
}

public class ProxyTest {
    public static void main(String[] args) {
        Subject subject = new SubjectIpml();

        SubjectProxy subjectProxy = new SubjectProxy(subject);
        Subject proxy = subjectProxy.getProxy();
        proxy.doSomething("改锥");
        proxy.doOtherNotImportantThing("纸片");
    }
}

class SubjectProxy implements InvocationHandler {

    private final Subject subject;

    SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    /**
     * @param proxy  调用这个方法的代理实例
     * @param method 要调用的方法
     * @param args   方法调用时所需要的参数
     * @return 方法调用的结果
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //进行method过滤，如果是其他方法就不调用
        if (method.getName().equals("doSomething")) {
            System.out.println("做某些事前的准备");
            Object object = method.invoke(subject, args);
            System.out.println("做某些事后期收尾");
            return object;
        }
        return "调用失败";
    }

    /**
     * 获取被代理接口实例对象
     */
    public Subject getProxy() {
        return (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), this);
    }
}

class SubjectIpml implements Subject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String doSomething(String thingsNeedParm) {
        System.out.println("使用" + thingsNeedParm + "做了一些事情");
        return "调用成功";
    }

    @Override
    public String doOtherNotImportantThing(String otherThingsNeedParm) {
        System.out.println("使用" + otherThingsNeedParm + "做了一些事情");
        return "调用成功";
    }
}