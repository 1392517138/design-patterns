package top.p3wj.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Aaron
 * @description
 * @date 2020/10/4 1:40 下午
 */
public class ClientJDK {
    public static void main(String[] args) {
        IDrink instance = (IDrink) new ProxyPerson().getInstance(new DrinkPerson());
        instance.drink();
    }

    interface IDrink {
        void drink();
    }

    static class DrinkPerson implements IDrink {
        public void drink() {
            System.out.println("I need drink!");
        }
    }

    static class ProxyPerson implements InvocationHandler {
        private Object target;

        public Object getInstance(Object target) {
            this.target = target;
            Class<?> clazz = target.getClass();
            return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            befor();
            Object result = method.invoke(target, args);
            return result;
        }

        private void befor() {
            System.out.println("let us wash it first!");
        }
    }
}
