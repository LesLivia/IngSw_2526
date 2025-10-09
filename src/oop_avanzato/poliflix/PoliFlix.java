package oop_avanzato.poliflix;

import oop_avanzato.poliflix.contenuti.ManagerContenuti;
import oop_avanzato.poliflix.contenuti.ReaderContenuti;
import oop_avanzato.poliflix.utenti.ManagerUtenti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PoliFlix {
    private static final String loggerName = "[PoliFlix]";

    public static void main(String[] args) throws IOException, InterruptedException {
        boolean running = true;

        ManagerUtenti managerUtenti = new ManagerUtenti(new ArrayList<>());
        ManagerContenuti managerContenuti = new ManagerContenuti(ReaderContenuti.leggiDaCsv("./resources/files/contenuti.csv"));

        System.out.println("--------------------------");
        System.out.println("Poliflix");
        System.out.println("--------------------------");

        while (running) {
            if (managerUtenti.utenteLoggato()) {
                managerUtenti.benvenutoUtente();

                System.out.println(loggerName + " Seleziona un'opzione:");
                System.out.println("1. Elenco Contenuti Disponibili");
                System.out.println("2. Riproduci Contenuto");
                System.out.println("3. Esci");

                Scanner scanner = new Scanner(System.in);
                int scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1:
                        managerContenuti.stampaInformazioni();
                        break;
                    case 2:
                        System.out.println("Inserisci il titolo: ");
                        String nomeSerie = scanner.nextLine();

                        managerContenuti.riproduci(nomeSerie);
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        break;
                }

            } else {
                System.out.println(loggerName + " Seleziona un'opzione:");
                System.out.println("1. Registra nuovo utente");
                System.out.println("2. Effettua il login");
                System.out.println("3. Esci");

                Scanner scanner = new Scanner(System.in);
                int scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1:
                        managerUtenti.registraUtente();
                        break;
                    case 2:
                        managerUtenti.login();
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
