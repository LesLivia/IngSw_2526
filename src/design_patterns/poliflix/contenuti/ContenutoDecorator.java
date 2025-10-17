package design_patterns.poliflix.contenuti;

import design_patterns.poliflix.utils.Logger;

public abstract class ContenutoDecorator implements Riproducibile, Logger {
    protected Riproducibile contenuto;

    public ContenutoDecorator(Riproducibile contenuto) {
        this.contenuto = contenuto;
    }
}
