package warm_up;

import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        // Stampa in console
        System.out.println("Hello and welcome!");
        // Tipi primitivi (interi, decimali, booleani)
        int x = 10;
        double y = 100.0;
        boolean continua = true;
        // Dichiarazione stringa (senza inizializzazione)
        String input_utente;
        // Dichiarazione scanner per leggere da console
        Scanner scanner = new Scanner(System.in);
        // Ciclo che continua fino a che l'utente non inserisce "esci"
        while (continua) {
            System.out.println("x = " + x);
            x -= 1;
            System.out.println("y = " + y);
            y *= 0.5;
            // Legge da console
            input_utente = scanner.nextLine();
            System.out.println("Hai inserito: " + input_utente);
            continua = !input_utente.equals("esci");
        }
    }
}
