package funzionale.poliflix.contenuti;

import  funzionale.poliflix.contenuti.observer.Osservabile;
import  funzionale.poliflix.utenti.observer.Osservatore;

import java.util.ArrayList;
import java.util.List;

public class Serie extends ContenutoMultimediale implements Osservabile {
    private List<Episodio> episodi;
    private List<Osservatore> subscribers;

    public Serie(String titolo) {
        super(titolo, 0);
        this.episodi = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public List<Episodio> getEpisodi() {
        return episodi;
    }

    public void setEpisodi(List<Episodio> episodi) {
        this.episodi = episodi;
    }

    @Override
    public void aggiungiOsservatore(Osservatore o) {
        this.subscribers.add(o);
    }

    @Override
    public void notifica(String msg) {
        for (Osservatore o : this.subscribers)
            o.riceviNotifica(msg);
    }

    public void aggiungiEpisodio(Episodio episodio, boolean notifica) {
        this.episodi.add(episodio);
        this.setDurata(this.getDurata() + episodio.getDurata());
        if (notifica)
            this.notifica(" Aggiunto episodio " + this.getTitolo() + ": " + episodio.getTitolo() + "!");
    }

    @Override
    public String getPlayMessage() {
        return "Riproducendo serie " + this.titolo + "...";
    }

    public void riproduci() {
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
        serie.aggiungiEpisodio(new Episodio(titoloEpisodio, durata), false);

        return serie;
    }

    @Override
    public String generaLinkCondivisione() {
        // Condivide la serie completa
        return "https://poliflix.it/share/serie?title=" + this.titolo.replace(" ", "%20");
    }
}
