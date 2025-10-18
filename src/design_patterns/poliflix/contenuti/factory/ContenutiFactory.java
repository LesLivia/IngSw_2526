package design_patterns.poliflix.contenuti.factory;

import design_patterns.poliflix.contenuti.*;
import design_patterns.poliflix.utils.PoliFlixException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class ContenutiFactory {
    public static List<ContenutoMultimediale> leggiDaCsv(String path) throws PoliFlixException {
        // legge tutte le righe nel file indicato
        try {
            List<String> righe = Files.readAllLines(Path.of(path));

            List<ContenutoMultimediale> contenuti = new ArrayList<>();
            for (String riga : righe) {
                String rigaPulita = riga.trim();
                String[] campi = rigaPulita.split(";");

                // cambia il modo in cui viene processata la riga a seconda del tipo di contenuto
                switch (campi[0].trim()) {
                    case "Film":
                        contenuti.add(Film.parsaRiga(riga));
                        break;
                    case "Documentario":
                        contenuti.add(Documentario.parsaRiga(riga));
                        break;
                    case "Serie":
                        Serie nuovaSerie = Serie.parsaRiga(riga);
                        boolean esiste = false;
                        for (ContenutoMultimediale cm : contenuti)
                            if (cm.getTitolo().equals(nuovaSerie.getTitolo())) {
                                Serie serie = (Serie) cm;
                                serie.aggiungiEpisodio(nuovaSerie.getEpisodi().getFirst(), false);
                                esiste = true;
                                break;
                            }
                        if (!esiste)
                            contenuti.add(nuovaSerie);
                        break;
                    default:
                        throw new PoliFlixException("Tipo di contenuto non supportato.");
                }
            }
            return contenuti;
        } catch (IOException e) {
            throw new PoliFlixException("Errore durante la lettura del file.");
        }
    }

    public static List<ContenutoMultimediale> aggiornaDaCsv(String path, List<ContenutoMultimediale> contenutiEsistenti) throws PoliFlixException {
        // legge tutte le righe nel file indicato
        try {
            List<String> righe = Files.readAllLines(Path.of(path));

            for (String riga : righe) {
                String rigaPulita = riga.trim();
                String[] campi = rigaPulita.split(";");
                boolean esiste = false;

                // cambia il modo in cui viene processata la riga a seconda del tipo di contenuto
                switch (campi[0].trim()) {
                    case "Film":
                        Film filmLetto = Film.parsaRiga(riga);
                        for (ContenutoMultimediale cm : contenutiEsistenti)
                            if (cm.getTitolo().equalsIgnoreCase(filmLetto.getTitolo())) {
                                esiste = true;
                                break;
                            }
                        if (!esiste)
                            contenutiEsistenti.add(filmLetto);
                        break;
                    case "Documentario":
                        Documentario docLetto = Documentario.parsaRiga(riga);
                        for (ContenutoMultimediale cm : contenutiEsistenti)
                            if (cm.getTitolo().equalsIgnoreCase(docLetto.getTitolo())) {
                                esiste = true;
                                break;
                            }
                        if (!esiste)
                            contenutiEsistenti.add(docLetto);
                        break;
                    case "Serie":
                        Serie nuovaSerie = Serie.parsaRiga(riga);
                        boolean esisteEpisodio = false;
                        for (ContenutoMultimediale cm : contenutiEsistenti)
                            if (cm.getTitolo().equals(nuovaSerie.getTitolo())) {
                                esiste = true;
                                Serie serie = (Serie) cm;
                                for (Episodio ep : serie.getEpisodi())
                                    if (ep.getTitolo().equals(nuovaSerie.getEpisodi().getFirst().getTitolo())) {
                                        esisteEpisodio = true;
                                        break;
                                    }
                                if (!esisteEpisodio)
                                    serie.aggiungiEpisodio(nuovaSerie.getEpisodi().getFirst(), true);
                                break;
                            }
                        if (!esiste)
                            contenutiEsistenti.add(nuovaSerie);
                        break;
                    default:
                        throw new PoliFlixException("Tipo di contenuto non supportato.");
                }
            }
            return contenutiEsistenti;
        } catch (IOException e) {
            throw new PoliFlixException("Errore durante la lettura del file.");
        }
    }
}
