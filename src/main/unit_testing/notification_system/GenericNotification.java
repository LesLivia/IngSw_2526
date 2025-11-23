package unit_testing.notification_system;

public class GenericNotification {
    protected String content;

    public GenericNotification(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void send() {
        System.out.println(formatMessage());
    }

    public String formatMessage() {
        return "[NOTIFICA] " + content;
    }

    public String formatMessage(String input) {
        return "[NOTIFICA] " + input;
    }
}