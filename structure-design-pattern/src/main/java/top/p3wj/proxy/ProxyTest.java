package top.p3wj.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author Aaron
 * @description
 * @date 2020/10/4 3:18 下午
 */
public class ProxyTest {
    public static void main(String[] args) {
        try {
            ClientJDK.IDrink instance = (ClientJDK.IDrink) new ClientJDK.ProxyPerson()
                    .getInstance(new ClientJDK.DrinkPerson());
            byte[] bytes = ProxyGenerator.generateProxyClass("%Proxy0", new Class[]{instance.getClass()});
            FileOutputStream fos = new FileOutputStream("/Users/piwenjing/desktop/$Proxy0.class");
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
