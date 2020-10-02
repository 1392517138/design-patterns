package top.p3wj.design.compositeaggregatereuse;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 2:09 下午
 */
public class LittleMonitor {
    private Cup cup;

    public void setCup(Cup cup) {
        this.cup = cup;
    }
    public void drinkILike() {
        cup.getDrink();
    }
}
