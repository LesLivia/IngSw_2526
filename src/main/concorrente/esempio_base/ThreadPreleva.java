package concorrente.esempio_base;

public class ThreadPreleva extends Thread {
    private ContoInBanca conto;

    public ThreadPreleva(ContoInBanca conto) {
        this.conto = conto;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.conto.preleva(100);
        }
    }

}
