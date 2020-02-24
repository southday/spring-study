package southday.spring.study.aop;

/**
 * @author southday
 * @email chaoxi.li@ai-ways.com
 * @date 2020/2/24
 */
public class Singleton {

    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton() {
        return SingletonHolder.singleton;
    }
}

class Singleton2 {
    private static volatile Singleton2 singleton2 = null;

    private Singleton2() {}

    public static Singleton2 getSingleton2() {
        if (singleton2 != null) {
            synchronized (Singleton2.class) {
                if (singleton2 != null) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}
