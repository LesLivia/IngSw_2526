package concorrente.poliflix.contenuti;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Film extends ContenutoMultimediale {
    private static final String formatoVideo = "4K";
    private String genere;
    private List<String> cast;

    public Film() {
        super("", 0);
        this.genere = "";
        this.cast = List.of();
    }

    public Film(String titolo, int durata, String genere, List<String> cast) {
        super(titolo, durata);
        this.genere = genere;
        this.cast = cast;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public static Film parsaRiga(String riga) {
        String rigaPulita = riga.trim();
        String[] campi = rigaPulita.split(";");

        return new Film(campi[1], Integer.parseInt(campi[2]), campi[3], List.of(campi[4].split(",")));
    }

    public String getPlayMessage() {
        String msg = "Riproducendo film " + this.titolo + "...\n";
        StringBuilder msgCast = new StringBuilder("Titoli di testa: \n");
        for (String s : this.cast)
            msgCast.append(s).append("\n");

        return msg + msgCast;
    }

    public void riproduci() {
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
    public String generaLinkCondivisione() {
        return "https://poliflix.it/share/film?title=" + this.titolo.replace(" ", "%20");
    }
}
