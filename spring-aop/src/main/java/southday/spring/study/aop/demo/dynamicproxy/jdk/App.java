package southday.spring.study.aop.demo.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
public class App {
    public static void main(String[] args) {
        Person person = new Person("lichaoxi");
        Sleepable sleeper = (Sleepable) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new LogInvokeHandler(person)
        );
        sleeper.sleep(3000);
    }
}
