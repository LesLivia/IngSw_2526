package funzionale.poliflix.contenuti.decorator;

import funzionale.poliflix.utils.Logger;

public abstract class ContenutoDecorator extends Riproducibile implements Logger {
    protected Riproducibile contenuto;

    public ContenutoDecorator(Riproducibile contenuto) {
        super(contenuto.getMonitor());
        this.contenuto = contenuto;
    }
}
