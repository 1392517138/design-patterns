package top.p3wj.delegate;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 12:32 2020/10/8 0008
 */
public class EmplyeeA implements IEmployee {
    protected String goodAt = "coding";

    public void doing(String task) {
        System.out.println("I'm employeeA,I'm good at "+goodAt+",let's do "+task+" now");
    }
}
