package basi_oop.poliflix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean running = true;

        ManagerUtenti userManager = new ManagerUtenti(new ArrayList<>());
        ManagerSerie serieManager = new ManagerSerie(Serie.leggiSerieDaCsv("./resources/series.csv"));

        Utente utente_loggato = new Utente(null, null);

        System.out.println("--------------------------");
        System.out.println("Poliflix Warmup");
        System.out.println("--------------------------");

        while (running) {
            if (utente_loggato.exists()) {
                System.out.println("\n\nBentornato " + utente_loggato.getUsername() + "!");

                System.out.println("Seleziona un'opzione:");
                System.out.println("1. Elenco Serie Disponibili");
                System.out.println("2. Guarda Serie");
                System.out.println("3. Esci");

                Scanner scanner = new Scanner(System.in);
                int scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1:
                        serieManager.stampaSerie();
                        break;
                    case 2:
                        System.out.println("Inserisci il nome della serie da guardare: ");
                        String nomeSerie = scanner.nextLine();

                        serieManager.guardaSerie(nomeSerie);

                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                }

            } else {
                System.out.println("Seleziona un'opzione:");
                System.out.println("1. Registra nuovo utente");
                System.out.println("2. Effettua il login");
                System.out.println("3. Esci");

                Scanner scanner = new Scanner(System.in);
                int scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1:
                        userManager.registraUtente();
                        System.out.println("Registrato utente " +
                                userManager.getUtenti().getLast().getUsername() +
                                " con successo!");
                        break;
                    case 2:
                        utente_loggato = userManager.login();
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                }
            }
        }

        System.out.println("--------------------------");
        System.out.println("Goodbye!");
        System.out.println("--------------------------");

    }
}
