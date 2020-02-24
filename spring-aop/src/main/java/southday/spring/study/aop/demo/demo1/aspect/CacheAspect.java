package southday.spring.study.aop.demo.demo1.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Component
@Aspect
@Slf4j
public class CacheAspect {

    // 定义切入点：带有 Cache 注解的方法
    @Pointcut("@annotation(southday.spring.study.aop.demo.demo1.anno.Cache)")
    private void cache(){}

    // 临时存储区
    private static Map<String, Object> cacheMap = new HashMap<>();

    // 定义环绕通知，处理接口/方法添加缓存
    @Around("cache()")
    private Object cacheAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object target = proceedingJoinPoint.getTarget();
        Object[] args = proceedingJoinPoint.getArgs();
        String className = target.getClass().getName();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        String cacheKey = className + "_" + method.getName() + "_" + JSON.toJSONString(args);
        if (cacheMap.containsKey(cacheKey)) {
            log.info("data get cache, cacheKey={}", cacheKey);
            return cacheMap.get(cacheKey);
        } else {
            log.info("put data to cache, cacheKey={}", cacheKey);
            Object result = proceedingJoinPoint.proceed();
            cacheMap.put(cacheKey, result);
            return result;
        }
    }
}
