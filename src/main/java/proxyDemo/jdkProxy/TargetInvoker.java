package proxyDemo.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现 InvocationHandler 接口
 */
public class TargetInvoker implements InvocationHandler {
    // 代理中持有的目标类
    private Object target;

    /**
     * proxy 代理目标对象的代理对象，它是真实的代理对象。
     * method 执行目标类的方法
     * args 执行目标类的方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk 代理执行前");
        Object result = method.invoke(target, args);
        System.out.println("jdk 代理执行后");
        return result;
    }

    public TargetInvoker(Object target) {
        this.target = target;
    }


}
