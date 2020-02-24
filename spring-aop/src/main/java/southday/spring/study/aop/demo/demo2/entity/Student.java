package southday.spring.study.aop.demo.demo2.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import southday.spring.study.aop.demo.demo2.anno.Log;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Component
@Data
@Slf4j
public class Student {
    private String name;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    @Log
    public void study(String course) {
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {

        }
        log.info("{} study course: {}", name, course);
    }

    public void swimming() {
        log.info("{} swimming..", name);
    }
}
