package top.p3wj.decorator;

/**
 * @author Aaron
 * @description
 * @date 2020/10/5 7:46 下午
 */
public class EggDecorator extends BattercakeDecorator {
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "one egg";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
