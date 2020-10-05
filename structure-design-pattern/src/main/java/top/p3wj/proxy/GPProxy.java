package top.p3wj.proxy;

/**
 * @author Aaron
 * @description
 * @date 2020/10/5 3:55 下午
 */
public class GPProxy {
    public static final String ln = "\r\n";

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append(GPProxy.class.getPackage() + ";" + ln);
        sb.append("import " + interfaces[0].getName() + ";" + ln);
        sb.append("import java.lang.reflect.*l" + ln);
        sb.append("public class %Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("GPInvocationHandler h;" + ln);
        return "";
    }
}
