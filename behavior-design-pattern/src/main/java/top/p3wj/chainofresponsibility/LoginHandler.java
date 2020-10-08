package top.p3wj.chainofresponsibility;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 15:08 2020/10/8 0008
 */
public class LoginHandler extends Handler {
    @Override
    public void doHandle(Member member) {
        System.out.println("login success");
        member.setRoleName("administrator");
        chain.doHandle(member);
    }
}
