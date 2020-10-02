package top.p3wj.design.lawofdemeter;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 12:28 下午
 */
public class WaterRoom {
    public static void waterDo(Cup cup){
//        CupOperating.washWithCheck();
        CupOperating.fill(cup,Material.WATER);
    }
}
