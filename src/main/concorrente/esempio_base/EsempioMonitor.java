package concorrente.esempio_base;

public class EsempioMonitor {
    private String messaggio;
    private boolean nuovoMessaggio;

    public EsempioMonitor() {
        this.messaggio = null;
        this.nuovoMessaggio = false;
    }

    public synchronized void scrivi(String messaggio) {
        while (this.nuovoMessaggio) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.messaggio = messaggio;
        this.nuovoMessaggio = true;
        notifyAll();
    }

    public synchronized String leggi() {
        while (!this.nuovoMessaggio) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.nuovoMessaggio = false;
        notifyAll();
        return this.messaggio;
    }
}
