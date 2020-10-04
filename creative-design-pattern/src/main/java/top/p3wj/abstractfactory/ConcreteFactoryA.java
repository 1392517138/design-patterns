package top.p3wj.abstractfactory;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 10:53 上午
 */
public class ConcreteFactoryA extends CupFactory {
    @Override
    protected ICurbCup createCurbCup() {
        super.init();
        return new CurbCupA();
    }

    @Override
    protected IWaterCup createWaterCup() {
        super.init();
        return new WaterCupA();
    }
}
