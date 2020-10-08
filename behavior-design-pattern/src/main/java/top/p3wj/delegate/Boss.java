package top.p3wj.delegate;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 13:03 2020/10/8 0008
 */
public class Boss {
    public void command(String task,Leader leader) {
        leader.doing(task);
    }
}
