package design_patterns.poliflix.contenuti;

public interface Riproducibile {
    void riproduci() throws InterruptedException;

    String getPlayMessage();
}
