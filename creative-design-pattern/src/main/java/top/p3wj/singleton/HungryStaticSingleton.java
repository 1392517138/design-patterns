package top.p3wj.singleton;

/**
 * @author Aaron
 * @description 饿汉模式
 * @date 2020/10/3 12:30 下午
 */
//饿汉式静态块单例模式
public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungrySingleton;

    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    public static HungryStaticSingleton getInstance() {
        return new HungryStaticSingleton();
    }
}
