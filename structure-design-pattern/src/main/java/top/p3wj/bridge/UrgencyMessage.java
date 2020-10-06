package top.p3wj.bridge;

/**
 * @author Aaron
 * @description urgency message class
 * @date 2020/10/6 11:38 下午
 */
public class UrgencyMessage extends AbstractMessage {

    // constructor
    public UrgencyMessage(IMessage iMessage) {
        super(iMessage);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "urgency: " + message;
        super.sendMessage(message, toUser);
    }

    // extend its functionality to monitor the processing status of a message
    public Object watch(String messageId) {
        // query the processiong status of the message based on the messagedId given
        // organized into monitored processing status,and then returned
        return null;
    }
}
