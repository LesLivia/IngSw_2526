package concorrente.poliflix;

import  concorrente.poliflix.sessioni.ManagerSessioni;

public class PoliFlix {
    private static final String loggerName = "[PoliFlix]";

    public static void main(String[] args) {
        ManagerSessioni managerSessioni = ManagerSessioni.getInstance();

        managerSessioni.creaSessione();
        managerSessioni.eseguiSessione();
    }
}
