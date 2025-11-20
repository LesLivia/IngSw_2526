package unit_testing;

public class EsempiBase {
    public static int max(int x, int y, int z) {
        if (x > y)
            return x;
        else if (y > z)
            return y;
        else return z;
    }

    public static int compare(int x, int y) {
        if (x > y)
            return 1;
        else if (y > x)
            return -1;
        else return 0;
    }

    public static int sum_positives(int[] a, int size) {
        int i = 0;
        int sum = 0;
        while (i < size) {
            if (a[i] > 0)
                sum += a[i];
            i++;
        }
        return sum;
    }

    public static int sum_positives_2(int[] a, int size, int x) {
        int i = 0;
        int sum = 0;
        while (i < size && a[i] < x) {
            if (a[i] > 0)
                sum += a[i];
            i++;
        }
        return sum;
    }

    public static int max_square(int[] a) {
        if (a.length < 1)
            throw new RuntimeException("Array must not be empty.");

        for (int i = 0; i < a.length; i++)
            a[i] = a[i] * a[i];

        int max = 0;
        int i = 1;
        while (i < a.length) {
            if (a[i] > a[max])
                max = i;
            i++;
        }

        if (a[max] < 0)
            return -a[max];
        return a[max];
    }

}
