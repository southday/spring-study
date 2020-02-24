package southday.spring.study.aop.demo.demo1.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
    // 定义切点：包含任意参数的、任意返回值、的公共方法 sayName
    @Pointcut("execution(public *  *sayName(..))")
    private void log(){}

    // 定义环绕通知：处理日志注入
    @Around("log()")
    private Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("before, params: {}", JSON.toJSONString(args));
        Object result = proceedingJoinPoint.proceed();
        log.info("after, result: {}", JSON.toJSONString(result));
        return result;
    }
}
