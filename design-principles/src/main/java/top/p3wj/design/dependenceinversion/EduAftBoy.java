package top.p3wj.design.dependenceinversion;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 12:07 下午
 */
public class EduAftBoy {

    public String love(ILove iLove){
        return iLove.love(iLove.toString());
    }
}
