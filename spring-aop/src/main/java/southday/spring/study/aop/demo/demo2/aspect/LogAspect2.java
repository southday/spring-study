package southday.spring.study.aop.demo.demo2.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Aspect
@Component
@Slf4j
public class LogAspect2 {

    @Pointcut("@annotation(southday.spring.study.aop.demo.demo2.anno.Log)")
    private void logCallDetail() {}

    @Around("logCallDetail()")
    private Object printCallDetail(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        StringBuilder sb = new StringBuilder();
        sb.append("method=").append(signature.getMethod().getName()).append(", args: {");
        Object[] args = proceedingJoinPoint.getArgs();
        String[] parameterNames = signature.getParameterNames();
        for (int i = 0; i < args.length; i++) {
            sb.append(parameterNames[i]).append("=").append(JSON.toJSONString(args[i])).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("}, cost = ");
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed(args);
        long endTime = System.currentTimeMillis();
        sb.append(endTime - startTime).append("ms.");
        log.info(sb.toString());
        return result;
    }
}
