package top.p3wj.singleton.lazystaticinner;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 3:29 下午
 */
public class LazyStaticInnerClassSingleton {
    // With LazyStaticInnerClassSingleton, the inner class is initialized by default
    // If not used, the inner class will not be loaded
    private LazyStaticInnerClassSingleton() {
        System.out.println("123");
        if (LazyHolder.INSTANCE != null) {
            throw new RuntimeException("Multiple instances are not allowed to be created");
        }
    }

    // Static is to make the singleton pattern space sharing, to ensure that this method will not be overridden
    private static LazyStaticInnerClassSingleton getInstance() {
        // Always load the inner class before returning the result
        return LazyHolder.INSTANCE;
    }

    // By default, inner classes are not loaded, taking advantage of the Java language itself
    private static class LazyHolder {
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }
}
