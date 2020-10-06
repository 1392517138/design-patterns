package top.p3wj.bridge;

/**
 * @author Aaron
 * @description normal message class
 * @date 2020/10/6 11:33 下午
 */
public class NomalMeeage extends AbstractMessage {

    // constructor, passing in objects that are part of the implemention
    public NomalMeeage(IMessage iMessage) {
        super(iMessage);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        // for normal messages,you simply call the superclass method to send the message
        super.sendMessage(message, toUser);
    }
}
