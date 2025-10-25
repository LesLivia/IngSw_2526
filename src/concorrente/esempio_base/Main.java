package concorrente.esempio_base;

public class Main {
    public static void main(String[] args) {
        EsempioThread t1 = new EsempioThread("Thread 1");
        EsempioThread t2 = new EsempioThread("Thread 2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Errore nella sincronizzazione dei thread.");
        }

        Thread t3 = new Thread(new EsempioRunnable("Runnable 1"));
        Thread t4 = new Thread(new EsempioRunnable("Runnable 2"));

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Errore nella sincronizzazione dei thread.");
        }

        EsempioMonitor esempio = new EsempioMonitor();
        EsempioScrittore scrittore = new EsempioScrittore(esempio);
        EsempioLettore lettore = new EsempioLettore(esempio);

        scrittore.start();
        lettore.start();
    }
}
