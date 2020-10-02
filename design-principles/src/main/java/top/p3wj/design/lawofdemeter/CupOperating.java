package top.p3wj.design.lawofdemeter;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 12:27 下午
 */
public class CupOperating {
    public static void pourOut(Cup cup) {
        cup.setFull(false);
        cup.setMaterial(null);
        System.out.println("pouring out now!");
    }
    public static void wash() {
        System.out.println("washing now! ");
    }
    public static void washWithCheck() {
        System.out.println("check and wash!");
    }
    public static void fill(Cup cup,Material material) {
        cup.setMaterial(material);
        System.out.println("fill now!");
    }
}
