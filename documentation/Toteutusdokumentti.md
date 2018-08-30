# CryptoApp toteutusdokumentti (kesken)

## Ohjelman esittely

### Salausalgoritmi: Vigenère cipher

Vigenère cipher perustuu selkotekstin (plaintext) jokaisen kirjaimen vaihtamiseen johonkin toiseen kirjaimeen käyttäen useaa vaihtoehtoista aakkoston järjestystä, jossa kirjaimia siirretään aina yhden pykälän vasemmalle ja erityistä salausavainta käytetään oikean aakkoston valitsemiseen. Tästä tulee sana "polyalphabetic cipher" eli jokainen kirjain salataan erityisen salausavaimen perusteella, siten että jokainen salausavaimen kirjain kuvautuu tiettyyn aakkoston järjestykseen. Jos salausavain on lyhyempi kuin selkoteksti, niin silloin avainta pidennetään lisäämällä sen kopioita itseensä kunnes pituus on riittävä.

Niin sanotussa Keyed Vigenere cipherissä aakkoston alkuun laitetaan spesifi aakkostonsekoitusavain, joka ei sisällä toistuvia aakkoston kirjaimia ja sitten jäljelle jäävät kirjaimet laitetaan aakkosjärjestyksessä avaimen jälkeen. Muuten salaus toimii kuin klassinen Vigenère, mutta aakkoston järjestyksessä on satunnaisuutta johtuen ylimääräisen aakkostoavaimen käytöstä.

Autokey Vigenèressä salausavainta käytetään salauksessa vain yhden kerran, jonka jälkeen itse selkoteksti liitetään avaimen perään ja aakkoston valinta tehdään salausavain + selkoteksti -yhdistelmän kirjainten perusteella.

### Salausalgoritmi: Transposition cipher

Transposition cipherissa selkotekstin kirjaimet säilyvät ennallaan, mutta kirjaimien järjestystä muutetaan asettamalla selkoteksti matriisin kirjoittaen tekstiä rivi kerrallaan vasemmalta oikealle. Salausavain määrittää matriisin sarakkeiden määrän ja salausavaimen kirjainten aakkosjärjestys sen missä järjestyksessä matriisin sarakkeita poimitaan muodostettavaan salatekstiin.

Tässä toteutuksessa salatekstiin (ciphertext) ei lisätä täytekirjaimia vaan matriisin viimeisen rivin annetaan tarvittaessa jäädä vajaaksi. 

## Ohjelman yleisrakenne

Ohjelma jakaantuu salausalgoritmeihin eli ciphereihin ja salauksen murtamiseen eli cryptanalysis osioon.

### Salausalgoritmit

Ohjelman käyttöliittymän kautta ja salausalgoritmien avulla on mahdollista salata viestejä käyttäen Vigenère salausta ja sen variantteja sekä transposition tyyppisiä salauksia. Algoritmit ovat 100 % deterministisiä, jos salauksen molemmilla osapuolilla on tiedossa käytetty salausavain ja ohjelman avulla viestejä voi salata ja avata automaattisesti salausavaimen avulla.

### Salauksen murtaminen

Vigenère cipherin perusversion murtamiseen on rakennettu työkaluja ja alustavasti myös singular transposition cipherin murtamiseen lyhyillä avaimilla. Nämä algoritmit eivät ole 100% deterministisiä, koska ne nojaavat paljon (englannin) kielen tilastollisiin ominaisuuksiin minkä vuoksi lyhyitä viestejä ei välttämättä pysty murtamaan ainakaan yksikäsitteisesti.

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

