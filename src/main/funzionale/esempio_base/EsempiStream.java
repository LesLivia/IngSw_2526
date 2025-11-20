package funzionale.esempio_base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EsempiStream {
    public static void main(String[] args) {
        List<String> titoli = List.of("Breaking Bad", "The Witcher", "Dark", "Better Call Saul");

        // paradigma imperativo
        List<String> risultantiImperativo = new ArrayList<>();
        for (String titolo : titoli)
            if (titolo.length() > 4)
                risultantiImperativo.add(titolo.toUpperCase());

        Collections.sort(risultantiImperativo);

        for (String titolo : risultantiImperativo)
            System.out.println(titolo);

        // paradigma funzionale con utilizzo dello stream
        List<String> risultantiFunzionale = titoli.stream()
                .filter(s -> s.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        risultantiFunzionale.forEach(System.out::println);

        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // paradigma imperativo
        int risultatoImperativo = 0;
        for (int n : numeri)
            if (n % 2 == 0)
                risultatoImperativo += n * n;

        System.out.println(risultatoImperativo);

        // paradigma funzionale
        int risultatoFunzionale = numeri.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println(risultatoFunzionale);
    }
}
