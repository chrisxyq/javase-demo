package proxyDemo.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;
import proxyDemo.resource.Animal;
import proxyDemo.resource.Cat;

public class CglibProxy {

    public static Object getProxy(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        // 设置类加载
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new TargetInterceptor());
        // 创建代理类
        return enhancer.create();
    }
    /**
     *  CGLIB 动态代理是通过配置目标类信息，然后利用 ASM 字节码框架进行生成目标类的子类。
     *  当调用代理方法时，通过拦截方法的方式实现代理的操作。
     *  总的来说，JDK 动态代理利用接口实现代理，CGLIB 动态代理利用继承的方式实现代理。
     * @throws Exception
     */
    @Test
    public void dynamicProxy() throws Exception {
        Cat cat = (Cat) CglibProxy.getProxy(Cat.class);
        cat.hobby();
    }


}
