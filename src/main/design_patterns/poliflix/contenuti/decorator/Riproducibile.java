package design_patterns.poliflix.contenuti.decorator;

public interface Riproducibile {
    void riproduci() throws InterruptedException;

    String getPlayMessage();
}
