package top.p3wj.singleton.lazystaticinner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 3:52 下午
 */
public class LazyStaticInnerClassSingletonTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = LazyStaticInnerClassSingleton.class;
            Constructor<?> c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            LazyStaticInnerClassSingleton o1 = (LazyStaticInnerClassSingleton) c.newInstance();
            LazyStaticInnerClassSingleton o2 = (LazyStaticInnerClassSingleton) c.newInstance();
            System.out.println(o1);
            System.out.println(o2);

            Method getInstance1 = o1.getClass().getDeclaredMethod("getInstance");
            getInstance1.setAccessible(true);
            Object result1 = getInstance1.invoke(o1);

            Method getInstance2 = o2.getClass().getDeclaredMethod("getInstance");
            getInstance2.setAccessible(true);
            Object result2 = getInstance2.invoke(o2);
            // true
            System.out.println(result1 == result2);
            // false
            System.out.println(o1 == o2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
