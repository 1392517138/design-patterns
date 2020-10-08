package top.p3wj.strategy;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 14:14 2020/10/8 0008
 */
public class EmptyStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("without privileges");
    }
}
