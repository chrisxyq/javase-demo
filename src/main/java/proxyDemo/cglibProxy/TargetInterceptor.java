package proxyDemo.cglibProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 首先方法拦截接口 net.sf.cglib.proxy.MethodInterceptor
 */
public class TargetInterceptor implements MethodInterceptor {
    /**
     * obj 代理类对象
     * method 当前被代理拦截的方法
     * args 拦截方法的参数
     * proxy 代理类对应目标类的代理方法
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("CGLIB 调用前");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("CGLIB 调用后");
        return result;
    }
}
