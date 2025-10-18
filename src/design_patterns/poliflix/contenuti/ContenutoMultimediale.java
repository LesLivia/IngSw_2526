package design_patterns.poliflix.contenuti;

import design_patterns.poliflix.contenuti.decorator.Riproducibile;
import design_patterns.poliflix.utils.Condivisibile;
import design_patterns.poliflix.utils.Logger;

public abstract class ContenutoMultimediale implements Condivisibile, Riproducibile, Logger {
    protected String titolo;
    protected int durata;

    public ContenutoMultimediale(String titolo) {
        this.titolo = titolo;
        this.durata = 0;
    }

    public ContenutoMultimediale(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    public final String getTitolo() {
        return titolo;
    }

    public final void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public final int getDurata() {
        return durata;
    }

    public final void setDurata(int durata) {
        this.durata = durata;
    }
}
