package top.p3wj.decorator;

/**
 * @author Aaron
 * @description
 * @date 2020/10/5 7:50 下午
 */
public class Test {
    public static void main(String[] args) {
        Battercake battercake = new BaseBattercake();
        battercake = new EggDecorator(battercake);
        System.out.println(battercake.getMsg());
        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMsg());

    }
}
