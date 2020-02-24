package southday.spring.study.aop.demo.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import southday.spring.study.aop.demo.demo2.config.AppConfig;
import southday.spring.study.aop.demo.demo2.entity.Student;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = applicationContext.getBean(Student.class);
        student.setName("lichaoxi");
        student.study("Math");
        student.swimming();
    }
}
