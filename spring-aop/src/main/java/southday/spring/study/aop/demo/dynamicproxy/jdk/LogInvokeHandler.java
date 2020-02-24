package southday.spring.study.aop.demo.dynamicproxy.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Slf4j
public class LogInvokeHandler implements InvocationHandler {
    private Object target;

    public LogInvokeHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long endTime = System.currentTimeMillis();
        log.info("method={}, cost={}ms", method.getName(), endTime - startTime);
        return result;
    }
}
