# CryptoApp toteutusdokumentti (kesken)

## Ohjelman yleisrakenne

Ohjelma jakaantuu salausalgoritmeihin eli ciphereihin ja salauksen murtamiseen eli cryptanalysis osioon.

### Salausalgoritmit

Ohjelman käyttöliittymän kautta ja salausalgoritmien avulla on mahdollista salata viestejä käyttäen Vigenère salausta ja sen variantteja sekä transposition tyyppisiä salauksia. Algoritmit ovat 100 % deterministisiä, ja jos salauksen molemmilla osapuolilla on tiedossa käytetty salausavain, niin ohjelman avulla viestejä voi salata ja avata automaattisesti salausavaimen avulla.

Nämä salausalgoritmit löytyvät pakkauksesta *crypto.ciphers*.

### Salauksen murtaminen

Salauksen murtaminen perustuu seuraaviin oletuksiin: Salateksti (ciphertext) on tuotettu englanninkielisestä selkotekstistä (plaintext), missä esiintyy pelkästään kirjaimia abcdefghijklmnopqrstuvwxyz ja koko teksti on salattu yhtenä blokkina (eli ikäänkuin koko teksti olisi yksi pitkä sana). Koska käytössä on vain salateksti kuuluvat hyökkäykset luokkaan ciphertext-only attack, ja tavoitteena on aina selvittää se sekä käytetty salausavain että itse selkoteksti.

Sekä Vigenère cipherin että yksinkertaisen transposition cipheriin liittyvä murtamistoiminnallisuus löytyy pakkauksesta *crypto.cryptanalysis*

Luokassa Ngrams on importit 

    java.io.File 
    java.io.FileNotFoundException
    java.util.Scanner 
    
tekstitiedoston lukemista varten.

### Muut

Pakkauksista *crypto.helpers* sisältää lähinnä apuluokkia, *crypto.sorting* järjestämisalgoritmeja, *crypto.datastructures* kaksi hajautustaulutoteutusta ja linkitettyjä listoja sekä pseudo-satunnaislukugeneraattorin. 

### Käyttöliittymä

Käyttöliittymä on pakkauksessa *crypto.cryptoapp*. Tämän pakkauksen ainoassa luokassa eli käyttöliittymäluokassa on Javan omia tietorakennetoteutuksia, joita on kuitenkin käytetty vain graafisen käyttöliittymän luomiseen ja ylläpitämiseen eli esimerkiki  FXCollections ja ObservableList sekä lukuisia graafisia komponentteja.

## Aika- ja tilavaativuudet


## Työn puutteet


## Parannusehdotukset


## References / Lähteet

### General / Yleiset lähteet:

* James Lyons: http://practicalcryptography.com/ and the text files provided by him at http://practicalcryptography.com/cryptanalysis/text-characterisation/quadgrams/

* James Lyonsin tarjoamat tekstiedostot englannin kielen mono-, bi, tri- ja quadgrammeihin liittyvästä statistiikasta

* Englannin kielen kirjainten esiintymisfrekvenssit on otettu Pavel Mičkan sivulta http://en.algoritmy.net/article/40379/Letter-frequency-English jossa puolestaan viitataan alkuperäislähteeseen LEWAND, Robert. Cryptological mathematics. [s.l.] : The Mathematical Association of America, 2000. 199 p. ISBN 0-88385-719-7.

* Erityisesti testauksessa apuna: http://rumkin.com/tools/cipher/

### Spesifisesti seuraavat sivut ja niillä esitetyt yleiset menetelmät (vierailtu heinä-syyskuu 2018):

* https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher

* https://en.wikipedia.org/wiki/Transposition_cipher

* https://en.wikipedia.org/wiki/Frequency_analysis

* https://en.wikipedia.org/wiki/Letter_frequency

* https://en.wikipedia.org/wiki/Index_of_coincidence

* http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-vigenere-cipher/

* http://practicalcryptography.com/cryptanalysis/text-characterisation/chi-squared-statistic/

* http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-columnar-transposition-cipher/

* http://practicalcryptography.com/cryptanalysis/text-characterisation/quadgrams/

### Kirjallisuus:

Tietorakenteet ja algoritmit luentomateriaali, kevät 2018: Jyrki Kivinen sekä Matti Nykänen, Matti Luukkainen ja Patrik Floréen

Introduction to Algorithms, 3rd. Edition: Thomas Cormen, Charles Leiserson, Ronald Rivest, Clifford Stein 

