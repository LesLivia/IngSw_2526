package funzionale.poliflix.contenuti;

import funzionale.poliflix.contenuti.decorator.ConDoppiaggio;
import funzionale.poliflix.contenuti.decorator.ConSottotitoli;
import funzionale.poliflix.contenuti.decorator.Riproducibile;
import funzionale.poliflix.contenuti.factory.ContenutiFactory;
import funzionale.poliflix.contenuti.monitor.InputRiproduzione;
import funzionale.poliflix.contenuti.strategy.Raccomandatore;
import funzionale.poliflix.contenuti.strategy.RaccomandazionePerDurata;
import funzionale.poliflix.contenuti.strategy.RaccomandazionePerTitolo;
import funzionale.poliflix.utenti.Utente;
import funzionale.poliflix.utils.Logger;
import funzionale.poliflix.utils.PoliFlixException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public final class ManagerContenuti implements Logger {
    private static ManagerContenuti instance;
    private List<ContenutoMultimediale> contenuti;
    private Raccomandatore raccomandatore;
    private static final String pathCsv = "./resources/files/contenuti.csv";

    private final static String loggerName = "[ManagerContenuti]";

    private ManagerContenuti(List<ContenutoMultimediale> contenuti) {
        this.contenuti = contenuti;
        this.raccomandatore = new Raccomandatore(new RaccomandazionePerTitolo());
    }

    public static synchronized ManagerContenuti getInstance() {
        if (instance == null)
            try {
                instance = new ManagerContenuti(ContenutiFactory.leggiDaCsv(pathCsv));
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
        Optional<Riproducibile> contenutoScelto = this.contenuti.stream()
                .filter(c -> c.getTitolo().equalsIgnoreCase(titolo))
                .map(c -> (Riproducibile) c)
                .findFirst();
        if (contenutoScelto.isEmpty()) {
            log(loggerName, "Contenuto non trovato.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vuoi attivare i sottotitoli? (S/N)");
        if (scanner.nextLine().equalsIgnoreCase("S"))
            contenutoScelto = Optional.of(new ConSottotitoli(contenutoScelto.get()));
        System.out.println("Vuoi attivare il doppiaggio? (S/N)");
        if (scanner.nextLine().equalsIgnoreCase("S"))
            contenutoScelto = Optional.of(new ConDoppiaggio(contenutoScelto.get()));

        try {
            log(loggerName, contenutoScelto.get().getPlayMessage());
            final Riproducibile contenutoDaRiprodurre = contenutoScelto.get();
            Runnable r = contenutoDaRiprodurre::riproduci;
            Thread threadRiproduzione = new Thread(r);
            threadRiproduzione.start();
            InputRiproduzione input = new InputRiproduzione(contenutoDaRiprodurre.getMonitor());
            input.start();
            threadRiproduzione.join();
            System.out.println("Riproduzione terminata. premere q per uscire.");
            input.join();
            // Raccomandatore
            ContenutoMultimediale riferimento = this.contenuti.stream()
                    .filter(c -> c.getTitolo().equalsIgnoreCase(titolo))
                    .findFirst()
                    .get();
            log(loggerName, "Potrebbe anche piacerti:");
            this.raccomandatore.raccomanda(riferimento, this.contenuti)
                    .forEach(c -> System.out.println(c.getTitolo()));
        } catch (InterruptedException e) {
            throw new PoliFlixException("Errore nella riproduzione del contenuto.");
        }
    }

    public void sottoscrivi(Utente u) {
        Scanner scanner = new Scanner(System.in);
        log(loggerName, "Inserisci il titolo del contenuto da sottoscrivere:");
        String titoloRichiesto = scanner.nextLine();

        for (ContenutoMultimediale cm : this.contenuti)
            if (cm.getTitolo().equalsIgnoreCase(titoloRichiesto))
                if (!(cm instanceof Serie)) {
                    log(loggerName, "Sottoscrizione possibile solo per le serie.");
                    return;
                } else {
                    Serie s = (Serie) cm;
                    s.aggiungiOsservatore(u);
                    log(loggerName, "Sottoscrizione effettuata con successo.");
                    return;
                }
        log(loggerName, "Titolo non trovato.");
    }

    public void aggiornaContenuti() {
        try {
            setContenuti(ContenutiFactory.aggiornaDaCsv(pathCsv, this.contenuti));
        } catch (PoliFlixException e) {
            log(loggerName, "Errore durante l'aggiornamento dei contenuti." + e.getMessage());
        }
    }

    public void cambiaStrategiaRaccomandazione() {
        Scanner scanner = new Scanner(System.in);
        log(loggerName, "Inserisci la nuova strategia di raccomandazione (D=per durata, T=per titolo):");
        String scelta = scanner.nextLine();
        if (scelta.equalsIgnoreCase("D"))
            this.raccomandatore = new Raccomandatore(new RaccomandazionePerDurata());
        else if (scelta.equalsIgnoreCase("T"))
            this.raccomandatore = new Raccomandatore(new RaccomandazionePerTitolo());
        else
            log(loggerName, "Scelta non valida.");
    }

}
