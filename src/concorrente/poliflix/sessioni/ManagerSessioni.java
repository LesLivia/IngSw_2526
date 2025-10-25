package concorrente.poliflix.sessioni;

public final class ManagerSessioni {
    private static ManagerSessioni instance;
    private Sessione sessioneAttiva;

    private ManagerSessioni() {
        this.sessioneAttiva = null;
    }

    public static synchronized ManagerSessioni getInstance() {
        if (instance == null) {
            instance = new ManagerSessioni();
        }
        return instance;
    }

    public void creaSessione() {
        this.sessioneAttiva = new Sessione();
    }

    public void eseguiSessione() {
        this.sessioneAttiva.eseguiSessione();
    }
}
