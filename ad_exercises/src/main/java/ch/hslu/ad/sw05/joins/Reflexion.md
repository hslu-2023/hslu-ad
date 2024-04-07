# Reflexion

## Worin lag die grösste Herausforderung in dieser Aufgabe?
- Verstehen der Reihenfolge der Thread-Ausführung
- Untersuchung der Auswirkungen von Join-Operationen/Einfluss von Join auf Thread-Verhalten
- Obwohl keine Codeänderungen vorgenommen wurden, war der Output bei verschiedenen Ausführungen des Programms unterschiedlich.

## Wenn Sie die Aufgabe (und mögliche Lösungen) «gegoogelt» haben. Wo liegt der grösste Unterschied zu den Aussagen im AD Input N11?

## In welchem Zustand ist ein Thread, der auf einen anderen Thread wartet?
- Wenn ein Thread die join()-Methode aufruft, wechselt der wartende Thread in den Zustand "WAITING"
- Wenn die join()-Methode mit einer Zeitübergabe wie join(long millis) aufgerufen wird, wechselt der Thread in den Zustand "TIMED_WAITING"

## Welcher Programmteil, bzw. Thread, muss die laufenden Threads abbrechen?
- Der Main-Thread