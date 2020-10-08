package top.p3wj.chainofresponsibility;

import org.apache.commons.lang.StringUtils;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 15:08 2020/10/8 0008
 */
public class ValidateHandler extends Handler {
    @Override
    public void doHandle(Member member) {
        if (StringUtils.isEmpty(member.getLoginName()) ||
        StringUtils.isEmpty(member.getLoginPass())) {
            System.out.println("the username or password is empty");
            return;
        }
        System.out.println("username and password checked successfully processed");
        chain.doHandle(member);
    }
}
