package top.p3wj.design.lawofdemeter;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 12:29 下午
 */
public class MainProcess {
    public static void main(String[] args) {
        /** The toilet is seperate from the water receiving room,and we ofen wash cups at toilet
         *  1. Pour out the curb
         *  2. wash it
         *  3. thoroughly washed?
         *  ------ In fact,it shoud have been cleaned,and it was found that it
         *  was not cleaned when it was halfway through the filling of pure water!
         *  4. fill it with water
         */
        // set status to full
        Cup cup = new Cup(true, Material.CURB);
        Toilet.curbDo(cup);
        WaterRoom.waterDo(cup);
    }
}
