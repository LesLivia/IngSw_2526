package funzionale.poliflix.contenuti.decorator;

public class ConDoppiaggio extends ContenutoDecorator {
    public ConDoppiaggio(Riproducibile contenuto) {
        super(contenuto);
    }

    public void riproduci() {
        log("[Doppiaggio]", "Doppiaggio attivato.");
        contenuto.riproduci();
    }

    public String getPlayMessage() {
        return contenuto.getPlayMessage();
    }
}
