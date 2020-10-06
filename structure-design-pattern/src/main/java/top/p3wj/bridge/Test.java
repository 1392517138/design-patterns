package top.p3wj.bridge;

/**
 * @author Aaron
 * @description
 * @date 2020/10/6 11:55 下午
 */
public class Test {
    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbstractMessage abstractMessage = new NomalMeeage(message);
        abstractMessage.sendMessage("request for overtime prompt approval ", " boss wang");

        message = new EmailMessage();
        abstractMessage = new UrgencyMessage(message);
        abstractMessage.sendMessage("request for overtime prompt approval ", " boss wang");

    }
}
