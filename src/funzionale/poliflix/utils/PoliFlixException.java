package funzionale.poliflix.utils;

public class PoliFlixException extends Exception {
    public PoliFlixException(String message) {
        super(message);
    }

    public void printMessage() {
        System.out.println(this.getMessage());
    }
}
