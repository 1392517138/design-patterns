package top.p3wj.design.compositeaggregatereuse;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 2:11 下午
 */
public class BigMonitor {
    public static void main(String[] args) {
        LittleMonitor littleMonitor = new LittleMonitor();
        littleMonitor.setCup(new CurbCup());
        littleMonitor.drinkILike();
    }
}
