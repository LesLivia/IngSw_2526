package unit_testing.notification_system;

public class EmailNotification extends GenericNotification {
    public EmailNotification(String content) {
        super(content);
    }

    public String formatMessage() {
        return "[EMAIL] " + content;
    }

    /**
     * Versione con parametri specifici per l'email.
     *
     * @param recipient L'indirizzo del destinatario.
     * @param subject   L'oggetto dell'email.
     */
    public String formatMessage(String recipient, String subject) {
        return "[EMAIL to " + recipient + " - " + subject + " ]" + this.content;
    }
}