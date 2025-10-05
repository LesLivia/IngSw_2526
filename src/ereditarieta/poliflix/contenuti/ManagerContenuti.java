package ereditarieta.poliflix.contenuti;

import java.util.List;
import java.util.Random;

public class ManagerContenuti {
    private List<ContenutoMultimediale> contenuti;

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
            System.out.println("Contenuto non trovato.");
            return;
        }

        contenutoScelto.riproduci();
    }

    public void mostraAltro(ContenutoMultimediale cm) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(this.contenuti.size());
        while (this.contenuti.get(index) == cm)
            index = randomGenerator.nextInt(this.contenuti.size());

        System.out.println(this.contenuti.get(index).getTitolo());
    }

    public void mostraAltro(Film film) {
        for (ContenutoMultimediale s : this.contenuti)
            if (s instanceof Film) {
                Film altro = (Film) s;
                if (altro.getGenere().equals(film.getGenere()) &&
                        !altro.getTitolo().equals(film.getTitolo()))
                    System.out.println(altro.getTitolo());
            }
    }

}
