package top.p3wj.factorymethod;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 9:53 上午
 */
public class FactoryCurb implements IFactory {
    public IProduct makeProduct() {
        return new CurbCup();
    }
}
