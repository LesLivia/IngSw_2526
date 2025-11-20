package funzionale.poliflix.contenuti.strategy;

import  funzionale.poliflix.contenuti.ContenutoMultimediale;

import java.util.List;

public interface StrategiaRaccomandazione {
    List<ContenutoMultimediale> raccomanda(ContenutoMultimediale riferimento, List<ContenutoMultimediale> contenuti);
}
