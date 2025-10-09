Questo repository raccoglie gli esempi mostrati a lezione. 
Di seguito, la descrizione, package per package, degli argomenti trattati:

<details>
<summary><strong>1) Package: warm_up</strong></summary>

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

</details>

<details>
<summary><strong>2) Package: basi_oop</strong></summary>

- Obiettivo: introdurre le basi della programmazione a oggetti (incapsulamento, oggetti e manager), lettura da file e una piccola app di esempio “PoliFlix”.

<img src="resources/diagrams/PoliFlix_2.png" alt="Diagramma PoliFlix 2" width="400">

  2.1) Sottopacchetto: basi_oop.poliflix
  - File principali:
    - [basi_oop.poliflix.PoliFlix](src/basi_oop/poliflix/PoliFlix.java) (main)
      - Entry point dell’applicazione
      - Menu contestuale (non loggato/loggato)
      - Composizione con ManagerUtenti e ManagerSerie
    - [basi_oop.poliflix.serie.Utente](src/basi_oop/poliflix/utenti/Utente.java), [basi_oop.poliflix.serie.Serie](src/basi_oop/poliflix/serie/Serie.java), [basi_oop.poliflix.serie.Episodio](src/basi_oop/poliflix/serie/Episodio.java)  (modello dominio)
  - Cosa mostra:
      - Incapsulamento e oggetti di dominio (Utente, Serie, Episodio)
      - Manager e composizione (PoliFlix + ManagerUtenti, ManagerSerie)
      - Lettura e parsing da CSV (Serie.leggiSerieDaCsv su resources/series.csv)
  
  - Risorse d’esempio:
     - [resources/series.csv](resources/files/series.csv) (file CSV letto da Serie.leggiSerieDaCsv)

   2.2) Sottopacchetto: basi_oop.file
   - File principali:
     - [basi_oop.file.TestFile](src/basi_oop/file/TestFile.java) (main)
       - Scrittura su file con PrintWriter
       - Lettura con tre approcci: BufferedReader, Scanner, Files.readAllLines

  - Cosa mostra:
    - Incapsulamento e oggetti di dominio (Utente, Serie, Episodio)
    - Manager e composizione (PoliFlix + ManagerUtenti, ManagerSerie)
    - Lettura e parsing da CSV (Serie.leggiSerieDaCsv su resources/series.csv)
    - Menu testuale con stato utente (non loggato/loggato)
    - Collezioni e iterazione su elenchi di oggetti

</details>

<details>
<summary><strong>3) Package: ereditarieta</strong></summary>

- Obiettivo: introdurre ereditarietà e polimorfismo applicati a PoliFlix; mostrare override dei metodi, upcasting e gestione uniforme di tipi diversi tramite una superclasse comune.

<img src="resources/diagrams/PoliFlix_3.png" alt="Diagramma PoliFlix 3" width="400">

  3.1) Sottopacchetto: ereditarieta.poliflix
  - File principali:
    - [new.poliflix.PoliFlix](src/oop_avanzato/poliflix/PoliFlix.java) (main)
      - Entry point: menù non loggato/loggato, integrazione con ManagerUtenti e ManagerContenuti
    - Contenuti (gerarchia):
      - [contenuti.new.poliflix.ContenutoMultimediale](src/oop_avanzato/poliflix/contenuti/ContenutoMultimediale.java) (superclasse)
      - [contenuti.new.poliflix.Film](src/oop_avanzato/poliflix/contenuti/Film.java), [contenuti.new.poliflix.Documentario](src/oop_avanzato/poliflix/contenuti/Documentario.java), [contenuti.new.poliflix.Serie](src/oop_avanzato/poliflix/contenuti/Serie.java), [contenuti.new.poliflix.Episodio](src/oop_avanzato/poliflix/contenuti/Episodio.java)
      - [contenuti.new.poliflix.ManagerContenuti](src/oop_avanzato/poliflix/contenuti/ManagerContenuti.java)
      - [contenuti.new.poliflix.ReaderContenuti](src/oop_avanzato/poliflix/contenuti/ReaderContenuti.java)
    - Utenti:
      - [utenti.new.poliflix.ManagerUtenti](src/oop_avanzato/poliflix/utenti/ManagerUtenti.java), [utenti.new.poliflix.Utente](src/oop_avanzato/poliflix/utenti/Utente.java)
  - Cosa mostra:
    - Una gerarchia di tipi con superclasse (ContenutoMultimediale) e sottoclassi (Film, Documentario, Serie, Episodio)
    - Polimorfismo su ContenutoMultimediale.riproduci() e override dove necessario
    - Lettura da CSV unica ([ReaderContenuti.leggiDaCsv](src/oop_avanzato/poliflix/contenuti/ReaderContenuti.java)) che istanzia il sottotipo in base alla prima colonna (Film/Documentario/Serie)
  - Risorse d’esempio:
    - [resources/contenuti.csv](resources/files/contenuti.csv)
    - Diagrammi: [resources/diagrams/PoliFlix_2.png](resources/diagrams/PoliFlix_2.png), [resources/diagrams/PoliFlix_3.png](resources/diagrams/PoliFlix_3.png)

</details>
