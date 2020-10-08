package top.p3wj.chainofresponsibility;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 15:06 2020/10/8 0008
 */
public class MemberService {
    public void login(String loginName,String loginPass) {
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler())
                .build()
                .doHandle(new Member(loginName,loginPass));
    }
}
