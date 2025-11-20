package concorrente.esempio_base;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContoInBancaTest {
    ContoInBanca conto;

    @Before
    public void setUp() {
        conto = new ContoInBanca(1000);
    }

    @Test
    public void deposita_test() {
        ThreadDeposita t1 = new ThreadDeposita(conto);
        ThreadPreleva t2 = new ThreadPreleva(conto);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(1000, conto.getSaldo());
    }

}
