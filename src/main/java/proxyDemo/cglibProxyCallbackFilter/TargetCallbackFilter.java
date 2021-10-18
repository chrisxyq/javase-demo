package proxyDemo.cglibProxyCallbackFilter;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 回调过滤器 CallbackFilter
 * TargetCallbackFilter#accept返回的数字即为该数组的索引，决定调用的回调选择器。
 */
public class TargetCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if ("hobby".equals(method.getName())) {
            return 1;
        } else {
            return 0;
        }
    }
}

