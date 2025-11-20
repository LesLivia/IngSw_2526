package concorrente.poliflix.sessioni;

import  concorrente.poliflix.contenuti.ManagerContenuti;
import  concorrente.poliflix.utenti.ManagerUtenti;
import  concorrente.poliflix.utenti.Utente;
import  concorrente.poliflix.utils.Logger;
import  concorrente.poliflix.utils.PoliFlixException;

import java.util.Scanner;

public class Sessione implements Logger {
    private final ManagerUtenti managerUtenti;
    private final ManagerContenuti managerContenuti;
    private final String loggerName = "[Sessione]";
    private Utente utenteLoggato;

    public Sessione() {
        this.managerUtenti = ManagerUtenti.getInstance();
        this.managerContenuti = ManagerContenuti.getInstance();
        this.utenteLoggato = new Utente(null, null);
    }

    public Sessione(Utente utente) {
        this.managerUtenti = ManagerUtenti.getInstance();
        this.managerContenuti = ManagerContenuti.getInstance();
        this.utenteLoggato = utente;
    }

    private void setUtente(Utente utente) {
        this.utenteLoggato = utente;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        Utente tentativo_login = new Utente(null, null);

        log(loggerName, "Inserisci username:");
        tentativo_login.setUsername(scanner.nextLine());
        log(loggerName, "Inserisci password:");
        tentativo_login.setPassword(scanner.nextLine());

        if (managerUtenti.utenteEsiste(tentativo_login)) {
            log(loggerName, "Login effettuato con successo!");
            this.utenteLoggato = tentativo_login;
            return;
        }

        log(loggerName, "Username o password errati.");
    }

    public void benvenutoUtente() {
        log(loggerName, "Bentornato " + this.utenteLoggato.getUsername() + "!");
    }

    private void logout() {
        this.utenteLoggato = new Utente(null, null);
    }

    public void eseguiSessione() {
        boolean running = true;

        try {
            System.out.println("--------------------------");
            System.out.println("Poliflix");
            System.out.println("--------------------------");

            while (running) {

                if (utenteLoggato.exists()) {
                    this.benvenutoUtente();

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
                            managerContenuti.sottoscrivi(utenteLoggato);
                            break;
                        case 4:
                            managerContenuti.cambiaStrategiaRaccomandazione();
                            break;
                        case 5:
                            this.logout();
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
                            this.login();
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
