package ereditarieta.poliflix.utenti;

public class Utente {
    private String username;
    private String password;

    public Utente(String u, String p) {
        this.username = u;
        this.password = p;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String u) {
        this.username = u;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public boolean equals(Utente other) {
        return this.getUsername().equals(other.getUsername()) && this.getPassword().equals(other.getPassword());
    }

    public boolean exists() {
        return this.getUsername() != null && this.getPassword() != null;
    }

}
