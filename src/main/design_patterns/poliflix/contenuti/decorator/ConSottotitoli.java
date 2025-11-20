package design_patterns.poliflix.contenuti.decorator;

public class ConSottotitoli extends ContenutoDecorator {
    public ConSottotitoli(Riproducibile contenuto) {
        super(contenuto);
    }

    public void riproduci() throws InterruptedException {
        log("[Sottotitoli]", "Sottotitoli attivati.");
        contenuto.riproduci();
    }

    @Override
    public String getPlayMessage() {
        return contenuto.getPlayMessage();
    }
}
