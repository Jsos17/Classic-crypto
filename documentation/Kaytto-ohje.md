# Käyttöohje

## Ohjelman esittely

### Salausalgoritmi: Vigenère cipher

Vigenère cipher perustuu selkotekstin (plaintext) jokaisen kirjaimen vaihtamiseen johonkin toiseen kirjaimeen käyttäen useaa vaihtoehtoista aakkoston järjestystä, jossa kirjaimia siirretään aina yhden pykälän vasemmalle ja erityistä salausavainta käytetään oikean aakkoston valitsemiseen. Tästä tulee sana "polyalphabetic cipher" eli jokainen kirjain salataan erityisen salausavaimen perusteella, siten että jokainen salausavaimen kirjain kuvautuu tiettyyn aakkoston järjestykseen. Jos salausavain on lyhyempi kuin selkoteksti, niin silloin avainta pidennetään lisäämällä sen kopioita itseensä kunnes pituus on riittävä.

Niin sanotussa Keyed Vigenere cipherissä aakkoston alkuun laitetaan spesifi aakkostonsekoitusavain, joka ei sisällä toistuvia aakkoston kirjaimia ja sitten jäljelle jäävät kirjaimet laitetaan aakkosjärjestyksessä avaimen jälkeen. Muuten salaus toimii kuin klassinen Vigenère, mutta aakkoston järjestyksessä on satunnaisuutta johtuen ylimääräisen aakkostoavaimen käytöstä.

Autokey Vigenèressä salausavainta käytetään salauksessa vain yhden kerran, jonka jälkeen itse selkoteksti liitetään avaimen perään ja aakkoston valinta tehdään salausavain + selkoteksti -yhdistelmän kirjainten perusteella.

### Salausalgoritmi: Transposition cipher

Transposition cipherissa selkotekstin kirjaimet säilyvät ennallaan, mutta kirjaimien järjestystä muutetaan asettamalla selkoteksti matriisin kirjoittaen tekstiä rivi kerrallaan vasemmalta oikealle. Salausavain määrittää matriisin sarakkeiden määrän ja salausavaimen kirjainten aakkosjärjestys sen missä järjestyksessä matriisin sarakkeita poimitaan muodostettavaan salatekstiin.

Tässä toteutuksessa salatekstiin (ciphertext) ei lisätä täytekirjaimia vaan matriisin viimeisen rivin annetaan tarvittaessa jäädä vajaaksi.

### Salauksen murtaminen:
