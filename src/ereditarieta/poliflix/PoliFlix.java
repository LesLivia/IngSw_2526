package ereditarieta.poliflix;

import ereditarieta.poliflix.contenuti.ContenutoMultimediale;
import ereditarieta.poliflix.contenuti.Film;
import ereditarieta.poliflix.contenuti.ManagerContenuti;
import ereditarieta.poliflix.contenuti.ReaderContenuti;
import ereditarieta.poliflix.utenti.ManagerUtenti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoliFlix {
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean running = true;

        ManagerUtenti managerUtenti = new ManagerUtenti(new ArrayList<>());
        ManagerContenuti managerContenuti = new ManagerContenuti(ReaderContenuti.leggiDaCsv("./resources/contenuti.csv"));

        ContenutoMultimediale c1 = new Film("", 2, "Azione", List.of());
        managerContenuti.mostraAltro(c1);
        Film c2 = new Film("", 2, "Azione", List.of());
        managerContenuti.mostraAltro(c2);

        System.out.println("--------------------------");
        System.out.println("Poliflix Warmup");
        System.out.println("--------------------------");

        while (running) {
            if (managerUtenti.getUtenteLoggato().exists()) {
                System.out.println("\n\nBentornato " + managerUtenti.getUtenteLoggato().getUsername() + "!");

                System.out.println("Seleziona un'opzione:");
                System.out.println("1. Elenco Serie Disponibili");
                System.out.println("2. Guarda Serie");
                System.out.println("3. Esci");

                Scanner scanner = new Scanner(System.in);
                int scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1:
                        managerContenuti.stampaInformazioni();
                        break;
                    case 2:
                        System.out.println("Inserisci il nome della serie da guardare: ");
                        String nomeSerie = scanner.nextLine();

                        managerContenuti.riproduci(nomeSerie);

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
                        managerUtenti.registraUtente();
                        System.out.println("Registrato utente " +
                                managerUtenti.getUtenti().getLast().getUsername() +
                                " con successo!");
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
