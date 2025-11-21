package unit_testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EsempiBaseTest {

    @Test
    public void test_max() {
        int res = EsempiBase.max(1, 2, 3);
        assertEquals(3, res);
        res = EsempiBase.max(1, 3, 2);
        assertEquals(3, res);
        res = EsempiBase.max(2, 1, 3);
        assertEquals(3, res); // fallisce (logica di confronto errata)
    }

    @Test
    public void test_compare() {
        assertEquals(-1, EsempiBase.compare(1, 2));
        assertEquals(1, EsempiBase.compare(2, 1));
        assertEquals(0, EsempiBase.compare(1, 1));
    }

    @Test
    public void test_sum_positives() {
        assertEquals(6, EsempiBase.sum_positives(new int[]{1, 2, 3}, 3));

        assertEquals(6, EsempiBase.sum_positives(new int[]{2, 1, 3}, 3));

        assertEquals(3, EsempiBase.sum_positives(new int[]{1, 2, 3}, 2));

        assertEquals(4, EsempiBase.sum_positives(new int[]{1, -2, 3}, 3));
    }

    @Test
    public void test_sum_positives_2() {
        assertEquals(6, EsempiBase.sum_positives_2(new int[]{1, 2, 3}, 3, 4));

        assertEquals(6, EsempiBase.sum_positives_2(new int[]{2, 1, 3}, 3, 4));

        assertEquals(3, EsempiBase.sum_positives_2(new int[]{1, 2, 3}, 3, 3));

        assertEquals(3, EsempiBase.sum_positives_2(new int[]{2, 1, 3}, 3, 3));

        assertEquals(3, EsempiBase.sum_positives_2(new int[]{1, 2, 3}, 2, 4));

        assertEquals(4, EsempiBase.sum_positives_2(new int[]{1, -2, 3}, 3, 4));
    }

    @Test
    public void test_max_square() {
        assertThrows(RuntimeException.class, () -> EsempiBase.max_square(new int[]{}));

        assertEquals(9, EsempiBase.max_square(new int[]{1, 2, 3}));
        assertEquals(9, EsempiBase.max_square(new int[]{1, 3, 2}));
    }

}
