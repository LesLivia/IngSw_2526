package design_patterns.poliflix.contenuti.observer;

import  design_patterns.poliflix.utenti.observer.Osservatore;

public interface Osservabile {
    void aggiungiOsservatore(Osservatore o);

    void notifica(String msg);
}
