package ereditarieta.poliflix.contenuti;

import java.util.List;

public class Film extends ContenutoMultimediale {
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
}
