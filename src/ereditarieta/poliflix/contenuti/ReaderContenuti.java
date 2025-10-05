package ereditarieta.poliflix.contenuti;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderContenuti {
    public static List<ContenutoMultimediale> leggiDaCsv(String path) throws IOException {
        // legge tutte le righe nel file indicato
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
                        }
                    if (!esiste)
                        contenuti.add(nuovaSerie);
                    break;
                default:
                    System.out.println("Tipo di contenuto non supportato.");
            }
        }

        return contenuti;
    }

}
