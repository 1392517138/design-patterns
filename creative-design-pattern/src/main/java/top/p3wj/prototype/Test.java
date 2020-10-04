package top.p3wj.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/10/4 8:56 上午
 */
public class Test {
    public static void main(String[] args) {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setAge(18);
        concretePrototype.setName("LittleMonitor");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("guitar");
        hobbies.add("piano");
        concretePrototype.setHobbies(hobbies);
        ConcretePrototype cloneType = concretePrototype.deepClone();
        cloneType.setName("clone baby");
        System.out.println(concretePrototype == cloneType);
        System.out.println(cloneType);
        System.out.println(concretePrototype);
    }
}
