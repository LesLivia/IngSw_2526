package funzionale.poliflix.contenuti.decorator;

import funzionale.poliflix.contenuti.Film;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;

public class ContenutoDecoratorTest {
    @Test
    public void test_decorator_contenuti() {
        Riproducibile contenuto_test = new Film("test_titolo", 1, "test_genere", new ArrayList<>());

        ConSottotitoli contenuto_decorato_1 = new ConSottotitoli(contenuto_test);
        ConDoppiaggio contenuto_decorato_2 = new ConDoppiaggio(contenuto_test);
        ConDoppiaggio contenuto_decorato_3 = new ConDoppiaggio(contenuto_decorato_1);

        try {
            contenuto_decorato_1.riproduci();
            contenuto_decorato_2.riproduci();
            contenuto_decorato_3.riproduci();
        } catch (Exception e) {
            fail("Errore durante la riproduzione del contenuto");
        }
    }
}
