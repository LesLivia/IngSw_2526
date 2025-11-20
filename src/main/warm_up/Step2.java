package warm_up;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Step2 {
    public static void main(String[] args) {
        // ARRAY
        int[] numeri = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // for compatto
        for (int n : numeri)
            System.out.println(n);
        // LISTE
        List<Integer> listaNumeri = new ArrayList<>();
        String scelta = "";
        Scanner scanner = new Scanner(System.in);
        while (!scelta.equals("-1")) {
            System.out.println("Inserisci un numero: ");
            scelta = scanner.nextLine();
            listaNumeri.add(Integer.parseInt(scelta));
            for (int n : listaNumeri)
                System.out.println(n);
        }
    }
}
