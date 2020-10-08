package top.p3wj.chainofresponsibility;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 15:08 2020/10/8 0008
 */
public class AuthHandler extends Handler {
    @Override
    public void doHandle(Member member) {
        if ("administrator".equals(member.getRoleName())) {
            System.out.println("you are not administrator,unauthorized");
            return;
        }
        System.out.println("you are administrator,allows operation");
    }
}
