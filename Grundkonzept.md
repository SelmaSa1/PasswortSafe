Wir arbeiten mit einem Angular Frontend. 
Als erstes muss man sich mit einem User/Passwort einloggen. 
Die Formular Daten werden weiter ins Spring-boot backend geschickt. 
Dort wird es gehashed und mit dem Passwort Hash aus der MockupDB verglichen. 
Falls es stimmt, werden die Passwörter entschlüsselt. 
Diese Entschlüsselung findet mit einer symmetrischen Verschlüsselung statt. Wir verwenden eine Mockup DB, dass heisst wir müssen den Schlüssel nicht abspeichern, sondern einfach immer beim Start der Applikation einen Schlüssel generieren. Diesen Schlüssel können wir nun für das Verschlüsseln und das Entschlüsseln verwenden.

Offene Fragen:
-	Wie verschlüsseln/entschlüsseln wir die Passwörter?
