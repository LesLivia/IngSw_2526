package concorrente.poliflix.contenuti.strategy;

import  concorrente.poliflix.contenuti.ContenutoMultimediale;

import java.util.List;

public class Raccomandatore {
    private StrategiaRaccomandazione strategia;

    public Raccomandatore(StrategiaRaccomandazione strategia) {
        this.strategia = strategia;
    }

    public void setStrategia(StrategiaRaccomandazione strategia) {
        this.strategia = strategia;
    }

    public List<ContenutoMultimediale> raccomanda(ContenutoMultimediale riferimento, List<ContenutoMultimediale> contenuti) {
        return this.strategia.raccomanda(riferimento, contenuti);
    }
}
