package proxyDemo.cglibProxyCallbackFilter;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;
import proxyDemo.cglibProxy.TargetInterceptor;
import proxyDemo.resource.Cat;

public class CglibProxy {
    /**
     * 为演示调用不同的方法拦截器，在 Enhancer 设置中，
     * 使用Enhancer#setCallbacks设置多个方法拦截器，参数是一个数组，
     * TargetCallbackFilter#accept返回的数字即为该数组的索引，决定调用的回调选择器。
     * @param clazz
     * @return
     */
    public static Object getProxy(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallbacks(new Callback[]{new TargetInterceptor(), new TargetInterceptor2()});
        enhancer.setCallbackFilter(new TargetCallbackFilter());
        return enhancer.create();
    }

    /**
     *  CGLIB 动态代理是通过配置目标类信息，然后利用 ASM 字节码框架进行生成目标类的子类。
     *  当调用代理方法时，通过拦截方法的方式实现代理的操作。
     *  CGLIB 动态代理不能代理 final 修饰的类和方法
     *  总的来说，JDK 动态代理利用接口实现代理，CGLIB 动态代理利用继承的方式实现代理。
     * @throws Exception
     */
    @Test
    public void dynamicProxy() throws Exception {
        Cat cat = (Cat) CglibProxy.getProxy(Cat.class);
        cat.call();
        cat.hobby();
    }


}
