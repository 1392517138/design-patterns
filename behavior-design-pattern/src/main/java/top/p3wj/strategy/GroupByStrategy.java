package top.p3wj.strategy;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 14:17 2020/10/8 0008
 */
public class GroupByStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("you can get a discount for a group of 5 people");
    }
}
