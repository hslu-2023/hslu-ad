# Reflexion

## Warum eigentlich Threads verwenden?
- Gleichzeitige Ausführung von Aufgaben, Parallele Verarbeitung (Gleichzeitige Bewegung mehrerer Bälle auf dem Bildschirm)
- Flüssige und ansprechende Animation

## Wie werden die Threads erzeugt?
- Implementierung des Runnable-Interfaces
- Erstellen eines Thread-Objekts mit dem Runnable oder der Thread-Instanz als Argument
- Konventionell: Aufrufen der start()-Methode, um den Thread zu starten
- Virtuell: Aufrufen der startVirtualThread()-Methode, um den Thread zu starten

## Wann werden die Threads beendet?
- Wenn ihre run()-Methode abgeschlossen ist (sobald der Ball den unteren Bildrand erreicht hat und nicht mehr sichtbar ist)
- Wenn der Thread explizit durch Aufruf der interrupt()-Methode unterbrochen wird


## Merken Sie einen Unterschied zwischen konventionellen und virtuellen Threads?
- Konventionelle Threads sind durch das Betriebssystem bereitgestellt
- Virtuelle Threads werden durch die virtuelle Maschine verwaltet und bieten höhere Flexibilität und Effizienz

## Was ist die gemeinsame Ressource in dieser Aufgabe?
- Die Canvas, auf der die Bälle gezeichnet werden