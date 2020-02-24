package southday.spring.study.aop.demo.dynamicproxy.cglib;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Slf4j
@Data
public class Teacher {
    private String name;

    public Teacher() {}

    public Teacher(String name) {
        this.name = name;
    }

    public void teach(String course) {
        try {
            log.info("{} teach course: {}", name, course);
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        log.info("{} teach end.", name);
    }
}
