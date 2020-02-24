package southday.spring.study.aop.demo1.entity;

import org.springframework.stereotype.Component;
import southday.spring.study.aop.demo1.anno.Cache;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
@Component
public class Cat implements Animal {

    @Override
    @Cache(60)
    public String sayName(String name, Integer num) {
        return "Cat: " + name + "-" + num;
    }
}
