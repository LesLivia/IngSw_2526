package funzionale.esempio_base;

import  funzionale.poliflix.contenuti.Episodio;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EsempiInterfacceFunzionali {
    public static void main(String[] args) {
        // Esempio Runnable
        Runnable r = () -> {
            for (int i = 0; i < 10; i++)
                System.out.println(i);
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Esempio Comparator
        Episodio e1 = new Episodio("Titolo 1", 10);
        Episodio e2 = new Episodio("Titolo 2", 20);
        Comparator<Episodio> comp = (n1, n2) -> n1.equals(n2) ? 0 :
                n1.getDurata() > n2.getDurata() ? 1 : -1;

        System.out.println(comp.compare(e1, e2));
        System.out.println(comp.compare(e2, e1));
        System.out.println(comp.compare(e1, e1));

        // Esempio Predicate
        Predicate<Episodio> pred = e -> e.getDurata() > 15;
        System.out.println(pred.test(e1));
        System.out.println(pred.test(e2));

        // Esempio Function
        Function<Episodio, Episodio> f = e -> new Episodio(e.getTitolo(), e.getDurata() * 2);
        System.out.println(f.apply(e1).getDurata());
        System.out.println(f.apply(e2).getDurata());

        // Esempio Supplier
        Supplier<Episodio> s = () -> new Episodio("Nuovo Titolo", 10);
        System.out.println(s.get().getTitolo());

        // Esempio Consumer
        Consumer<Episodio> c = e -> {
            try {
                System.out.println("Riproduzione " + e.getTitolo() + " in corso... ");
                TimeUnit.SECONDS.sleep(e.getDurata());
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        };

        // consuma l'episodio generato dal supplier
        c.accept(s.get());

        OperazioneBinaria op1 = (a, b) -> a - b;
        OperazioneBinaria op2 = (a, b) -> a * b;
        OperazioneBinaria op3 = Integer::sum; // equivalente a: op3 = (a, b) -> a + b;

        System.out.println(op1.applica(10, 20));
        System.out.println(op2.applica(10, 20));
        System.out.println(op3.applica(10, 20));
    }
}
