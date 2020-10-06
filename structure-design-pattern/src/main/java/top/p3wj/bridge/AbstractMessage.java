package top.p3wj.bridge;

/**
 * @author Aaron
 * @description abstract message class
 * @date 2020/10/6 11:25 下午
 */
public abstract class AbstractMessage {
    // object that hold an implemention part
    IMessage iMessage;

    // constructor,passing in objects that are part of the implemention
    public AbstractMessage(IMessage iMessage) {
        this.iMessage = iMessage;
    }

    // send messages,Delegate methods to the implemention section
    public void sendMessage(String message, String toUser) {
        this.iMessage.send(message, toUser);
    }
}
