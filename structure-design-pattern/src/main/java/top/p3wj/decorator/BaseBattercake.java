package top.p3wj.decorator;

/**
 * @author Aaron
 * @description
 * @date 2020/10/5 7:42 下午
 */
public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg() {
        return "cake";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
