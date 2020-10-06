package top.p3wj.bridge;

/**
 * @author Aaron
 * @description unified interface for message sending is implemented
 * @date 2020/10/6 11:13 下午
 */

public interface IMessage {
    // the content and recipient of the message to be sent
    void send(String message, String toUser);
}
