package top.p3wj.strategy;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 14:16 2020/10/8 0008
 */
public class CashBackStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("cash back,direct debit to Alipay account");
    }
}
