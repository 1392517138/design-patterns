package top.p3wj.bridge;

/**
 * @author Aaron
 * @description an implementation class for Sms messages
 * @date 2020/10/6 11:23 下午
 */
public class SmsMessage implements IMessage {
    @Override
    public void send(String message, String toUser) {
        System.out.println("use SMS to send" + message + "to" + toUser);
    }
}
