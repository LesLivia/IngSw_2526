package design_patterns.poliflix.contenuti;

import design_patterns.poliflix.utils.Logger;
import design_patterns.poliflix.utils.PoliFlixException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class ManagerContenuti implements Logger {
    private static ManagerContenuti instance;
    private List<ContenutoMultimediale> contenuti;

    private final static String loggerName = "[ManagerContenuti]";

    private ManagerContenuti(List<ContenutoMultimediale> contenuti) {
        this.contenuti = contenuti;
    }

    public static ManagerContenuti getInstance() {
        if (instance == null)
            try {
                instance = new ManagerContenuti(ContenutiFactory.leggiDaCsv("./resources/files/contenuti.csv"));
            } catch (PoliFlixException e) {
                instance = new ManagerContenuti(new ArrayList<>());
            }
        return instance;
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
            log(loggerName, i + ". Titolo: " + s.getTitolo() + ", Durata: " + s.getDurata() + " secondi.");
            i++;
        }
    }

    public void riproduci(String titolo) throws PoliFlixException {
        Riproducibile contenutoScelto = null;
        for (ContenutoMultimediale s : this.contenuti)
            if (s.getTitolo().equalsIgnoreCase(titolo))
                contenutoScelto = s;
        if (contenutoScelto == null) {
            log(loggerName, "Contenuto non trovato.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vuoi attivare i sottotitoli? (S/N)");
        if (scanner.nextLine().equalsIgnoreCase("S"))
            contenutoScelto = new ConSottotitoli(contenutoScelto);
        System.out.println("Vuoi attivare il doppiaggio? (S/N)");
        if (scanner.nextLine().equalsIgnoreCase("S"))
            contenutoScelto = new ConDoppiaggio(contenutoScelto);

        try {
            log(loggerName, contenutoScelto.getPlayMessage());
            contenutoScelto.riproduci();
            log(loggerName, "Potrebbe anche piacerti:");
            mostraAltro(contenutoScelto);
        } catch (InterruptedException e) {
            throw new PoliFlixException("Errore nella riproduzione del contenuto.");
        }
    }

    public void mostraAltro(Riproducibile cm) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(this.contenuti.size());
        while (this.contenuti.get(index) == cm)
            index = randomGenerator.nextInt(this.contenuti.size());

        log(loggerName, this.contenuti.get(index).getTitolo());
    }

}
