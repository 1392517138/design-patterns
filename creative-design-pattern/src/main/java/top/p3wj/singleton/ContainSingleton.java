package top.p3wj.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 5:31 下午
 */
public class ContainSingleton {
    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    private ContainSingleton() {
    }

    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
}
