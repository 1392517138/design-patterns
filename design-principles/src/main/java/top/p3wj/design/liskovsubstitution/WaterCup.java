package top.p3wj.design.liskovsubstitution;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 11:17 上午
 */
public class WaterCup extends CurbCup {
//    public void getOriginCup(){
//        super.getDrink();
//    }
//
//    @Override
//    public String getDrink(){
//        return super.getDrink()+"but I think water is better";
//    }
    public String getWaterDrink() {
        return "I can drink water,too";
    }
}
