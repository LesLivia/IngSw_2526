package funzionale.poliflix.contenuti.observer;

import funzionale.poliflix.utenti.observer.Osservatore;

public interface Osservabile {
    void aggiungiOsservatore(Osservatore o);

    void notifica(String msg);
}
