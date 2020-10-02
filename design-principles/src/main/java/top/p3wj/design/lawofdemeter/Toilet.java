package top.p3wj.design.lawofdemeter;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 12:28 下午
 */
public class Toilet {
    public static void curbDo(Cup cup){
        CupOperating.pourOut(cup);
        CupOperating.wash();
    }
}
