package design_patterns.poliflix;

import design_patterns.poliflix.contenuti.ManagerContenuti;
import design_patterns.poliflix.utenti.ManagerUtenti;
import design_patterns.poliflix.utils.PoliFlixException;

import java.util.Scanner;

public class PoliFlix {
    private static final String loggerName = "[PoliFlix]";

    public static void main(String[] args) {
        boolean running = true;

        try {
            ManagerUtenti managerUtenti = ManagerUtenti.getInstance();
            ManagerContenuti managerContenuti = ManagerContenuti.getInstance();

            System.out.println("--------------------------");
            System.out.println("Poliflix");
            System.out.println("--------------------------");

            while (running) {
                if (managerUtenti.utenteLoggato()) {
                    managerUtenti.benvenutoUtente();

                    System.out.println(loggerName + " Seleziona un'opzione:");
                    System.out.println("1. Elenco Contenuti Disponibili");
                    System.out.println("2. Riproduci Contenuto");
                    System.out.println("3. Sottoscriviti a un Contenuto");
                    System.out.println("4. Cambia modalità di raccomandazione");
                    System.out.println("5. Logout");
                    System.out.println("6. Esci");

                    Scanner scanner = new Scanner(System.in);
                    int scelta = -1;
                    try {
                        scelta = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Scelta non valida!");
                    }

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
                            managerContenuti.sottoscrivi(managerUtenti.getUtenteLoggato());
                            break;
                        case 4:
                            managerContenuti.cambiaStrategiaRaccomandazione();
                            break;
                        case 5:
                            managerUtenti.logout();
                            break;
                        case 6:
                            running = false;
                            break;
                        default:
                            break;
                    }

                } else {
                    System.out.println(loggerName + " Seleziona un'opzione:");
                    System.out.println("1. Registra nuovo utente");
                    System.out.println("2. Login");
                    System.out.println("3. Esci");

                    Scanner scanner = new Scanner(System.in);
                    int scelta = -1;
                    try {
                        scelta = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Scelta non valida!");
                    }

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

                managerContenuti.aggiornaContenuti();
            }
        } catch (PoliFlixException e) {
            e.printMessage();
        }

        System.out.println("--------------------------");
        System.out.println("Goodbye!");
        System.out.println("--------------------------");

    }
}
