package southday.spring.study.aop.demo.demo1.anno;

import java.lang.annotation.*;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Cache {
    int value() default 0;
}
