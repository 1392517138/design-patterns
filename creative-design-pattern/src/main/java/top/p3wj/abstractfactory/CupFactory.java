package top.p3wj.abstractfactory;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 10:51 上午
 */
public abstract class CupFactory {
    public void init() {
        System.out.println("factory init!");
    }

    protected abstract ICurbCup createCurbCup();

    protected abstract IWaterCup createWaterCup();
}
