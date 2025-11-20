package concorrente.esempio_base;

import java.util.concurrent.TimeUnit;

public class EsempioThread extends Thread {
    private String nome;

    public EsempioThread(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.nome + " avviato!");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Errore nella sincronizzazione del thread.");
        }
        System.out.println("Thread " + this.nome + " terminato!");
    }
}
