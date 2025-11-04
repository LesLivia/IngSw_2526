package funzionale.poliflix.utenti;

import funzionale.poliflix.utils.Logger;
import funzionale.poliflix.utils.PoliFlixException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class ManagerUtenti implements Logger {
    private static ManagerUtenti instance;
    private List<Utente> utenti;

    private final static String loggerName = "[ManagerUtenti]";

    private ManagerUtenti() {
        try {
            FileInputStream fis = new FileInputStream("./resources/files/users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.utenti = (List<Utente>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            this.utenti = new ArrayList<>();
        }
    }

    public static ManagerUtenti getInstance() {
        if (instance == null)
            instance = new ManagerUtenti();
        return instance;
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

    public void salvaUtentiSuFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("./resources/files/users.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this.utenti);
        oos.close();
        fos.close();
    }

    public boolean utenteEsiste(Utente tentativoLogin) {
        return this.utenti.stream()
                .filter(u -> u.equals(tentativoLogin))
                .findFirst()
                .isPresent();
    }
}
