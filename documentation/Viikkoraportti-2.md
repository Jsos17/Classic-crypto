# Viikkoraportti 2

## Mitä olen tehnyt

### Tiistaina: 

Vigenere cipherin toteutus standardi latinalaisella aakkostolla ja testejä luokalle. Nyt viestin salaus ja avaus onnistuu salausavaimen avulla. Jos käyttäjä syöttää kirjaimia, jotka eivät kuulu aakkostoon korvataan kirjain a:lla ja näin tietysti myöskään viesti ei säily entisellään koska dekryptauksen jälkeen "vieraskirjaimet" on korvattu a:lla.

Testit tehtiin osittain käsin (yksi tai kaksi) Vigenereen ja loput joko wikipedia esimerkkejä mukaillen tai sitten sivun http://rumkin.com/tools/cipher/vigenere.php avulla. Huomattavaa on, että mikään latinailaiseen aakkostoon kuulumaton kirjain rikkoo salaustoteutuksen.

### Keskiviikkona:

Transposition cipherin toteutus, jossa voi valita yksin- tai kaksinkertaisen transposition-operaation salaukselle. Testit tehtiin sivujen http://rumkin.com/tools/cipher/coltrans.php ja http://rumkin.com/tools/cipher/coltrans-double.php suurella avustuksella. 

Tässä on huomattava se, että jos salausavain sisältää samoja aakkosia niin silloin valinta "Duplicates numbered forwards" tuottaa saman vastauksen johtuen siitä, että (toistaiseksi) käytetty Javan perus Arrays.sort on vakaa järjestysalgoritmi olioille (tämä tuli ihan vahingossa "kaupan päälle", sillä olin suunnitellut sillä ajatuksella että avaimissa ei olisi toistuvia kirjaimia). 

Lisäksi double transpositionin dekryptauksessa säilytän metodeissa alkuperäisten salausavaimien järjestyksen metodin parametreissa (väärinkäsitysten välttämiseksi), kun taas rumkin.com sivusto kääntää ne toisinpäin. Omassa dekryptaus-metodissa toteutus on tietysti sama eli että toinen avain käytetään ensin, ja sitten vasta ensimmäinen.

### Torstai:

Autokey Vigenere cipherin toteutus ja testit. Varsinkin salauksen osalta toteutus VigenereCipher-luokan perinnän kautta oli triviaalia, mutta salauksen avaamista joutui hetken aikaa miettimään.

## Mitä teen seuraavaksi:

### Omien perustietorakenteiden ja -algoritmien toteutus:

Hajautustaulu korvaamaan Javan HashMap sekä järjestämisalgoritmeja, joista todennäköisesti insertion-sort pieniä taulukoita varten, counting-sort erikoistapauksiin ja sitten todennäköisesti merge-sort. Lisäksi luultavasti (pseudo)-satunnaislukugeneraattorin työstämistä.

### Varsinainen harjoitustyön ydinalue, kryptografia:

Salauksen murtamiseen liittyvien toimintojen rakentamisen aloittaminen: Frekvenssianalyysi, Kasiskin testi jne

Salausalgoritmien kokoelman laajentaminen ja olemassaolevien mahdollinen refaktorointi. 
