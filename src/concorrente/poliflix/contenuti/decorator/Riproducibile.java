package concorrente.poliflix.contenuti.decorator;

import concorrente.poliflix.contenuti.monitor.MonitorRiproduzione;

public abstract class Riproducibile extends Thread {
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
