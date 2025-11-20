package funzionale.poliflix.contenuti.monitor;

import java.util.Scanner;

public class InputRiproduzione extends Thread {
    private final MonitorRiproduzione monitor;

    public InputRiproduzione(MonitorRiproduzione monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("p"))
                this.monitor.pausa();
            else if (input.equalsIgnoreCase("r"))
                this.monitor.riprendi();
            else if (input.equalsIgnoreCase("q"))
                break;
        }
    }
}
