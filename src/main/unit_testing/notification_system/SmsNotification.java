package unit_testing.notification_system;

public class SmsNotification extends GenericNotification {
    private static final int SMS_MAX_LENGTH = 60;
    private static final int TRUNCATE_FORCE_LENGTH = 50;

    public SmsNotification(String content) {
        super(content);
    }

    @Override
    public String formatMessage() {
        if (content.length() <= SMS_MAX_LENGTH) {
            return super.formatMessage();
        }
        return "[SMS TRONCATO] " + content.substring(0, SMS_MAX_LENGTH - 4) + " [...]";
    }

    /**
     * Versione che forza la troncatura a una lunghezza molto ridotta.
     *
     * @param forceTruncate Se true, tronca a 50 caratteri.
     * @return Il messaggio formattato.
     */
    public String formatMessage(boolean forceTruncate) {
        if (forceTruncate) {
            if (content.length() > TRUNCATE_FORCE_LENGTH) {
                return "[SMS FORZATO] " + content.substring(0, TRUNCATE_FORCE_LENGTH - 4) + " [...]";
            }
            return "[SMS FORZATO] " + content;
        }
        return formatMessage();
    }
}