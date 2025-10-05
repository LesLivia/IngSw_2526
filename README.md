Questo repository raccoglie gli esempi mostrati a lezione. 
Di seguito, la descrizione, package per package, degli argomenti trattati:

1) Package: warm_up
- Obiettivo: ripassare le basi di Java e dell’I/O da console, strutture dati semplici e un primo mini‑esempio “PoliFlix”.
- File principali:
  - [warm_up.Step1](src/warm_up/Step1.java) 
    - Stampa su console
    - Tipi primitivi (int, double, boolean)
    - Stringhe e lettura input con Scanner
    - Ciclo while e condizione di uscita (comando "esci")
  - [warm_up.Step2](src/warm_up/Step2.java) 
    - Array e for “compatto” 
    - Liste 
  - [warm_up.Step3_PoliFlix](src/warm_up/Step3_PoliFlix.java) 
    - Mini applicazione testuale: registrazione e login utenti
    - Uso di liste parallele (username/password)
    - Menu a scelta con Scanner e gestione di uno “stato utente loggato”

2) Package: basi_oop
- Obiettivo: introdurre le basi della programmazione a oggetti (incapsulamento, oggetti e manager), lettura da file e una piccola app di esempio “PoliFlix”.

  2.1) Sottopacchetto: basi_oop.poliflix
  - File principali:
    - [basi_oop.poliflix.App](src/basi_oop/poliflix/App.java) (main)
      - Entry point dell’applicazione
      - Menu contestuale (non loggato/loggato)
      - Composizione con ManagerUtenti e ManagerSerie
    - [basi_oop.poliflix.serie.Utente](src/basi_oop/poliflix/utenti/Utente.java), [basi_oop.poliflix.serie.Serie](src/basi_oop/poliflix/serie/Serie.java), [basi_oop.poliflix.serie.Episodio](src/basi_oop/poliflix/serie/Episodio.java)  (modello dominio)
  - Risorse d’esempio:
    - [resources/series.csv](resources/series.csv) (file CSV letto da Serie.leggiSerieDaCsv)

  2.2) Sottopacchetto: basi_oop.file
  - File principali:
    - [basi_oop.file.TestFile](src/basi_oop/file/TestFile.java) (main)
      - Scrittura su file con PrintWriter
      - Lettura con tre approcci: BufferedReader, Scanner, Files.readAllLines
