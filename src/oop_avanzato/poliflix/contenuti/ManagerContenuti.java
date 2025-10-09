package oop_avanzato.poliflix.contenuti;

import oop_avanzato.poliflix.utils.Logger;

import java.util.List;
import java.util.Random;

public class ManagerContenuti implements Logger {
    private List<ContenutoMultimediale> contenuti;

    private final String loggerName = "[ManagerContenuti]";

    public ManagerContenuti(List<ContenutoMultimediale> contenuti) {
        this.contenuti = contenuti;
    }

    public List<ContenutoMultimediale> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<ContenutoMultimediale> contenuti) {
        this.contenuti = contenuti;
    }

    public void stampaInformazioni() {
        int i = 1;
        for (ContenutoMultimediale s : this.contenuti) {
            System.out.println(i + ". Titolo: " + s.getTitolo() + ", Durata: " + s.getDurata() + " secondi.");
            i++;
        }
    }

    public void riproduci(String titolo) throws InterruptedException {
        ContenutoMultimediale contenutoScelto = null;
        for (ContenutoMultimediale s : this.contenuti)
            if (s.getTitolo().equalsIgnoreCase(titolo))
                contenutoScelto = s;
        if (contenutoScelto == null) {
            log(loggerName, "Contenuto non trovato.");
            return;
        }

        log(loggerName, contenutoScelto.getPlayMessage());
        contenutoScelto.riproduci();
        log(loggerName, "Potrebbe anche piacerti:");
        mostraAltro(contenutoScelto);
    }

    public void mostraAltro(ContenutoMultimediale cm) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(this.contenuti.size());
        while (this.contenuti.get(index) == cm)
            index = randomGenerator.nextInt(this.contenuti.size());

        log(loggerName, this.contenuti.get(index).getTitolo());
    }

    public void mostraAltro(Film film) {
        for (ContenutoMultimediale s : this.contenuti)
            if (s instanceof Film) {
                Film altro = (Film) s;
                if (altro.getGenere().equals(film.getGenere()) &&
                        !altro.getTitolo().equals(film.getTitolo()))
                    log(loggerName, altro.getTitolo());
            }
    }

}
