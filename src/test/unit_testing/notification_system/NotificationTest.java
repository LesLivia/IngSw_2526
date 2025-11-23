package unit_testing.notification_system;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationTest {
    private static GenericNotification genericNotification;
    private static EmailNotification emailNotification;
    private static SmsNotification smsNotification;
    private static CriticalSystemAlert criticalSystemAlert;

    @BeforeAll
    public static void setUp() {
        genericNotification = new GenericNotification("Rapporto giornaliero pronto.");
        emailNotification = new EmailNotification("Rapporto giornaliero pronto.");
        smsNotification = new SmsNotification("Rapporto giornaliero pronto. Rapporto giornaliero pronto. Rapporto giornaliero pronto.");
        criticalSystemAlert = new CriticalSystemAlert("Server di produzione offline.", genericNotification);
    }

    @Test
    public void testSendPolymorphism() {
        List<GenericNotification> notifications = new ArrayList<>();
        notifications.add(emailNotification);
        notifications.add(smsNotification);
        notifications.add(genericNotification);
        notifications.add(criticalSystemAlert);

        assertTrue(emailNotification.formatMessage("destinatario", "oggetto").contains("EMAIL"));
        // assertTrue(notifications.getFirst().formatMessage("destinatario", "oggetto").contains("EMAIL"));
        assertTrue(notifications.getFirst().formatMessage().contains("EMAIL"));
        assertTrue(notifications.getLast().formatMessage().contains("NOTIFICA"));
        // assertThrows(IllegalArgumentException.class, () -> notifications.getLast().send("test"));
        assertThrows(IllegalArgumentException.class, () -> criticalSystemAlert.send("test"));

        assertTrue(notifications.get(1).formatMessage().contains("SMS"));

        SmsNotification smsNotificationCopy = (SmsNotification) notifications.get(1);
        criticalSystemAlert.setNotification(smsNotificationCopy);

        assertTrue(criticalSystemAlert.formatMessage("test").contains("NOTIFICA"));
        assertTrue(smsNotificationCopy.formatMessage(true).contains("SMS"));
    }
}