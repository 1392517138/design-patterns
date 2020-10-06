package top.p3wj.bridge;

/**
 * @author Aaron
 * @description an implementation class for mail messages
 * @date 2020/10/6 11:16 下午
 */
public class EmailMessage implements IMessage {
    @Override
    public void send(String message, String toUser) {
        System.out.println("use the mail to send" + message + "to" + toUser);
    }
}
