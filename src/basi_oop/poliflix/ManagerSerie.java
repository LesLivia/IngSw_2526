package basi_oop.poliflix;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManagerSerie {
    private List<Serie> serie;

    public ManagerSerie(List<Serie> serie) {
        this.serie = serie;
    }

    public List<Serie> getSerie() {
        return serie;
    }

    public void setSerie(List<Serie> serie) {
        this.serie = serie;
    }

    public void stampaSerie() {
        int i = 1;
        for (Serie s : this.serie) {
            System.out.println(i + ". Titolo: " + s.getNome() + ", " + s.getEpisodi().size() + " episodi");
            i++;
        }
    }

    public void guardaSerie(String nomeSerie) throws InterruptedException {
        Serie serieScelta = null;
        for (Serie s : this.serie)
            if (s.getNome().equals(nomeSerie))
                serieScelta = s;
        if (serieScelta == null) {
            System.out.println("Serie non trovata.");
            return;
        }

        for (Episodio e : serieScelta.getEpisodi()) {
            System.out.println("Riproduzione " + e.getTitolo() + " in corso... ");
            TimeUnit.SECONDS.sleep(e.getDurata());
        }
    }

}
