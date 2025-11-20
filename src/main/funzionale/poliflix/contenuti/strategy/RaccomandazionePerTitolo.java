package funzionale.poliflix.contenuti.strategy;

import  funzionale.poliflix.contenuti.ContenutoMultimediale;

import java.util.List;

public class RaccomandazionePerTitolo implements StrategiaRaccomandazione {
    @Override
    public List<ContenutoMultimediale> raccomanda(ContenutoMultimediale riferimento, List<ContenutoMultimediale> contenuti) {
        return contenuti.stream()
                .filter(c -> !c.getTitolo().equalsIgnoreCase(riferimento.getTitolo()))
                .filter(c -> c.getTitolo().charAt(0) == riferimento.getTitolo().charAt(0))
                .limit(5)
                .toList();
    }
}
