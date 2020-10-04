# 创建型设计模式

## 1.简单工厂模式

有一个具体的工厂类，可以生成多个不同的产品。对于产品种类较少的情况，可考虑。客户端只需传入工厂类的参数，不需要关心如何创建对象的逻辑。

三个角色：简单工厂、抽象产品、具体产品

如一个工厂可根据传入的用户需求分别生产水杯、中药杯。

例子：JDK中的Calendar类，Logback中LoggerFactory中多个重载方法getLogger()

缺点：工厂类单一，当产品基数增多时，工厂类代码非常臃肿

## 2.工厂方法模式

不再由单一的工厂类生产产品，而是由工厂类子类实现具体产品的创建。当增加一个产品时每只需增加一个相应的工厂类子类。其主要解决产品扩展的问题

四个角色：抽象工厂、具体工厂、抽象产品、具体产品

如水杯与中药杯不在一个工厂里生产，由不同的工厂生产，且这两个工厂都实现了某个接口。

例子：Logback中分离处不同工厂创建不同的日志框架，如Substitute日志框架，NOP、Log4J

虽然起灵活性增强，对于新产品的创建只需要多写一个相应的工厂类，典型的解藕框架。但是类的个数容易增多，增加复杂度与系统的抽象性及理解难度。

抽象产品只能生产一种产品，这里可用下面的抽象工厂解决。即可：

```java
public interface IFactory {
  IProductA makeProductA();
  IProductB makeProductB();
}
public interface IProductA {void doA();}
public interface IProductB {void doB();}
class ConcreteProductAWithFamilyA implements IProductA{
  public void doA(){}
} 
class ConcreteProductBWithFamilyA implements IProductB{
  public void doB(){}
}
class ConcreteFactoryA implements IFactory {
	public IProductA makeProductA() {
    return new ConcreteProductAWithFamilyA();
  }
  public IProductB makeProductA() {
    return new ConcreteProductBWithFamilyA();
  }
}
public class Client {
  public static void main(String[] args){
    IFactory factory = new ConcreteFactoryA();
    factory.makeProductA();
    factory.makeProductB();
    factory = new ConcreteFactoryB();
    factory.makeProductA();
    factory.makeProductB();
  }
}
```



## 3.抽象工厂模式

客户端不必制定产品的具体类型，创建多个产品族中的产品对象。强调系列相关的产品对象（属于同一产品族）一起创建对象，需要大量重复代码。

四个角色：抽象工厂、具体工厂、抽象产品、具体产品

如：每个工厂都可以产生中药杯和水杯了，但是有许多的厂，抽象出一个抽象工厂，具体厂去继承，抽象厂中定义了产品的抽象功能。

例子：JDBC案例，每次操作都要重新创建数据库连接，我们使用抽象工厂模式，将数据库连接预先放到容器中缓存着，当业务调用时就只需现取现用。

增强了程序的可扩展性，当有新的产品组时只需要实现一个新的具体工厂即可。但是在抽象工厂中规定了所有可能被创建的产品集合，产品族中扩展新的产品困难。增加了系统的抽象性和理解难度。

## 4.单例模式

**应用场景：**

1.需要频繁创建的一些类，使用单例模式可用降低系统的内存压力，减少GC。

2.某些类创建实例时占用资源较多，实例化时间长，且经常使用。

3.频繁访问数据库或文件的对象。

4.对于一些控制硬件级别的操作，或者从系统上来讲应该是单一控制逻辑的操作，如果有多个实例，那系统会乱套。

**例子：**

##### 单例模式通用写法：

```java
public class Client {
    public static void main(String[] args) {
        Singleton.getInstance();
    }
    static class Singleton {
        private static final Singleton instance = new Singleton();
        private Singleton(){}
        public static Singleton getInstance(){
            return instance;
        }
    }
}
```

饿汉式：在类加载的时候就被初始化，并创建单例对象，它是绝对线程安全的，如果系统中有大批量的单例对象存在，那么初始化造成大量的内存浪费，从而导致系统内存不可控。

```java
public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungrySingleton;
    static {
        hungrySingleton = new HungryStaticSingleton();
    }
    public static HungryStaticSingleton getInstance(){
        return new HungryStaticSingleton();
    }
}
```

##### 懒汉模式（双重检查锁）：

双重检查锁虽然解决了线程安全和性能问题，但是只要用到synchronized总要上锁，对程序性能有一定的影响

```java
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;
    private LazyDoubleCheckSingleton(){}

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
```

##### 静态内部类：

内部类一定在方法调用之前被初始化，巧妙地避免了线程安全问题。通过反射调用其构造方法，再调用getInstance方法

```java
public class LazyStaticInnerClassSingleton {
    // With LazyStaticInnerClassSingleton, the inner class is initialized by default
    // If not used, the inner class will not be loaded
    private LazyStaticInnerClassSingleton() {
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
```

但是它还是会被反射破坏，则调用getInstance会有2个实例

