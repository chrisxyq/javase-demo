package proxyDemo.jdkProxy;

import org.junit.Test;
import proxyDemo.resource.Animal;
import proxyDemo.resource.Cat;

import java.lang.reflect.Proxy;

/**
 * JDK 动态代理类
 */
public class DynamicProxyAnimal {
    /**
     * 通过调用java.lang.reflect.Proxy #newProxyInstance静态方法创建代理对象
     *
     * @param target
     * @return
     * @throws Exception
     */
    public static Object getProxy(Object target) throws Exception {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 指定目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个，这是一个数组
                new TargetInvoker(target)   // 代理对象处理器
        );
        return proxy;
    }

    /**
     *  JDK 动态代理是通过实现目标类的接口，然后将目标类在构造动态代理时作为参数传入，使代理对象持有目标对象，
     *  再通过代理对象的 InvocationHandler 实现动态代理的操作。
     * @throws Exception
     */
    @Test
    public void dynamicProxy() throws Exception {
        Cat cat = new Cat();
        Animal proxy = (Animal) DynamicProxyAnimal.getProxy(cat);
        proxy.call();
    }


}
