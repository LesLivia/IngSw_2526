package ereditarieta.poliflix.contenuti;

public class Episodio extends ContenutoMultimediale {
    private String titolo;
    private int durata; // minuti

    public Episodio(String titolo, int durata) {
        super(titolo, durata);
    }

}