```java
public class LazyStaticInnerClassSingletonTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = LazyStaticInnerClassSingletonTest.class;
            Constructor<?> c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object o1 = c.newInstance();
            Object o2 = c.newInstance();
            System.out.println( o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

结果为false。

那么我们需要在构造方法上做一些限制，一旦多次创建则抛出异常。

```java
private LazyStaticInnerClassSingleton() {
    if (LazyHolder.INSTANCE != null) {
        throw  new RuntimeException("Multiple instances are not allowed to be created");
    }
}
```

但是这里还有更优雅的方法。

##### 枚举式单例：

上面需要抛出异常，不够优雅，那么枚举方式就比较优雅。

例子：

```java
public enum  EnumSingleton {
    INSTANCE;
    private Object data;
    public Object getData() {
        return this.data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
```

测试类：

```java
public class EnumSingletonTest {
    public static void main(String[] args) {
        try {
            EnumSingleton instance1 = null;
            EnumSingleton instance2 = EnumSingleton.getInstance();
            instance2.setData(new Object());

            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance1 = (EnumSingleton) ois.readObject();
            ois.close();
            System.out.println(instance1.getData());
            System.out.println(instance2.getData());
            System.out.println(instance1 == instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

其实JDK处理上是在newInstance()上做了强制性质的判断，如果修饰符上Modifier.ENUM枚举类型，则会抛出异常，跟之前我们在构造方法中做逻辑判断抛出异常有异曲同工之妙。

##### 序列化：

此外，若通过对象实现序列化接口，则在需要时将对象序列化倒磁盘，下次使用时再读取对象进行反序列化，转为内存对象。因为反序列化后的对象会重新分配内存，即重新创建，两者是不一样的。那么怎么解决呢，加上一个无参的构造方法 readResolve()

```java
public class SeriableSingleton implements Serializable {
  public final static SeriableSingleton INSTANCE = new SeriableSingleton();
  private SeriableSingleton(){}
  private Object readResolve() {
		return Instance;
	}
}
```

通过JDK源代码可分析出，实际上对象被实例化2次，但是第二次对象没有返回，返回的是INSTANCE。其实从根本上解决的还是枚举式单例写法，因为它在类加载的时候就已经创建好了所有对象。

虽然枚举式写法优雅，虽然他在需要的时候就创建，但是它和饿汉模式差不多，类加载时将所有对象都是放在了内存当中，不适合大量创建单例对象。

##### 容器单例写法：

```java
public class ContainSingleton {
    private ContainSingleton(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className,obj);
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
```

##### ThreadLocal单例：TODO

例子：JDK源码中的Runtime类、Spring中的Bean

单例模式可用保证内存中只有一个对象，减少了内存的开销，避免对资源的多重占用。

单例模式没有接口，扩展困难。在并发测试中，单例模式不利于代码调试。在调试过程中，如果单例中的代码没有执行完，不能模拟生成一个新的对象。单例模式的功能通常写在一个类中，如果功能设计不合理，很容易违背单一职责原则。

## 5.原型模式

原型指创建对象的种类没，并且通过复制这些原型创建的新的对象。即基于内存的二进制流进行复制，不进行耗时的对象创建过程（不调用构造函数）。

JDK的Cloneable，只是为了在运行时通知Java虚拟机可用安全地在该类使用clone()方法。

例子：JDK的Cloneable接口，clone()将List中的元素循环一遍。Spring中的doGetBean()-@Scope("prototype")。

super.clone()方法直接从堆内存中以二进制流的方式进行复制，重新分配一个内存块，因此效率很高。但如果类中存在引用对象属性，则原型对象与克隆对象的该属性会指向同一对象引用。

如果想要进行深克隆，则需手动给克隆对象的相关属性分配另一块内存，如果有多个此类属性的时候，就会比较繁琐，因此我们常常采用序列化(Serializable)的方式。

## 6.建造者模式

将一个复杂对象的构建过程与它的表示分离。建造者模式与工厂模式相似，但它是针对复杂对象的创建，应用于以下场景：相同方法不同执行顺序结果不同，初始化一个对象非常复杂。

例子（通用写法）：

```java
public class Client {
    public static void main(String[] args) {
        IBuilder builder = new ConcreteBuilder();
        System.out.println(builder.build());
    }

    @Data
    static class Product {
        private String name;
        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    interface IBuilder {
        Product build();
    }
    static class ConcreteBuilder implements IBuilder {
        private Product product = new Product();
        public Product build() {
            return product;
        }
    }
}
```

例子（建造者模式的链式写法）：

```java
@Data
public class Course {
    private String name;
    private String ppt;
    private String note;
    public static class Builder {
        private Course course = new Course();
        public Builder addName(String name) {
            course.setName(name);
            return this;
        }
        public Builder addPpt(String name) {
            course.setPpt(name);
            return this;
        }
        public Builder addNote(String name) {
            course.setName(name);
            return this;
        }
        public Course builder() {
            return course;
        }
    }
}
```

测试类：

```java
public class Test {
    public static void main(String[] args) {
        Course course = new Course.Builder()
                .addName("LittleMonitor")
                .addPpt("PPT")
                .addNote("Note")
                .builder();
    }
}
```

如JPA中的SQL构造模式，JDK中的StringBuilder的append()方法，Mybatis中的CacheBuilder类、SqlSessionFactoryBuilder通过build()获得一个SqlSessionFactory类、Spring中BeanDefinitionBuilder调用getBeanDefinition()获得一个BeanDefinition对象

建造者模式封装性好，构建和表示分离，扩展性好，便于控制细节。

但是它后期维护成本大，产品内部发生变化建造者也要同步修改。