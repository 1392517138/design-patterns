package top.p3wj.decorator;

/**
 * @author Aaron
 * @description
 * @date 2020/10/5 7:43 下午
 */
public abstract class BattercakeDecorator extends Battercake {
    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
