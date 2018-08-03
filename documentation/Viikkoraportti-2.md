# Viikkoraportti 2

## Mitä olen tehnyt

### Tiistaina: 

Vigenere cipherin toteutus standardi latinalaisella aakkostolla ja testejä luokalle. Nyt viestin salaus ja avaus onnistuu salausavaimen avulla. Jos käyttäjä syöttää kirjaimia, jotka eivät kuulu aakkostoon korvataan kirjain a:lla ja näin tietysti myöskään viesti ei säily entisellään koska dekryptauksen jälkeen "vieraskirjaimet" on korvattu a:lla.

Testit tehtiin osittain käsin (yksi tai kaksi) Vigenereen ja loput joko wikipedia esimerkkejä mukaillen tai sitten sivun http://rumkin.com/tools/cipher/vigenere.php avulla. Huomattavaa on, että mikään latinalaiseen aakkostoon kuulumaton kirjain rikkoo salaustoteutuksen.

### Keskiviikkona:

Transposition cipherin toteutus, jossa voi valita yksin- tai kaksinkertaisen transposition-operaation salaukselle. Testit tehtiin sivujen http://rumkin.com/tools/cipher/coltrans.php ja http://rumkin.com/tools/cipher/coltrans-double.php suurella avustuksella. 

Tässä on huomattava se, että jos salausavain sisältää samoja aakkosia niin silloin valinta "Duplicates numbered forwards" tuottaa saman vastauksen johtuen siitä, että (toistaiseksi) käytetty Javan perus Arrays.sort on vakaa järjestysalgoritmi olioille (tämä tuli ihan vahingossa "kaupan päälle", sillä olin suunnitellut sillä ajatuksella että avaimissa ei olisi toistuvia kirjaimia). 

Lisäksi double transpositionin dekryptauksessa säilytän metodeissa alkuperäisten salausavaimien järjestyksen metodin parametreissa (väärinkäsitysten välttämiseksi), kun taas rumkin.com sivusto kääntää ne toisinpäin. Omassa dekryptaus-metodissa toteutus on tietysti sama eli että toinen avain käytetään ensin, ja sitten vasta ensimmäinen.

### Torstai

Autokey Vigenere cipherin toteutus ja testit (sivun http://rumkin.com/tools/cipher/vigenere-autokey.php avulla). Varsinkin salauksen osalta toteutus VigenereCipher-luokan perinnän kautta oli triviaalia, mutta salauksen avaamista joutui hetken aikaa miettimään.

### Perjantai

Javadocin ja dokumentaation kirjoittamista, jacocon lisäys. Keyed Vigenere cipheriin testien lisäys (sivun http://rumkin.com/tools/cipher/vigenere-keyed.php avulla).

## Miten ohjelma on edistynyt

Useita salauksia luotu ja erityisesti Vigenere ja Transposition cipher näistä merkittävimmät sillä, Autokey ja Keyed Vigenere ovat vain Vigeneren laajennoksia. Testit ovat semikattavia, monet rajatapaukset ovat testaamatta tällä hetkellä, mutta sen verran on kattavuutta, että voi olla suhteellisen varma algoritmien toiminnasta.

Salauksen murtamiseen en ehtinyt perehtyä saati aloittaa sitä.

## Mitä opin tällä viikolla:

Perusteita klassisten salausalgoritmien toiminnasta ja sitä kautta varmaan on parempi valmius toteuttaa näitä salauksia lisää suhteellisen nopeasti. Lisäksi huolimatta salausalgoritmien suhteellisen yksinkertaisista toimintaperiaatteista, toteutusta piti usein miettiä vähän pitempään. Eli taas kerran se mikä on yksinkertainen operaatio tehdä itse, ei välttämättä ole heti niin yksinkertaista koodata algoritmiksi.

Lisäksi opin sen, että Java ei laske matemaattista modulo-aritmetiikkaa/kongruensseja vaan jakojäännöksiä, koska %-operaattori tuottaa negatiivisia lukuja, jos "jaettava" on negatiivinen.

## Vaikeudet

Varsinaisia vaikeuksia ei ollut tällä viikolla, ne alkavat varmaan vasta sitten kun pitää kräkätä salausta.

## Kysymykset/Mikä jäi epäselväksi

Mutaatiotestaus (pitest): Pitäisikö tätä asiaa jotenkin erityisesti/syvällisesti itse ymmärtää vai voiko sen vaan jättää huomiotta?

Epäselviä asioita varmasti on, mutta ei mitään sellaista josta voisi erityisesti kysyä tai johon saada selvennystä, koska nämä liittyvät nimenomaan tuohon salauksen murtamiseen, johon en ole vielä kunnolla ehtnyt paneutua jotta siitä mitään tarkempaa voisi kysyä.

## Mitä teen seuraavaksi:

### Omien perustietorakenteiden ja -algoritmien toteutus:

Hajautustaulu korvaamaan Javan HashMap sekä järjestämisalgoritmeja, joista todennäköisesti insertion-sort pieniä taulukoita varten, counting-sort erikoistapauksiin ja sitten todennäköisesti merge-sort (vakauden vuoksi). Lisäksi jos on aikaa, niin (pseudo)-satunnaislukugeneraattorin työstämistä.

### Varsinainen harjoitustyön ydinalue, kryptografia:

Salauksen murtamiseen liittyvien toimintojen rakentamisen aloittaminen: Frekvenssianalyysi, Kasiskin testi jne

Mahdollisesti salausalgoritmien kokoelman laajentaminen ja olemassaolevien mahdollinen refaktorointi. Vigenere cipherine aakkoston laajentaminen mahdollisesti kattamaan (kaikki) suurin osa merkeistä. 
