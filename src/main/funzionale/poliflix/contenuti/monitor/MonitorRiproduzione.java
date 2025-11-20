package funzionale.poliflix.contenuti.monitor;

import  funzionale.poliflix.utils.Logger;

public class MonitorRiproduzione implements Logger {
    private boolean inPausa;
    private static final String loggerName = "[MonitorRiproduzione]";

    public MonitorRiproduzione() {
        this.inPausa = false;
    }

    public synchronized void pausa() {
        this.inPausa = true;
        log(loggerName, "Riproduzione in pausa");
    }

    public synchronized void attesaPausa() throws InterruptedException {
        while (this.inPausa) {
            this.wait();
        }
    }

    public synchronized void riprendi() {
        this.inPausa = false;
        this.notifyAll();
        log(loggerName, "Riproduzione ripresa.");
    }
}
