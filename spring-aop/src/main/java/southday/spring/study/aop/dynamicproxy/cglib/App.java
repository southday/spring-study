package southday.spring.study.aop.dynamicproxy.cglib;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
public class App {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Teacher proxy = (Teacher) new LogInterceptor().getInstance(teacher);
        proxy.setName("lichaoxi");
        proxy.teach("Math");
    }
}
