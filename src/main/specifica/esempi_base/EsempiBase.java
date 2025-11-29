package specifica.esempi_base;

public class EsempiBase {
    //@ requires a != null;
    //@ requires 0 <= index < a.length;
    //@ ensures \result == a[index];
    public int getElement(int[] a, int index) {
        return a[index];
    }

    //@ requires x > 0;
    //@ ensures \result == Math.sqrt(x);
    public double radice(int x) {
        return Math.sqrt(x);
    }

    //@ requires a != null;
    //@ requires \forall int i; 0 <= i < a.length; a[i] >= 0;
    //@ requires 0 <= index < a.length;
    //@ ensures \result >= 0;
    //@ ensures \result == a[index];
    public int getPositiveElement(int[] a, int index) {
        return a[index];
    }

    //@ requires x < Integer.MAX_VALUE;
    //@ ensures \result == x + 1;
    public int incrementa(int x) {
        return x + 1;
    }

    //@ ensures (i >= j && i >= k) <==> (\result == i);
    //@ ensures (j >= i && j >= k) <==> (\result == j);
    //@ ensures (k >= i && k >= j) <==> (\result == k);
    public static int max(int i, int j, int k) {
        if (i > j && i > k) return i;
        else {
            if (j >= i && j > k) return j;
            else return k;
        }
    }

    //@ requires a != null;
    //@ requires 0 <= i < a.length && 0 <= j < a.length;
    //@ requires a[0] < Integer.MAX_VALUE - 1;
    //@ assignable a[i], a[j];
    //@ ensures a[i] == \old(a[j]) && a[j] == \old(a[i]);
    //@ ensures (\forall int k; 0 <= k < a.length && k != i && k != j; a[k] == \old(a[k]));
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        // if (i > 0 && j > 0) a[0] = a[0] + 1;
        a[i] = a[j];
        a[j] = temp;
    }

    //@ requires a != null;
    //@ requires 0 <= index < a.length;
    //@ assignable a[index];
    //@ ensures (val > 0) ==> (a[index] == val);
    //@ ensures (val <= 0) ==> (a[index] == \old(a[index]));
    //@ ensures (\forall int k; 0 <= k < a.length && k != index; a[k] == \old(a[k]));
    public void aggiornaSePositivo(int[] a, int index, int val) {
        if (val > 0) a[index] = val;
    }

    //@ requires a != null && a.length == 3;
    //@ ensures \result <==> (\forall int k; 0 <= k < 2; a[k] <= a[k+1]);
    public boolean triplaOrdinata(int[] a) {
        return a[0] <= a[1] && a[1] <= a[2];
    }

    //@ requires s1 != null && s2 != null;
    //@ requires s1.length() > 0 && s2.length() > 0;
    //@ ensures \result <==> (s1.charAt(0) == s2.charAt(0));
    public boolean stessaIniziale(String s1, String s2) {
        return s1.charAt(0) == s2.charAt(0);
    }

    //@ requires b != 0;
    //@ requires a < Integer.MAX_VALUE && a > - Integer.MAX_VALUE;
    //@ requires b < Integer.MAX_VALUE && b > - Integer.MAX_VALUE;
    //@ ensures \result == a / b;
    //@ signals (ArithmeticException e) b == 0;
    public int dividi(int a, int b) {
        //@ show a, b;
        return a / b;
    }

    //@ requires a != null;
    //@ ensures a[index] == val;
    //@ signals (IndexOutOfBoundsException e) index < 0 || index >= a.length;
    //@ signals (IllegalArgumentException e) (index >= 0 && index < a.length) && val < 0;
    public void setElementoPositivo(int[] a, int index, int val) {
        if (index < 0 || index >= a.length) throw new IndexOutOfBoundsException();
        if (val < 0) throw new IllegalArgumentException();
        a[index] = val;
    }

    //@ requires arr != null && arr.length >= 3;
    //@ requires Math.abs(arr[0] + arr[1] + arr[2]) < Integer.MAX_VALUE;
    //@ ensures \result == (arr[0] + arr[1] + arr[2]);
    //@ signals (IllegalArgumentException e) (\exists int i; 0 <= i < 3; arr[i] < 0);
    public int sommaTriplaPositiva(int[] arr) {
        if (arr[0] < 0 || arr[1] < 0 || arr[2] < 0) throw new IllegalArgumentException();
        return arr[0] + arr[1] + arr[2];
    }

    //@ requires a != null;
    //@ ensures \forall int i; 0 <= i < a.length; a[i] <= \result;
    public int maxArray(int[] a) {
        int max = 0;
	    /*@ maintaining 0 <= i && i <= a.length;
	    @ maintaining \forall int k; 0 <= k < i; a[k] <= max;
        @ loop_writes max;
  	    @ decreasing a.length - i;
  	    @*/
        for (int i = 0; i < a.length; i++)
            if (a[i] >= max) max = a[i];
        return max;
    }

    //@ requires a != null;
    //@ requires a.length <= Integer.MAX_VALUE;
    //@ ensures \result <==> (\exists int i; i>=0 && i<a.length; a[i]==num);
    //@ signals (IllegalArgumentException e) (a==null);
    public static boolean contains(int[] a, int num)
            throws IllegalArgumentException {
        if (a == null) throw new IllegalArgumentException("array cannot be null");
        int i;
        //@ maintaining 0 <= i <= a.length;
        //@ maintaining i <= Integer.MAX_VALUE;
        //@ maintaining \forall int k; 0 <= k < i; a[k] != num;
        //@ loop_writes \nothing;
        //@ decreases a.length - i;
        for (i = 0; i < a.length && i <= Integer.MAX_VALUE; i++)
            if (a[i] == num)
                return true;
        return false;
    }

    //@ requires a != null;
    //@ ensures 0 <= \result <= a.length;
    //@ ensures a[\result] == x;
    //@ signals (NullPointerException e) (\forall int i; i>=0 && i<a.length; a[i]!=x);
    public static int search(int[] a, int x)
            throws NullPointerException {
        int i = 0;
        //@ maintaining 0 <= i <= a.length;
        //@ maintaining \forall int k; 0 <= k < i; a[k]!=x;
        //@ loop_writes \nothing;
        //@ decreases a.length - i;
        for (i = 0; i < a.length; i++)
            if (a[i] == x)
                return i;
        throw new NullPointerException("element not found");
    }
}
