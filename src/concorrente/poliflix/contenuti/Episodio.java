package concorrente.poliflix.contenuti;

import java.util.concurrent.TimeUnit;

public class Episodio extends ContenutoMultimediale {
    public Episodio(String titolo, int durata) {
        super(titolo, durata);
    }

    @Override
    public String getPlayMessage() {
        return "Riproducendo " + this.titolo + "...";
    }

    @Override
    public void run() {
        int countdown = this.getDurata();
        while (countdown > 0) {
            try {
                this.monitor.attesaPausa();
                TimeUnit.SECONDS.sleep(1);
                log("[Film]", countdown + " secondi rimanenti");
                countdown--;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void riproduci() {
        this.start();
    }

    @Override
    public String generaLinkCondivisione() {
        return "https://poliflix.it/share/serie?ep=" + this.titolo.replace(" ", "%20");
    }
}