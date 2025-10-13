package oop_avanzato.poliflix.contenuti;

import java.util.concurrent.TimeUnit;

public class Documentario extends ContenutoMultimediale {
    private String tema;
    private String regista;

    public Documentario(String titolo, int durata, String tema, String regista) {
        super(titolo, durata);
        this.tema = tema;
        this.regista = regista;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public static Documentario parsaRiga(String riga) {
        String rigaPulita = riga.trim();
        String[] campi = rigaPulita.split(";");

        return new Documentario(campi[1], Integer.parseInt(campi[2]), campi[3], campi[4]);
    }

    @Override
    public String getPlayMessage() {
        return "Riproducendo documentario " + this.titolo + " di " +
                this.regista + " su " + this.tema + "...";
    }

    @Override
    public void riproduci() throws InterruptedException {
        TimeUnit.SECONDS.sleep(this.getDurata());
    }

    @Override
    public String generaLinkCondivisione() {
        return "https://poliflix.it/share/doc?title=" + getTitolo().replace(" ", "%20");
    }
}
