package southday.spring.study.aop.demo.dynamicproxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Slf4j
public class LogInterceptor implements MethodInterceptor {

    public Object getInstance(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proxy.invokeSuper(obj, args);
        long endTime = System.currentTimeMillis();
        log.info("method={}, cost={}ms.", proxy.getSuperName(), endTime - startTime);
        return result;
    }

}
