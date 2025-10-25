package concorrente.esempio_base;

public class EsempioScrittore extends Thread {
    private EsempioMonitor monitor;

    public EsempioScrittore(EsempioMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        String[] messaggi = {"ciao", "buongiorno", "buonasera"};

        for (String m : messaggi) {
            monitor.scrivi(m);
            System.out.println("Scritto: " + m);
        }
    }
}
