package top.p3wj.abstractfactory;

import top.p3wj.factorymethod.FactoryCurb;
import top.p3wj.factorymethod.FactoryWater;
import top.p3wj.factorymethod.IFactory;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 9:54 上午
 */
public class Client {
    public static void main(String[] args) {
        CupFactory cupFactory = new ConcreteFactoryA();
        cupFactory.createCurbCup();
        cupFactory.createWaterCup();
    }
}
