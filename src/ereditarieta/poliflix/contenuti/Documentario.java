package ereditarieta.poliflix.contenuti;

public class Documentario extends ContenutoMultimediale {
    private String tema;
    private String regista;

    public Documentario(String titolo, int durata, String tema, String regista) {
        super(titolo, durata);
        this.tema = tema;
        this.regista = regista;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public static Documentario parsaRiga(String riga) {
        String rigaPulita = riga.trim();
        String[] campi = rigaPulita.split(";");

        return new Documentario(campi[1], Integer.parseInt(campi[2]), campi[3], campi[4]);
    }

}
