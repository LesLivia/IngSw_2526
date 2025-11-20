package concorrente.esempio_base;

public class ThreadDeposita extends Thread {
    private ContoInBanca conto;

    public ThreadDeposita(ContoInBanca conto) {
        this.conto = conto;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.conto.deposita(100);
        }
    }

}
