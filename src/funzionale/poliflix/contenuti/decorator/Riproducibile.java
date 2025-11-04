package funzionale.poliflix.contenuti.decorator;

import funzionale.poliflix.contenuti.monitor.MonitorRiproduzione;

public abstract class Riproducibile {
    protected MonitorRiproduzione monitor;

    public Riproducibile(MonitorRiproduzione monitor) {
        this.monitor = monitor;
    }

    public MonitorRiproduzione getMonitor() {
        return monitor;
    }

    public abstract void riproduci();

    public abstract String getPlayMessage();
}
