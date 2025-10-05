package ereditarieta.poliflix.utenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerUtenti {
    private List<Utente> utenti = new ArrayList<>();
    private Utente utenteLoggato;

    public ManagerUtenti(List<Utente> utenti) {
        this.utenti = utenti;
        this.utenteLoggato = new Utente(null, null);
    }

    public Utente getUtenteLoggato() {
        return utenteLoggato;
    }

    public void setUtenteLoggato(Utente utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }

    public void registraUtente() {
        Scanner scanner = new Scanner(System.in);

        Utente new_utente = new Utente(null, null);

        System.out.println("Inserisci username: ");
        new_utente.setUsername(scanner.nextLine());
        System.out.println("Inserisci password: ");
        new_utente.setPassword(scanner.nextLine());

        this.utenti.add(new_utente);
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        Utente tentativo_login = new Utente(null, null);

        System.out.println("Inserisci username: ");
        tentativo_login.setUsername(scanner.nextLine());
        System.out.println("Inserisci password: ");
        tentativo_login.setPassword(scanner.nextLine());

        for (Utente u : this.utenti)
            if (u.equals(tentativo_login)) {
                System.out.println("Login effettuato con successo!");
                this.utenteLoggato = u;
                return;
            }

        System.out.println("Username o password errati.");
        this.utenteLoggato = new Utente(null, null);
    }

}
