package oop_avanzato.poliflix.utenti;

import oop_avanzato.poliflix.utils.Logger;
import oop_avanzato.poliflix.utils.PoliFlixException;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ManagerUtenti implements Logger {
    private List<Utente> utenti;
    private Utente utenteLoggato;

    private final static String loggerName = "[ManagerUtenti]";

    public ManagerUtenti() throws PoliFlixException {
        try {
            FileInputStream fis = new FileInputStream("./resources/files/users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.utenti = (List<Utente>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new PoliFlixException("Errore nella deserializzazione degli utenti.");
        }

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

    public void registraUtente() throws PoliFlixException {
        Scanner scanner = new Scanner(System.in);

        Utente new_utente = new Utente(null, null);

        log(loggerName, "Inserisci username:");
        new_utente.setUsername(scanner.nextLine());
        log(loggerName, "Inserisci password:");
        new_utente.setPassword(scanner.nextLine());

        this.utenti.add(new_utente);
        try {
            this.salvaUtentiSuFile();
        } catch (IOException e) {
            throw new PoliFlixException("Errore nella serializzazione degli utenti.");
        }

        log(loggerName, " Registrato utente " +
                this.utenti.getLast().getUsername() +
                " con successo!");
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        Utente tentativo_login = new Utente(null, null);

        log(loggerName, "Inserisci username:");
        tentativo_login.setUsername(scanner.nextLine());
        log(loggerName, "Inserisci password:");
        tentativo_login.setPassword(scanner.nextLine());

        for (Utente u : this.utenti)
            if (u.equals(tentativo_login)) {
                log(loggerName, "Login effettuato con successo!");
                this.utenteLoggato = u;
                return;
            }

        log(loggerName, "Username o password errati.");
        this.utenteLoggato = new Utente(null, null);
    }

    public boolean utenteLoggato() {
        return this.utenteLoggato.exists();
    }

    public void benvenutoUtente() {
        log(loggerName, "Bentornato " + this.utenteLoggato.getUsername() + "!");
    }

    public void salvaUtentiSuFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("./resources/files/users.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this.utenti);
        oos.close();
        fos.close();
    }

}
