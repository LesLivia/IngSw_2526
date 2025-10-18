package design_patterns.poliflix.contenuti.strategy;

import design_patterns.poliflix.contenuti.ContenutoMultimediale;

import java.util.List;

public interface StrategiaRaccomandazione {
    List<ContenutoMultimediale> raccomanda(ContenutoMultimediale riferimento, List<ContenutoMultimediale> contenuti);
}
