package concorrente.esempio_base;

public class EsempioLettore extends Thread {
    private EsempioMonitor monitor;

    public EsempioLettore(EsempioMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++)
            System.out.println(this.monitor.leggi());
    }
}
