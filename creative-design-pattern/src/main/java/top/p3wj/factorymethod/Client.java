package top.p3wj.factorymethod;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 9:54 上午
 */
public class Client {
    public static void main(String[] args) {
        IFactory factoryCurb = new FactoryCurb();
        factoryCurb.makeProduct();

        factoryCurb = new FactoryWater();
        factoryCurb.makeProduct();
    }
}
