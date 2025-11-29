package funzionale.poliflix.contenuti.strategy;

import funzionale.poliflix.contenuti.ContenutoMultimediale;
import funzionale.poliflix.contenuti.Film;
import funzionale.poliflix.contenuti.factory.ContenutiFactory;
import funzionale.poliflix.utils.PoliFlixException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RaccomandatoreTest {
    @Test
    public void test_raccomandatore() {
        List<ContenutoMultimediale> contenuti = new ArrayList<>();
        try {
            contenuti = ContenutiFactory.leggiDaCsv("./resources/files/contenuti.csv");
        } catch (PoliFlixException e) {
            e.printStackTrace();
        }

        ContenutoMultimediale contenuto_test = new Film("test_titolo", 5, "test_genere", new ArrayList<>());
        Raccomandatore raccomandatore_test = new Raccomandatore(new RaccomandazionePerDurata());
        List<ContenutoMultimediale> raccomandazioni = raccomandatore_test.raccomanda(contenuto_test, contenuti);
        assertFalse(raccomandazioni.isEmpty());
    }

}
