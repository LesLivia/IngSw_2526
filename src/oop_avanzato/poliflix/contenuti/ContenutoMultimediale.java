package oop_avanzato.poliflix.contenuti;

public abstract class ContenutoMultimediale {
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

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public abstract String getPlayMessage();

    public abstract void riproduci() throws InterruptedException;
}
