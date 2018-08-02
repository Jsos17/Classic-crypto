# Määrittelydokumentti

## Ratkaistava ongelma

### Salaus

Tarkoitus on luoda useita erilaisia työkaluja tekstin salaamiseen ja salauksen purkamiseen avaimen avulla.

### Salauksen murtaminen (kryptoanalyysi)

Tarkoitus on tutkia tiettyjen salausmenetelmien murtamista ja luoda algoritmeja ainakin rajattujen menetelmien murtamiseen tiettyjen oletusten vallitessa. Lisäksi jos on mahdollista, niin yleistää näitä algoritmeja yleisemmässäkin tapauksessa toimivaksi menetelmäksi/algoritmiksi.

## Toteutettavat algoritmit/menetelmät

Melkein kaikissa tapauksissa Wikipedian sivuilla on kuvattu yleinen menetelmä eikä mitään tarkkaa algoritmia, joten yleisiä aikavaativuuksia varsinkaan salauksen rikkomisesta en pysty esittämään.

Sen sijaan klassiset salausalgoritmit vaikuttavat nopealla yleiskatsauksella skaalautuvan lineaarisesti 

### Toteutetaan useita klassisia salausmenetelmiä:

* [Vigenere cipher](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher) ja mahdollisesti sen variantit: Käyttää useita siirrettyjä aakkostoja jotka valitaan avaimen avulla ja jokainen kirjain salataan näin ollen mahdollisesti eri aakkostolla

* [VIC cipher](https://en.wikipedia.org/wiki/VIC_cipher): Wikipedian mukaan yksi monimutkaisimmista kynällä ja paperilla operoiduista salauksista

* [One-time-pad](https://en.wikipedia.org/wiki/One-time_pad): Teoriassa ja oikein käytettynä murtamaton menetelmä eli jos salausavaimet tuotetaan aidoista satunnaisluvuista, avaimia ei uudelleenkäytetä, avain on vähintään yhtä pitkä kuin salattava viesti ja avaimet voidaan jakaa turvallisesti osapuolille.

* [Mahdollisesti: Kryptograafisesti turvallinen satunnaislukugeneraattori](https://en.wikipedia.org/wiki/Cryptographically_secure_pseudorandom_number_generator): Liittyen erityisesti One-time-padin käyttöön

* [Jokin double transposition menetelmä](https://en.wikipedia.org/wiki/Transposition_cipher#Double_transposition)

* Mahdollisesti muita esim Bifid, Trifid jne

### Salauksen analysointi- ja murtamismenetelmiä:

* [Kirjainten frekvenssianalyysi](https://en.wikipedia.org/wiki/Frequency_analysis): Auttaa esimerkiksi rajaamaan käytettyä salausmenetelmää

* [Kasiski examination Vigenere cipherin murtamisessa](https://en.wikipedia.org/wiki/Kasiski_examination): Auttaa käytetyn avaimen selvittämisessä ja tässä suurimman yhteisen tekijä selvittäminen nousee esille

* [Index of coincidence](https://en.wikipedia.org/wiki/Index_of_coincidence) 

### Spesifisiä algoritmeja

* Suurin yhteinen tekijä: *Euclid(a,b)* (sivu 935) tai *Extended-euclid(a,b)* (sivu 937) kirjasta Introduction to Algorithms.

### Algoritmien valinta

Yritän valita haastavampia ja monimutkaisempia klassisista salausalgoritmeista koska yleissilmäys aiheeseen kertoi, että yleisesti ottaen nämä menetelmät eivät ole kovin monimutkaisia koska niitä on operoitu kynällä ja paperilla. Siksi esimerkiksi Caesar cipherin toteutus olisi ollut turhan yksinkertaista ja käytännössä Vigenere cipheriin sisältyy myös Caesar cipher.

Varsinkin salauksen rikkomiseen liittyvät algoritmit vaativat todennäköisesti omaa työtä ja kekseliäisyyttä.

## Tietorakenteet 

Minulla ei ole tarkkaa kuvaa tarvittavista tietorakenteista tällä hetkellä varsinkaan salauksen purkamiseen liittyen, mutta salausalgoritmit näyttävät selviävän pelkillä taulukoilla. Monimutkaisempia tietorakenteita tarvittaneen salauksen rikkomisessa, mahdollisesti esimerkiksi jonkinlaisten sanakirjojen käytön yhteydessä (hajautustaulu, hakupuu).

## Syötteet

Tällä hetkellä ajatus on, että salatessa syöte on tekstimuodossa (String) ja salausta purkaessa vastaavasti.

## Aikavaativuustavoitteet

Näyttää siltä että kaikki klassiset salausmenetelmät toimivat O(n) ajassa (alustava pika-arvio).

Salauksen rikkominen on hyvin vaikea arvioida tässä vaihesssa, mutta mitä suurimmalla todennäköisyydellä ei pysytä enää pelkästään lineaarisessa aikavaativuudessa.

Introduction to Algorithms kirjassa Euclid(a,b) tekee O(beta^2) bitti-operaatiota, jos a ja b ovat beta-bittisiä numeroita. Eritellympiä arvioita: https://en.wikipedia.org/wiki/Euclidean_algorithm#Algorithmic_efficiency.

## Lähteet

Mainittujen linkkien lisäksi:

[Cryptography](https://en.wikipedia.org/wiki/Cryptography)

Introduction to algorithms, 3rd Edition


