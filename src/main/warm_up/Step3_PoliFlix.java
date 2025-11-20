package warm_up;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Step3_PoliFlix {
    static void registraUtente(List<String> utenti_username, List<String> utenti_password) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci username: ");
        utenti_username.add(scanner.nextLine());
        System.out.println("Inserisci password: ");
        utenti_password.add(scanner.nextLine());
    }

    static List<String> login(List<String> utenti_username, List<String> utenti_password) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci username: ");
        String username_inserito = scanner.nextLine();
        System.out.println("Inserisci password: ");
        String password_inserita = scanner.nextLine();

        boolean login_effettuato = false;

        for (int i = 0; i < utenti_username.size() && !login_effettuato; i++)
            if (utenti_username.get(i).equals(username_inserito) &&
                    utenti_password.get(i).equals(password_inserita)) {
                System.out.println("Login effettuato con successo!");
                login_effettuato = true;
            }

        if (!login_effettuato) {
            System.out.println("Username o password errati.");
            return new ArrayList<>();
        }

        List<String> utente_loggato = new ArrayList<>();
        utente_loggato.add(username_inserito);
        utente_loggato.add(password_inserita);

        return utente_loggato;
    }

    public static void main(String[] args) {
        boolean running = true;

        List<String> utenti_username = new ArrayList<>();
        List<String> utenti_password = new ArrayList<>();

        List<String> utente_loggato = new ArrayList<>();

        System.out.println("--------------------------");
        System.out.println("Poliflix Warmup");
        System.out.println("--------------------------");

        while (running) {
            if (!utente_loggato.isEmpty())
                System.out.println("\n\nBentornato " + utente_loggato.getFirst() + "!");

            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Registra nuovo utente");
            System.out.println("2. Effettua il login");
            System.out.println("3. Esci");

            Scanner scanner = new Scanner(System.in);
            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    registraUtente(utenti_username, utenti_password);

                    System.out.println("Registrato utente " + utenti_username.getLast() + " con successo!");

                    break;
                case 2:
                    utente_loggato = login(utenti_username, utenti_password);

                    break;
                case 3:
                    running = false;
                    break;
                default:
            }

        }

        System.out.println("--------------------------");
        System.out.println("Goodbye!");
        System.out.println("--------------------------");

    }
}
