package top.p3wj.singleton;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 2:53 下午
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;

    LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        // check if block
        if (instance != null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                // check if recreate the instance
                if (instance != null) {
                    instance = new LazyDoubleCheckSingleton();
                    // instruction reording problem
                }
            }
        }
        return instance;
    }
}
