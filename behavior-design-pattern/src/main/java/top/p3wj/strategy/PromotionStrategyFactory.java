package top.p3wj.strategy;

import sun.invoke.empty.Empty;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 14:10 2020/10/8 0008
 */
public class PromotionStrategyFactory {
    private static Map<String,IPromotionStrategy> PROMOTIONS = new HashMap<String,
            IPromotionStrategy>();
    private static final IPromotionStrategy EMPTY = new EmptyStrategy();

    public PromotionStrategyFactory() {
    }

    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }
    static {
        PROMOTIONS.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTIONS.put(PromotionKey.CASHBACK,new CashBackStrategy());
        PROMOTIONS.put(PromotionKey.GROUPBUY,new GroupByStrategy());
    }
    public static IPromotionStrategy getPromotionStrategy(String promotionKey) {
        IPromotionStrategy strategy = PROMOTIONS.get(promotionKey);
        return strategy == null ? EMPTY:strategy;
    }

    public static Set<String> getPromotionKeys() {
        return PROMOTIONS.keySet();
    }
}
