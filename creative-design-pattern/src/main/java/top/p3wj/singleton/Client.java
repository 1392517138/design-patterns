package top.p3wj.singleton;

/**
 * @author Aaron
 * @description 单例模式通用写法
 * @date 2020/10/3 12:28 下午
 */
public class Client {
    public static void main(String[] args) {
        Singleton.getInstance();
    }

    static class Singleton {
        private static final Singleton instance = new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return instance;
        }
    }
}
