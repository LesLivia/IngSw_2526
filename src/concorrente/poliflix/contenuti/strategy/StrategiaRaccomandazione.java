package concorrente.poliflix.contenuti.strategy;

import concorrente.poliflix.contenuti.ContenutoMultimediale;

import java.util.List;

public interface StrategiaRaccomandazione {
    List<ContenutoMultimediale> raccomanda(ContenutoMultimediale riferimento, List<ContenutoMultimediale> contenuti);
}
