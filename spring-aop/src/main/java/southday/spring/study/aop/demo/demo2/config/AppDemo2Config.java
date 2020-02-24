package southday.spring.study.aop.demo.demo2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Configuration
@ComponentScan(basePackages = "southday.spring.study.aop.demo.demo2")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppDemo2Config {
}
