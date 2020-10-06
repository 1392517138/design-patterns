package top.p3wj.adapter;

/**
 * @author Aaron
 * @description
 * @date 2020/10/6 8:26 下午
 */
public class Client {
    public static void main(String[] args) {
        PowerAdapter powerAdapter = new PowerAdapter();
        powerAdapter.output5V();
    }

    interface DC5 {
        int output5V();
    }

    static class AC220 {
        public int outputAC220V() {
            int output = 220;
            System.out.println("the out put voltage is " + output + "V");
            return output;
        }
    }

    static class PowerAdapter extends AC220 implements DC5 {
        @Override
        public int output5V() {
            int adapterInput = super.outputAC220V();
            int adapterOutput = adapterInput / 44;
            System.out.println("use Adapter enter AC" + adapterInput + "V,output DC" + adapterOutput + "V");
            return adapterOutput;
        }
    }
}

