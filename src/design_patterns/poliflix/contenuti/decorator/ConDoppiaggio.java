package design_patterns.poliflix.contenuti.decorator;

public class ConDoppiaggio extends ContenutoDecorator {
    public ConDoppiaggio(Riproducibile contenuto) {
        super(contenuto);
    }

    public void riproduci() throws InterruptedException {
        log("[Doppiaggio]", "Doppiaggio attivato.");
        contenuto.riproduci();
    }

    @Override
    public String getPlayMessage() {
        return contenuto.getPlayMessage();
    }
}
