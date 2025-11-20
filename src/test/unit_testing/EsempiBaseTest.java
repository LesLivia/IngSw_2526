package unit_testing;

import org.junit.Assert;
import org.junit.Test;

public class EsempiBaseTest {

    @Test
    public void test_max() {
        int res = EsempiBase.max(1, 2, 3);
        Assert.assertEquals(3, res);
        res = EsempiBase.max(1, 3, 2);
        Assert.assertEquals(3, res);
        res = EsempiBase.max(2, 1, 3);
        Assert.assertEquals(3, res); // fallisce (logica di confronto errata)
    }

    @Test
    public void test_compare() {
        Assert.assertEquals(-1, EsempiBase.compare(1, 2));
        Assert.assertEquals(1, EsempiBase.compare(2, 1));
        Assert.assertEquals(0, EsempiBase.compare(1, 1));
    }

    @Test
    public void test_sum_positives() {
        Assert.assertEquals(6, EsempiBase.sum_positives(new int[]{1, 2, 3}, 3));

        Assert.assertEquals(6, EsempiBase.sum_positives(new int[]{2, 1, 3}, 3));

        Assert.assertEquals(3, EsempiBase.sum_positives(new int[]{1, 2, 3}, 2));

        Assert.assertEquals(4, EsempiBase.sum_positives(new int[]{1, -2, 3}, 3));
    }

    @Test
    public void test_sum_positives_2() {
        Assert.assertEquals(6, EsempiBase.sum_positives_2(new int[]{1, 2, 3}, 3, 4));

        Assert.assertEquals(6, EsempiBase.sum_positives_2(new int[]{2, 1, 3}, 3, 4));

        Assert.assertEquals(3, EsempiBase.sum_positives_2(new int[]{1, 2, 3}, 3, 3));

        Assert.assertEquals(3, EsempiBase.sum_positives_2(new int[]{2, 1, 3}, 3, 3));

        Assert.assertEquals(3, EsempiBase.sum_positives_2(new int[]{1, 2, 3}, 2, 4));

        Assert.assertEquals(4, EsempiBase.sum_positives_2(new int[]{1, -2, 3}, 3, 4));
    }

    @Test
    public void test_max_square() {
        Assert.assertThrows(RuntimeException.class, () -> EsempiBase.max_square(new int[]{}));

        Assert.assertEquals(9, EsempiBase.max_square(new int[]{1, 2, 3}));
        Assert.assertEquals(9, EsempiBase.max_square(new int[]{1, 3, 2}));
    }

}
