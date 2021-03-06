# 结构型设计模式

## 1.代理模式

指在某些情况下，一个对象不适合直接引用另一个对象，代理对象可在目标对象与客户端之间起到一个中介作用。

那么就有三个角色：抽象主题角色、真实主题角色、代理主题角色

静态代理：一个人想喝水，但是喝水前需要代理先洗杯子

```java
public class Client {
    public static void main(String[] args) {
        ProxyPerson proxyPerson = new ProxyPerson(new DrinkPerson());
        proxyPerson.drink();
    }
    interface IDrink {
        void drink();
    }
    static class DrinkPerson implements IDrink {
        public void drink() {
            System.out.println("I need drink!");
        }
    }
    static class ProxyPerson implements IDrink {
        private DrinkPerson drinkPerson;

        public ProxyPerson(DrinkPerson drinkPerson) {
            this.drinkPerson = drinkPerson;
        }
        private void drinkBefor() {
            System.out.println("let us wash first!");
        }
        public void drink() {
            drinkBefor();
            drinkPerson.drink();
        }
    }
}
```

动态代理：

其实JDK为我们提供了类库，将之前代码修改后如下所示：

```java
public class Client {
    public static void main(String[] args) {
        IDrink instance = (IDrink)new ProxyPerson().getInstance(new DrinkPerson());
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
            return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
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
```

之前一个代理只能代理一个类型（一个接口），这样在开放中必然产生许多的接口。所以我们想通过一个代理类完成所有的代理。

JDK动态代理采用字节重组，重新生成对象来代替原来的对象。在ClassPath下一般以\$开头的.class文件都是自动生成的

我们来看看JDK帮我们生成的代码是什么样子的，首先通过以下代码产生class文件

```java
public class ProxyTest {
    public static void main(String[] args) {
        try {
            Client.IDrink instance = (Client.IDrink) new Client.ProxyPerson()
                    .getInstance(new Client.DrinkPerson());
            byte[] bytes = ProxyGenerator.generateProxyClass("%Proxy0", new Class[]{instance.getClass()});
            FileOutputStream fos = new FileOutputStream("/Users/piwenjing/desktop/$Proxy0.class");
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

将生成的\$Proxy0.class拷贝至target包下查看反编译结果

下面来看CGLIB

```java
public class ClientCG implements MethodInterceptor {
    public Object getInstance(Class<?> clazz) throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }

    private void before() {
        System.out.println("CGLIB is running!");
    }
}
```

JDK采用读取接口的信息，CGLIB覆盖弗雷的方法。CGLIB调用效率更高，因为生成了包含所有逻辑的FastClass，不需要反射调用，但是它不能代理final的方法。

## 2.门面模式

提供了一个统一的接口，用来访问子系统中的一群接口，主要特征为定义了一个高层接口，让子系统更容易使用。

角色：外观角色、子系统角色

```java
public class Client {
    // client
    public static void main(String[] args) {
        
    }
    // subsystem A
    static class SubSystemA {
        public void doA() {
            System.out.println("doing A stuff!");
        }
    }
    // subsystem B
    static class SubSystemB {
        public void doB() {
            System.out.println("doing B stuff!");
        }
    }
    // Facade
    static class Facade {
        private SubSystemA a = new SubSystemA();
        private SubSystemB b = new SubSystemB();
        // external interface
        public void doA() {
            this.a.doA();
        }
        // external interface
        public void doB() {
            this.b.doB();
        }
    }
}
```

简化了调用过程，不用深入了解子系统，更好地划分了访问层次，提高了安全性。

## 3.装饰器模式

指在不改变原油对象的基础上，动态地给一个对象添加额外的职责。其提供了比继承更有弹性的替代方案，其核心是功能扩展，可透明地动态扩展类的功能。

角色：抽象组件、具体组件、抽象装饰器、具体装饰器

装饰器模式与代理模式非常相似，但他强调自身的扩展，着重类功能的变化。

代理模式强调对代理过程的控制。

## 4.享元模式

当系统中对象数量太多时，将导致运行代价过高，带来性能下降的问题。类似于线程池，可用避免不停地创建和销毁多个对象。

角色：抽象享元角色（同时定义外部状态和内部状态的接口或实现）、具体享元角色（该角色的内部状态处理应该与环境无关，不会出现一个操作改变内部状态、同时修改外部状态的情况）、享元工厂

```java
public class Client {

