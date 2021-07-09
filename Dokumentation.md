# Dokumentation
## Backend
Es gibt vier Endpoints im Controller:
-	Login
-	Alle Passwörter zurückgeben
-	neues Passwort hinzufügen
-	Passwort löschen

Als Datenbank haben wir ein JPARepository gemacht. Dazu habe ich eine Passwort Entity erstellt. Die Entity hat folgende Felder.
-	ID
-	Website
-	Username
-	Passwort
-	Notiz

Im Service wird die Verschlüsslung und Entschlüsslung gemacht. Der Key wird im Konstruktor generiert und gespeichert.
Beim erstellen eines Passwortes, wird das Passwort im Service verschlüsselt, bevor es in die DB gespeichert wird.

Nachdem alle Passwörter aus der DB geholt wurden, werden alle Passwörter entschlüsselt, in das PasswortTo Objekt gespeichert und an das Frontend geschickt.

Ein Passwort kann über die Id gelöscht werden.

Als nächstes habe ich mich dem Login gewidmet. Wir haben ein Passwort und Username festgelegt.

Username: `user` 

Passwort: `passwort`
 
Beim Login hashe ich das Passwort, dass ich vom Frontend bekomme und prüfe, ob es mit dem Hash im Backend übereinstimmt. 

Problem
Mein grösstes Problem hatte ich beim Starten der Applikation. 
Spring/Maven findet kein Bean für mein Repository. 
Das Repository ist ein Interface, dass ein JPA Repository erweitert. 
In meinem Service brauche ich dieses Repository, jedoch findet es den Bean für dieses Repository nicht. 
Nach langem googeln habe ich noch immer keine Lösung gefunden. 
Ich habe alles genau so gemacht wie es in mehreren Tutorials beschrieben stand, aber irgendwie findet es mein Bean immer noch nicht. 
Habe ich den Intellij Code geöffnet, zeigt es mir aber an, dass dort ein Bean vorhanden ist. Das Problem haben wir gelöst, in dem wir ein neues Backend gemacht haben.
