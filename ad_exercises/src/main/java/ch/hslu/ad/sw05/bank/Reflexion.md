# Reflexion

## A
### Was sollte beim Szenario passieren, wenn das Programm korrekt ablaufen würde?
- Ordentliche Überweisungen von Quell- zu Zielkonten und zurück.
- Konsistente Kontostände nach Abschluss der Überweisungen.

### Was beobachten Sie?
- Inkonsistenzen und falsche Beträge in den Kontoständen.

### Wie erklären Sie sich Programmverhalten?
- Mögliche Synchronisierungsprobleme zwischen Threads.
- Probleme in der Thread-Verwaltung wie Unterbrechungen oder Deadlocks.

## B
### Analysieren Sie die Bankkontoklasse und identifizieren Sie die Schwachstelle.
- Die Schwachstelle liegt wahrscheinlich in der nicht synchronisierten Überweisungsmethode transfer() -> kritischer Abschnitt
- Da die Methode nicht synchronisiert ist, können mehrere Threads gleichzeitig auf dasselbe Bankkonto zugreifen und es zu Inkonsistenzen führen

### Wie können Sie ein noch stärkeres Fehlverhalten provozieren?
- Höhere Anzahl der Threads und Bankkonten, um die Wahrscheinlichkeit von Wettlaufbedingungen zu erhöhen. 
- Grössere Beträge für Überweisungen, um das Auftreten von Inkonsistenzen zu beschleunigen. 
- Mehr Überweisungen von verschiedenen Threads gleichzeitig durchführen, um die Chance auf gleichzeitige Zugriffe zu erhöhen.

## C
### Welche Art von Synchronisation ist für die Bankkonto Klasse besser? Warum?
In diesem Fall wäre Instanz synchronisation die bessere Wahl, da es wahrscheinlich ist, dass verschiedene Threads auf verschiedene Instanzen der BankAccount-Klasse zugreifen, um Überweisungen zwischen verschiedenen Bankkonten durchzuführen.

### Was beobachten Sie nun?
- Die synchronisierte transfer-Methode wurde implementiert.
- Kontostände sind immer noch inkorrekt.

### Wie erklären Sie sich Programmverhalten?
- Mögliche weitere race conditions oder Nebenläufigkeitsprobleme.
- Synchronisation möglicherweise nicht ausreichend.
- Andere Teile des Codes müssen möglicherweise synchronisiert werden.

### Eliminieren Sie die Schwachstelle nun vollständig, falls immer noch Fehler passieren. Wie machen Sie das am besten?
- Synchronisation auf einem globalen Niveau anwenden.
- Klassen-Synchronisationsmethode verwenden, um die transfer-Methode der BankAccount-Klasse zu synchronisieren. 
- So wird nur ein Thread gleichzeitig auf die transfer-Methode zugreifen kann, unabhängig davon, auf welcher Instanz sie aufgerufen wird.

## 2.4
### Wie müssen Zugriffe auf gemeinsame Ressourcen am besten geschützt werden?
- Diese sollten am besten durch Synchronisation geschützt werden (sodass nur ein Thread gleichzeitig darauf zugreifen kann)

### Was sollte bei der Synchronisation in jedem Fall vermieden werden?
- Vermeiden, dass zu viele Abschnitte des Codes gleichzeitig gesperrt werden, da dies die Leistung des Programms beeinträchtigen kann und zu Deadlocks führen kann.

### Was verursacht der Einsatz von Synchronisation im Allgemeinen?
- Synchronisation führt zu zusätzlicher Verarbeitungszeit.
- Threads müssen warten, um auf kritische Abschnitte des Codes zuzugreifen.
- Dies kann die Leistung des Programms beeinträchtigen.
- Besonders problematisch, wenn viele Threads auf die gleichen Ressourcen zugreifen möchten.