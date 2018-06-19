# Progetto
Progetto di esame giugno 2018:   [Testa Damiano,Bianchini Riccardo]

Il progetto relativo la gestione di molteplici funzioni interne ad un'azienda, da noi plasmato in
un ambito pi� preciso come la Guardia di Finanza...

Le specifiche seguite per lo sviluppo del SIW sono in linea con quelle per il progetto AVANZATO per l'appello di Giugno 2018;
Le tecnologie implementate sono:
  - Spring MVC
  - Spring boot 
  - Spring Security
  - JPA(Hibernate)

Informazioni e regole di dominio:
  bla bla bla
  

Casi d'uso:

  UC1: Registrazione Centro Operativo	
  Attore Primario: Direttore Generale
    
    Scenario principale di successo:
    1. Il direttore generale accede alla pagina "Registra un nuovo Centro Operativo";
    2. Il direttore generale compila i campi relativi all'inserimento di un nuovo centro operativo;
       2.1 Se i dati relativi il nuovo centro operativo sono gi� presenti nel sistema visualizzer� "Centro Operativo gi� esistente";
       2.2 Se i dati relativi il nuovo centro operativo non sono gi� presenti nel sistema, il sistema mostrer� un riepilogo dati inseriti;
     3. Il sistema verificher� la correttezza dei dati ed aggiunger� il nuovo centro operativo.
     
  UC2: Registrazione Allievo Finanziere
  Attore Primario: Responsabile Ufficiale
    
    Scenario principale di successo:
    1. Il responsabile ufficiale accede alla pagina "Registra nuovo Allievo Finanziere";
      2. Il responsabile ufficiale compila i campi relativi all'inserimento di un nuovo allievo finanziere;
       2.1 Se i dati relativi il nuovo allievo finanziere sono gi� presenti nel sistema visualizzer� "Allievo Finanziere gi� esistente";
       2.2 Se i dati relativi il nuovo allievo finanziere non sono gi� presenti nel sistema, il sistema mostrer� un riepilogo dati inseriti;
     3. Il sistema verificher� la correttezza dei dati ed aggiunger� il nuovo allievo finanziere.
    
   UC3: Consultazione Corsi
   Attore Primario: qualsiasi visitatore del sito
   
    Scenario principale di successo:
    1. Il visitatore accede alla pagina "Corsi" -> "visualizza tutti i corsi presenti";
    2. Il sistema mostrer� due tipologie di liste relative ad i corsi presenti;
     2.1 mostrer� una lista relativa ai corsi che dovranno essere svolti ed un'altra in cui 
     saranno visibili tutti i corsi gi� svolti;
    3. saranno inoltre messe a disposizione dal sistema diverse informazioni aggiuntive oltre
    al nome del corso, la data ed il centro associato.
   
   UC4: Registrazione nuovo Corso
   Attore Primario: Responsabile Ufficiale
   
     Scenario principale di successo:
     1. Il responsabile ufficiale accede alla pagina "Registra nuovo Corso";
     2. Il responsabile ufficiale compila i campi relativi all'inserimento di un nuovo corso;
       2.1 Se i dati relativi al corso sono gi� presenti nel sistema visualizzer� "Corso gi� esistente";
       2.2 Se i dati relativi al corso non sono gi� presenti nel sistema, il sistema mostrer� un riepilogo dati inseriti;
     3. Il sistema verificher� la correttezza dei dati ed aggiunger� il corso.
     
   UC5: Consultazione Allievo Finanziere
   Attore Primario: Direttore Generale
   
     Scenario principale successo:
     1. Il direttore generale accede alla pagina "Elenco Allievi Finanzieri";
     2. Il sistema mostrer� l'elenco degli allievi finanzieri registrati;
      2.1 per ogni allievo finanziere saranno messi a disposizione in una lista ordinata dal sistema tutti i dati sensibili ed il centro a loro associato.
   UC6: Consultazione Centro Operativo
   Attore Primario: Direttore Generale
   
     Scenario principale successo:
     1. Il direttore generale accede alla pagina "Visualizza l'elenco Centri Operativi";
     2. Il sistema mostrer� l'elenco dei centri operativi, su ciascuno dei quali sar� possibile cliccare per visualizzare la relativa scheda tecnica;
       2.1 Il sistema mostrer� tutti i corsi relativi al centro operativo ed altri dati;
     3. in fondo al riepilogo dei dati � presente un bottone "Elimina Centro Operativo" dal quale sar� possibile sviluppare un ulteriore caso d'uso relativo la cancellazione del centro operativo preso in esame.

   UC7: Consultazione Informazioni Responsabile Ufficiale
   Attore Primario: Responsabile Ufficiale
   
     Scenario principale successo:
     1. Il responsabile ufficiale accede alla pagina "Visualizza e gestisci le tue informazioni";
     2. Il sistema mostrer� due tipologie di liste relative ad i corsi associati al centro gestito dal responsabile ufficiale;
     2.1 mostrer� una lista relativa ai corsi che dovranno essere svolti ed un'altra in cui 
     saranno visibili tutti i corsi gi� svolti;
    3. saranno inoltre messe a disposizione dal sistema diverse informazioni aggiuntive come
    il nome del corso e la data;
    4. al fianco dei corsi in programma � presente un bottone "iscriviti" dalla quale sar� possibile sviluppare un ulteriore caso d'uso relativo l'iscrizione di un allievo, registrato al centro gestito dal responsabile ufficiale, al corso in programma(NON IMPLEMENTATO).
      