    interface IFlyweight {
        void operation(String extrinsicState);
    }

    // concrete flyweight role
    static class ConcreteFlyweight implements IFlyweight {
        private String intrinsicState;

        public ConcreteFlyweight(String intrinsicState) {
            this.intrinsicState = intrinsicState;
        }

        public void operation(String extrinsicState) {
            System.out.println("Object address:" + System.identityHashCode(this));
            System.out.println("IntrinsicStateA:" + this.intrinsicState);
            System.out.println("ExtrinsicState:" + extrinsicState);
        }
        // flyweight factory
        static class FlyweightFactory {
            private static Map<String,IFlyweight> pool = new HashMap<String,IFlyweight>();
            // because the internal state is invariant,it serves as a key for caching
            public static IFlyweight getFlyweight(String intrinsicState) {
                if (!pool.containsKey(intrinsicState)) {
                    ConcreteFlyweight concreteFlyweight = new ConcreteFlyweight(intrinsicState);
                    pool.put(intrinsicState,concreteFlyweight);
                }
                return pool.get(intrinsicState);
            }
        }
    }
}
```

```java
public class ConnectionPool {
    private Vector<Connection> pool;
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "root";
    private String driverClassName = "com.mysql.jdbc.Driver";
    private int poolSize = 100;
    public ConnectionPool() {
        pool = new Vector<Connection>(poolSize);
        try {
            Class.forName(driverClassName);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                pool.add(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection connection = pool.get(0);
            pool.remove(connection);
            return connection;
        }
        return null;
    }
    public synchronized void release(Connection connection) {
        pool.add(connection);
    }
}
```

内部状态指对象共享出来的信息，存储在享元对象内部，并且不会随环境的改变而改变，不可共享。

例如保存在连接中的用户名在创建对象的时候就设置好了，不会随环境的改变而改变，这些为内部轧辊台。而当每个连接要被回收利用时，我们需要将它标记为可用状态，这些为外部状态。

## 5.组合模式

将单个对象（叶子节点）和组合对象（树枝对象）用相同的接口进行表示，使得客户对单个对象和组合对象的使用具有一致性。

**透明组合**是把所有公共方法都定义在Component中，这样做的好处是客户端无须分辨叶子结点和树枝节点，它们具备完全一致的接口。

透明组合把所有公共方法都定义在Component中，这样客户端就不需要区分操作对象是叶子结点还是树枝结点。

**安全组合**模式即避免为叶子节点类型引入冗余方法，而透明模式为将所有方法都引入至抽象类。

## 6.适配器模式

将一个类的接口变成客户端所期望的另一种接口，从而使原本因接口不匹配而导致无法在一起工作的两个类能够一起工作。

也就是说，当前系统存在两个接口A、B，客户端只支持访问A，但当前系统没有A接口对象，有B接口，而客户端无法识别B接口，因此通过一个适配器C，将B接口内容转换成A接口，从而使得客户端能够从A接口获取B接口的内容。

角色：目标角色、源角色、适配器

```java
public class Client {
    public static void main(String[] args) {
        PowerAdapter powerAdapter = new PowerAdapter();
        powerAdapter.output5V();
    }
    interface DC5 {
        int output5V();
    }

    static class AC220 {
        public int outputAC220V() {
            int output = 220;
            System.out.println("the out put voltage is " + output + "V");
            return output;
        }
    }

    static class PowerAdapter extends AC220 implements DC5 {
        @Override
        public int output5V() {
            int adapterInput = super.outputAC220V();
            int adapterOutput = adapterInput / 44;
            System.out.println("use Adapter enter AC"+adapterInput+"V,output DC"+adapterOutput+"V");
            return adapterOutput;
        }
    }
}
```

## 7.桥接模式

指将抽象部分与具体实现部分分离，使它们都可以独立地变化。其主要目的是通过组合的方式建立两个类之间的联系，而不是继承，但又类似多重继承的方案。

角色：抽象、修正抽象、实现、具体实现

分离抽象部分和具体实现部分，提高了系统的扩展性，但是需要正确识别系统中两个独立变化的纬度。