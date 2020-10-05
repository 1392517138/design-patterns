package top.p3wj.decorator;

/**
 * @author Aaron
 * @description
 * @date 2020/10/5 7:49 下午
 */
public class SausageDecorator extends BattercakeDecorator {
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "one sausage";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
