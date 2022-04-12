Softwaretechnologie: Java 2

# Übung 2

Diese Übung wird erstmals als Branch auf GitHub eingereicht. Dazu gibt es unten recht kleinteilige Anweisungen, in späteren Übungen wird das nicht mehr so genau beschrieben.

## a) Repository klonen und Eclipse-Projekt anlegen

Klonen Sie dieses Repository direkt in Eclipse, indem Sie `File > Import ...` wählen. Im Dialog danach wählen Sie den `Git`-Zweig und `Projects from Git`, gefolgt von `Clone URI`. Die URI bekommen Sie, indem Sie auf GitHub den grünen Knopf `Code` anklicken, und dann den mit https beschrifteten Link kopieren. Für diese Übung ist das `https://github.com/idh-cologne-java-2/exercise-02.git`.

Klicken Sie auf `Next >` und vergessen Sie im nächsten Dialog nicht, ihre GitHub-Authentifizierungsdaten anzugeben (damit Sie später auch wieder etwas hochladen können).

Wählen Sie unter `Branch Selection` den Branch `main` aus, und danach das Verzeichnis auf ihrer lokalen Festplatte.



## b) 



----

## a) Fehler finden

In der Datei `a/A.java` findet sich Code, der das folgende tun soll: Ein Array soll mit zufälligen Zahlen gefüllt werden. Ist die Summe der Zahlen im Array größer als 750, soll "Hello World" ausgegeben werden. Leider ist der Code voller Fehler. Finden und beheben Sie sie!

## b) Geldautomat

In der Datei `b/ATM.java` finden Sie den Quellcode für einen Teil einer Geldautomaten-Steuerungslogik. Damit kann die folgende Interaktion durchgeführt werden:

```
exercise-01$ java b/ATM
Enter the amount to withdraw: 21
Enter the amount to withdraw: 452
Enter the amount to withdraw: 5.6
```

Wie Sie sehen, kann der Geldautomat nur mit ganzen Zahlen operieren und stürzt ab, wenn etwas anderes eingegeben wird. Es gibt verschiedene Verbesserungen, die wir in den nächsten Wochen am Geldautomat vornehmen wollen. Heute wollen wir die `ATM`-Klasse erstmal so verändern, dass sie überprüft, ob der Benutzer genug Geld zur Verfügung hat, und eine passende Fehlermeldung ausgibt, wenn das nicht der Fall ist. Der Kontostand sollte sich dann auch im Laufe einer Sitzung verändern, also mitgespeichert werden, wie viel die Benutzerin noch übrig hat. Wir gehen hier der Einfachheit halber davon aus, dass der Geldautomat immer genügend Bargeld zur Verfügung hat, und schreiben den initialen Kontostand "hart" in den Code.


Eine Interaktion sollte also ungefähr so aussehen:
```
exercise-01$ java b/ATM
Enter the amount to withdraw: 25
Ok, here is your money, enjoy!
Enter the amount to withdraw: 200
Sorry, not enough money in the bank.
Enter the amount to withdraw: exit
```


## c) GitHub-Account schicken

Falls noch nicht geschehen, schicken Sie Ihren GitHub-Account an [nils.reiter@uni-koeln.de](mailto:nils.reiter@uni-koeln.de).