package unit_testing.notification_system;

public class CriticalSystemAlert extends GenericNotification {
    private GenericNotification notification;

    public CriticalSystemAlert(String content, GenericNotification notification) {
        super(content);
        this.notification = notification;
    }

    public void setNotification(GenericNotification notification) {
        this.notification = notification;
    }

    public GenericNotification getNotification() {
        return notification;
    }

    @Override
    public void send() {
        System.out.println("!!! LOG CRITICO: Allerta del sistema INIZIATA !!!");
        super.send();
        System.out.println("!!! LOG CRITICO: Allerta del sistema COMPLETATA !!!");
    }

    /**
     * Aggiunge una versione specifica per l'allerta con priorità.
     *
     * @param priorityLevel Il livello di priorità (es. "HIGH", "MEDIUM").
     */
    public void send(String priorityLevel) {
        if (!priorityLevel.equalsIgnoreCase("high")
                && !priorityLevel.equalsIgnoreCase("medium")
                && !priorityLevel.equalsIgnoreCase("low"))
            throw new IllegalArgumentException("Priority level must be 'high', 'medium' or 'low'.");
        String formattedContent = formatMessage(this.notification.content);
        System.out.println("--- Invio Allerta con Priorità: " + priorityLevel + " ---");
        System.out.println("Contenuto: " + formattedContent);
    }
}