package oop_avanzato.poliflix.contenuti;

import java.util.ArrayList;
import java.util.List;

public class Serie extends ContenutoMultimediale {
    private List<Episodio> episodi;

    public Serie(String titolo) {
        super(titolo, 0);
        this.episodi = new ArrayList<>();
    }

    public List<Episodio> getEpisodi() {
        return episodi;
    }

    public void setEpisodi(List<Episodio> episodi) {
        this.episodi = episodi;
    }

    public void aggiungiEpisodio(Episodio episodio) {
        this.episodi.add(episodio);
        this.setDurata(this.getDurata() + episodio.getDurata());
    }

    @Override
    public String getPlayMessage() {
        return "Riproducendo serie " + this.titolo + "...";
    }

    public void riproduci() throws InterruptedException {
        for (Episodio e : this.episodi) {
            System.out.println(e.getPlayMessage());
            e.riproduci();
        }
    }

    public static Serie parsaRiga(String riga) {
        String rigaPulita = riga.trim();
        String[] campi = rigaPulita.split(";");
        String titolo = campi[1].trim();

        String titoloEpisodio = campi[2].trim();
        String durataStr = campi[3].trim();
        int durata = Integer.parseInt(durataStr);

        Serie serie = new Serie(titolo);
        // aggiungo l'episodio di questa riga alla serie e aggiorno la durata
        serie.aggiungiEpisodio(new Episodio(titoloEpisodio, durata));

        return serie;
    }
}
