package concorrente.poliflix.contenuti.observer;

import  concorrente.poliflix.utenti.observer.Osservatore;

public interface Osservabile {
    void aggiungiOsservatore(Osservatore o);

    void notifica(String msg);
}
