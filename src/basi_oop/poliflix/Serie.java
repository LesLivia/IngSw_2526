package basi_oop.poliflix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Serie {
    private String nome;
    private List<Episodio> episodi;

    public Serie(String nome) {
        this.nome = nome;
        this.episodi = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Episodio> getEpisodi() {
        return episodi;
    }

    public void setEpisodi(List<Episodio> episodi) {
        this.episodi = episodi;
    }

    public static List<Serie> leggiSerieDaCsv(String pathFile) throws IOException {
        // legge tutte le righe nel file indicato
        List<String> righe = Files.readAllLines(Path.of(pathFile));

        List<Serie> serie = new ArrayList<>();
        for (String riga : righe) {
            String rigaPulita = riga.trim();
            String[] campi = rigaPulita.split(";");
            String nomeSerie = campi[0].trim();

            Serie serieTrovata = null;
            // cerco nella lista se ho già trovato una serie con nome nomeSerie
            for (Serie s : serie)
                if (s.getNome().equals(nomeSerie))
                    serieTrovata = s;
            // altrimenti, ne creo una nuova
            if (serieTrovata == null) {
                serieTrovata = new Serie(nomeSerie);
                // e la aggiungo alla lista
                serie.add(serieTrovata);
            }

            String titoloEpisodio = campi[1].trim();
            String durataStr = campi[2].trim();
            int durata = Integer.parseInt(durataStr);

            // aggiungo l'episodio di questa riga alla serie
            serieTrovata.getEpisodi().add(new Episodio(titoloEpisodio, durata));
        }

        return serie;
    }
}
