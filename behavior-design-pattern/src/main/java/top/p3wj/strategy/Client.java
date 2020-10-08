package top.p3wj.strategy;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 14:36 2020/10/8 0008
 */
public class Client {
    public static void main(String[] args) {
        PromotionStrategyFactory.getPromotionKeys();
        String promotionKey = "COUPON";
        IPromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
        promotionStrategy.doPromotion();
    }
}
