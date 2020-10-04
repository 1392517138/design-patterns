package top.p3wj.factorymethod;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 9:52 上午
 */
public class FactoryWater implements IFactory {

    public IProduct makeProduct() {
        return new WaterCup();
    }
}
