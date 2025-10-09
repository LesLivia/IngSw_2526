package oop_avanzato.poliflix.contenuti;

import oop_avanzato.poliflix.utils.PoliFlixException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderContenuti {

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
                                serie.aggiungiEpisodio(nuovaSerie.getEpisodi().getFirst());
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

}
