package concorrente.esempio_base;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContoInBancaTest {
    static ContoInBanca conto;

    @BeforeAll
    public static void setUp() {
        conto = new ContoInBanca(1000);
    }

    @RepeatedTest(1000)
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

        assertEquals(1000, conto.getSaldo());
    }

}
