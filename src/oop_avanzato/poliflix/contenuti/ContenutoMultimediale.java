package oop_avanzato.poliflix.contenuti;

import oop_avanzato.poliflix.utils.Condivisibile;

public abstract class ContenutoMultimediale implements Condivisibile {
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

    public abstract String getPlayMessage();

    public abstract void riproduci() throws InterruptedException;
}
