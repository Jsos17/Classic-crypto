# Viikkoraportti 2

## Mitä olen tehnyt

### Tiistai: 

Vigenere cipherin toteutus standardi latinalaisella aakkostolla ja testejä luokalle. Nyt viestin salaus ja avaus onnistuu salausavaimen avulla. Jos käyttäjä syöttää kirjaimia, jotka eivät kuulu aakkostoon korvataan kirjain a:lla ja näin tietysti myöskään viesti ei säily entisellään koska dekryptauksen jälkeen "vieraskirjaimet" on korvattu a:lla.

Testit tehtiin osittain käsin (yksi tai kaksi) Vigenereen ja loput joko wikipedia esimerkkejä mukaillen tai sitten sivun http://rumkin.com/tools/cipher/vigenere.php avulla. Huomattavaa on, että mikään latinalaiseen aakkostoon kuulumaton kirjain rikkoo salaustoteutuksen.

### Keskiviikko:

Transposition cipherin toteutus, jossa voi valita yksin- tai kaksinkertaisen transposition-operaation salaukselle. Testit tehtiin sivujen http://rumkin.com/tools/cipher/coltrans.php ja http://rumkin.com/tools/cipher/coltrans-double.php suurella avustuksella. 

Tässä on huomattava se, että jos salausavain sisältää samoja aakkosia niin silloin valinta "Duplicates numbered forwards" tuottaa saman vastauksen johtuen siitä, että (toistaiseksi) käytetty Javan perus Arrays.sort on vakaa järjestysalgoritmi olioille (tämä tuli ihan vahingossa "kaupan päälle", sillä olin suunnitellut sillä ajatuksella että avaimissa ei olisi toistuvia kirjaimia). 

Lisäksi double transpositionin dekryptauksessa säilytän metodeissa alkuperäisten salausavaimien järjestyksen metodin parametreissa (väärinkäsitysten välttämiseksi), kun taas rumkin.com sivusto kääntää ne toisinpäin. Omassa dekryptaus-metodissa itse toteutus on tietysti sama eli että toinen avain käytetään ensin, ja sitten vasta ensimmäinen.

### Torstai:

Autokey Vigenere cipherin toteutus ja testit (sivun http://rumkin.com/tools/cipher/vigenere-autokey.php avulla). Varsinkin salauksen osalta toteutus VigenereCipher-luokan perinnän kautta oli triviaalia, mutta salauksen avaamista joutui hetken aikaa miettimään.

### Perjantai:

Javadocin ja dokumentaation kirjoittamista, jacocon lisäys. Keyed Vigenere cipheriin testien lisäys (sivun http://rumkin.com/tools/cipher/vigenere-keyed.php avulla). Testikattavuuden parantamista ja Autokey Vigenere cipherin tyhjän primer-avaimen tapauksen käsittely (jolloin salauksen suoraviivainen dekryptaus ei onnistu). Aloitin perehtymisen salauksen murtamiseen.

## Miten ohjelma on edistynyt

Useita salauksia luotu ja erityisesti Vigenere ja Transposition cipher näistä merkittävimmät sillä, Autokey ja Keyed Vigenere ovat vain Vigeneren laajennoksia. Testit ovat nimelliseltä kattavuudeltaan 100% ja laadulliselta kattavuudeltaan sellaisia, että voi olla suhteellisen varma algoritmien toiminnasta. **HUOM!** Käyttöliittymäpakkaus jätetty testien ulkopuolelle kuten Ohjelmistotekniikan menetelmät-kurssilla (ja lisäksi käyttöliittymää ei edes ole vielä).

![Testikattavuus](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/testikattavuus_vko_2.png)

Salauksen murtamista ei ole aloitettu.

## Mitä opin tällä viikolla

Perusteita klassisten salausalgoritmien toiminnasta ja sitä kautta varmaan on parempi valmius toteuttaa näitä salauksia lisää suhteellisen nopeasti. Lisäksi huolimatta salausalgoritmien suhteellisen yksinkertaisista toimintaperiaatteista, toteutusta piti usein miettiä vähän pitempään. Eli taas kerran se mikä on yksinkertainen operaatio tehdä itse, ei välttämättä ole heti niin yksinkertaista koodata algoritmiksi.

Lisäksi opin sen, että Java ei laske matemaattista modulo-aritmetiikkaa/kongruensseja vaan jakojäännöksiä, koska %-operaattori tuottaa negatiivisia lukuja, jos "jaettava" on negatiivinen.

## Vaikeudet

Varsinaisia vaikeuksia ei ollut tällä viikolla, ne alkavat varmaan vasta sitten kun pitää kräkätä salausta.

## Kysymykset/Mikä jäi epäselväksi

**Mutaatiotestaus (pitest)**: Pitäisikö tätä asiaa jotenkin erityisesti/syvällisesti itse ymmärtää vai voiko sen vaan jättää huomiotta?

Epäselviä asioita varmasti on, mutta ei mitään sellaista josta voisi erityisesti kysyä tai johon saada selvennystä, koska nämä liittyvät nimenomaan tuohon salauksen murtamiseen, johon en ole vielä kunnolla ehtnyt paneutua jotta siitä mitään tarkempaa voisi kysyä.

## Mitä teen seuraavaksi

### Omien perustietorakenteiden ja -algoritmien toteutus:

Hajautustaulu korvaamaan Javan HashMap sekä järjestämisalgoritmeja, joista todennäköisesti insertion-sort pieniä taulukoita varten, counting-sort erikoistapauksiin ja sitten todennäköisesti merge-sort (vakauden vuoksi). Lisäksi jos on aikaa, niin (pseudo)-satunnaislukugeneraattorin työstämistä.

### Varsinainen harjoitustyön ydinalue, kryptografia:

Salauksen murtamiseen liittyvien toimintojen rakentamisen aloittaminen: Frekvenssianalyysi, Kasiskin testi jne

Mahdollisesti salausalgoritmien kokoelman laajentaminen ja olemassaolevien mahdollinen refaktorointi. Vigenere cipherine aakkoston laajentaminen mahdollisesti kattamaan (kaikki) suurin osa merkeistä.

## Käytetty tuntimäärä

| päivä   | käytetty aika (h) | toimenpiteet |
| :----:|:--------| :----------|
| Viikko 2 |
| 31.7. | 8 | Vigenere cipherin toteutus ja sen testit, Keyed Vigenere salauksen aloitus |
| 1.8. | 6 | Toteutus transposition cipher ja sen testit, ja alustava Keyed Vigenere |
| 2.8. | 5 | Transposition cipherin jatkamista, Autokey Vigenere cipherin toteutus ja testit, dokumentaation päivittämistä |
| 3.8. | 5 | Javadocin kirjoittamista luokille, mutaatiotestauksen(?) kokeilu, jacoco- ja javadoc-raporttien luonnin testaus, käyttöliittymä (jota ei vielä edes ole) poistettiin testauskattavuudesta, testikattavuuden parantamista |


[Tuntikirjanpito](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/tuntikirjanpito.md)
