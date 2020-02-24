package southday.spring.study.aop.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import southday.spring.study.aop.demo1.config.AnimalConfig;
import southday.spring.study.aop.demo1.entity.Animal;
import southday.spring.study.aop.demo1.entity.Cat;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnimalConfig.class);
        Animal animal = applicationContext.getBean(Cat.class);
        String result = animal.sayName("xxx", 12);
        String result1 = animal.sayName("xxx", 12);
        String result2 = animal.sayName("xxx", 13);
        String result3 = animal.sayName("xxx", 13);
    }
}
