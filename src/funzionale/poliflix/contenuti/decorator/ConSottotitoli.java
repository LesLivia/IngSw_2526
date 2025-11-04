package funzionale.poliflix.contenuti.decorator;

public class ConSottotitoli extends ContenutoDecorator {
    public ConSottotitoli(Riproducibile contenuto) {
        super(contenuto);
    }

    public void riproduci() {
        log("[Sottotitoli]", "Sottotitoli attivati.");
        contenuto.riproduci();
    }

    public String getPlayMessage() {
        return contenuto.getPlayMessage();
    }
}
