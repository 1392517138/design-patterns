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
            Object o2 = c.newInstance();
            System.out.println(o1);
            Method getInstance = o1.getClass().getDeclaredMethod("getInstance");
            getInstance.setAccessible(true);
            getInstance.invoke(o1);

            System.out.println(o1 == o2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
