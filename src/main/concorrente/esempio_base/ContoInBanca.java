package concorrente.esempio_base;

public class ContoInBanca {
    private int saldo;

    public ContoInBanca(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public synchronized void deposita(int quantita) {
        this.saldo += quantita;
    }

    public synchronized void preleva(int quantita) {
        this.saldo -= quantita;
    }
}
