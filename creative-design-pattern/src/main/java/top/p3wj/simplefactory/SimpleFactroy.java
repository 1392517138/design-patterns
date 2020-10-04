package top.p3wj.simplefactory;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 9:41 上午
 */
public class SimpleFactroy {
    public static ICourse create(Class<? extends ICourse> clazz) {
        if (null != clazz) {
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
