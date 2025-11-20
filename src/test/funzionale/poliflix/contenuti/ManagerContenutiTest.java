package funzionale.poliflix.contenuti;

import funzionale.poliflix.contenuti.factory.ContenutiFactory;
import funzionale.poliflix.utils.PoliFlixException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ManagerContenutiTest {
    ManagerContenuti mc;

    @Before
    public void setUp() {
        mc = ManagerContenuti.getInstance();
        try {
            List<ContenutoMultimediale> contenuti = ContenutiFactory.leggiDaCsv("./test_resources/files/test_contenuti.csv");
            mc.setContenuti(contenuti);
        } catch (PoliFlixException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getContenuti_test() {
        Assert.assertTrue(mc.getContenuti().size() == 3);
    }

    @Test
    public void riproduci_test() {
        try {
            // Problema! I test sono "view-only",
            // gli step che richiedono interazione con l'utente andrebbero
            // messi tutti a fattor comune in una classe (o un package)
            // che è l'unico a non essere oggetto di test.
            // mc.riproduci("inception");
            mc.riproduci("test");
        } catch (PoliFlixException e) {
            throw new RuntimeException(e);
        }
    }

}
