package funzionale.poliflix.contenuti;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class FilmTest {
    Film f;

    @Before
    public void setUp() throws Exception {
        f = new Film("titolo_test", 5, "genere_test", Arrays.asList("attore 1", "attore 2"));
    }

    @Test
    public void getGenere_test() {
        Assert.assertEquals("genere_test", f.getGenere());
    }

    @Test
    public void parsaRiga_test() {
        String riga = "Film;Inception;8;Sci-Fi;Leonardo DiCaprio,Joseph Gordon-Levitt,Ellen Page,Tom Hardy";

        Film parsato = Film.parsaRiga(riga);

        Assert.assertEquals("Inception", parsato.getTitolo());
    }

    @Test
    public void riproduci_test() {
        try {
            f.riproduci();
        } catch (AssertionError e) {
            Assert.fail("Riproduzione non riuscita.");
        }
    }
}
