package southday.spring.study.aop.demo.dynamicproxy.jdk;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Data
@Slf4j
public class Person implements Sleepable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void sleep(long time) {
        try {
            log.info("{} sleep {}ms", name, time);
            Thread.sleep(time);
        } catch (Exception e) {
        }
        log.info("{} wake up", name);
    }
}
