package design_patterns.poliflix.contenuti.strategy;

import  design_patterns.poliflix.contenuti.ContenutoMultimediale;

import java.util.ArrayList;
import java.util.List;

public class RaccomandazionePerTitolo implements StrategiaRaccomandazione {
    @Override
    public List<ContenutoMultimediale> raccomanda(ContenutoMultimediale riferimento, List<ContenutoMultimediale> contenuti) {
        List<ContenutoMultimediale> results = new ArrayList<>();
        for (ContenutoMultimediale c : contenuti) {
            if (c.getTitolo().charAt(0) == riferimento.getTitolo().charAt(0) &&
                    !c.getTitolo().equals(riferimento.getTitolo()))
                results.add(c);
        }
        return results;
    }
}
