package concorrente.poliflix.contenuti.strategy;

import concorrente.poliflix.contenuti.ContenutoMultimediale;

import java.util.ArrayList;
import java.util.List;

public class RaccomandazionePerDurata implements StrategiaRaccomandazione {
    @Override
    public List<ContenutoMultimediale> raccomanda(ContenutoMultimediale riferimento, List<ContenutoMultimediale> contenuti) {
        List<ContenutoMultimediale> results = new ArrayList<>();
        for (ContenutoMultimediale c : contenuti) {
            if (c.getDurata() == riferimento.getDurata() &&
                    !c.getTitolo().equals(riferimento.getTitolo()))
                results.add(c);
        }
        return results;
    }
}