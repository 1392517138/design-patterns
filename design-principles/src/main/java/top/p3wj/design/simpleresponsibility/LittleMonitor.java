package top.p3wj.design.simpleresponsibility;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 12:17 下午
 */
public class LittleMonitor {
    private static String drinkWater(){
        return new WaterCup().drink();
    }
    private static String drinkCurb(){
        return new CurbCup().drink();
    }

    public static void main(String[] args) {
        // when sick, want curb
        System.out.println(drinkCurb());
        // when daily, want water
        System.out.println(drinkWater());
    }
}
