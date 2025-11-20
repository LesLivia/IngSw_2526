package oop_avanzato.poliflix.contenuti;

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
    public void riproduci() throws InterruptedException {
        TimeUnit.SECONDS.sleep(this.getDurata());
    }

    @Override
    public String generaLinkCondivisione() {
        return "https://poliflix.it/share/serie?ep=" + this.titolo.replace(" ", "%20");
    }
}