package concorrente.esempio_base;

public class MainContoInBanca {
    public static void main(String[] args) {
        ContoInBanca conto = new ContoInBanca(1000);
        ThreadDeposita t1 = new ThreadDeposita(conto);
        ThreadPreleva t2 = new ThreadPreleva(conto);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(conto.getSaldo());
    }
}
