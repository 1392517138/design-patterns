package top.p3wj.design.dependenceinversion;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 12:04 下午
 */
public class Girl implements ILove{

    public static void main(String[] args) {
        Boy boy = new Boy();
        //before
        boy.loveA();
        boy.LoveB();
        //afeter education
        EduAftBoy eduAftBoy = new EduAftBoy();
        System.out.println(eduAftBoy.love(new Girl()));
    }

    public String love(String name) {
        return name;
    }
}
