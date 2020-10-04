package top.p3wj.simplefactory;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 9:35 上午
 */
public class Client {
    public static void main(String[] args) {
        SimpleFactory.makeProduct(0);
    }

    public interface IProduct {
        String doDrink();
    }

    public static class WaterCup implements IProduct {
        public String doDrink() {
            return "Water is nice!";
        }
    }

    public static class CurbCup implements IProduct {
        public String doDrink() {
            return "Curb is nice!";
        }
    }

    static class SimpleFactory {
        public static IProduct makeProduct(int kind) {
            switch (kind) {
                case Const.PRODUCT_A:
                    return new WaterCup();
                case Const.PRODUCT_B:
                    return new CurbCup();
            }
            return null;
        }
    }

    final class Const {
        static final int PRODUCT_A = 0;
        static final int PRODUCT_B = 1;
    }
}
