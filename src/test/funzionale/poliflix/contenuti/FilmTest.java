package funzionale.poliflix.contenuti;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FilmTest {
    static Film f;

    @BeforeAll
    public static void setUp() throws Exception {
        f = new Film("titolo_test", 5, "genere_test", Arrays.asList("attore 1", "attore 2"));
    }

    @Test
    public void getGenere_test() {
        assertEquals("genere_test", f.getGenere());
    }

    @Test
    public void parsaRiga_test() {
        String riga = "Film;Inception;8;Sci-Fi;Leonardo DiCaprio,Joseph Gordon-Levitt,Ellen Page,Tom Hardy";

        Film parsato = Film.parsaRiga(riga);

        assertEquals("Inception", parsato.getTitolo());
    }

    @Test
    public void riproduci_test() {
        try {
            f.riproduci();
        } catch (AssertionError e) {
            fail("Riproduzione non riuscita.");
        }
    }
}
