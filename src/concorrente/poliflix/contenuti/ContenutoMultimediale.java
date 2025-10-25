package concorrente.poliflix.contenuti;

import concorrente.poliflix.contenuti.decorator.Riproducibile;
import concorrente.poliflix.contenuti.monitor.MonitorRiproduzione;
import concorrente.poliflix.utils.Condivisibile;
import concorrente.poliflix.utils.Logger;

public abstract class ContenutoMultimediale extends Riproducibile implements Condivisibile, Logger {
    protected String titolo;
    protected int durata;

    public ContenutoMultimediale(String titolo) {
        super(new MonitorRiproduzione());
        this.titolo = titolo;
        this.durata = 0;
    }

    public ContenutoMultimediale(String titolo, int durata) {
        super(new MonitorRiproduzione());
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
