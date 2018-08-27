# Viikkoraportti 6

## Mitä olen tehnyt

### Lauantai:

Käyttöliittymään liitettiin kaikkki toteutetut salausalgoritmit (eli Vigenere, Keyed Vigenere, Autokey Vigenere ja molemmat Transposition cipherit). Nyt ohjelman kautta voi suhteellisen helposti salata (encrypt) ja avata (decrypt) viestejä, vaikka tekstin manipulointimahdollisuus puuttuukin ja syötteitä ei tarkasteta mitenkään sekä lisäksi ohjeistus siitä, minkälaisessa muodossa tekstisyötteen pitäisi olla, puuttuu. 

Lisäksi KeyedVigenereCipher refaktoroitiin siten, että käytetyn aakkostoavaimen voi asettaa uudelleen.

### Sunnuntai:

Lisättiin käyttöliittymään ohjetekstejä salauksille.

### Maanantai:

[Lehmer random number generatorin](https://en.wikipedia.org/wiki/Lehmer_random_number_generator) luonti. Lähteinä erityisesti:

Stephen K. Park; Keith W. Miller (1988). Random Number Generators: Good Ones Are Hard To Find. Communications of the ACM. Volume 31. pages 1192-1201

George Marsaglia (1993). Technical correspondence: Remarks on Choosing and Implementing Random Number Generators. Communications of the ACM. Volume 36. pages 108-110

molempiin on linkki esimerkiksi tuon wikipedia sivun lähteissä.

Valitsin tämän generaattorin, koska se oli suhteellisen helppo ymmärtää ja toteuttaa sekä se tuottanee riittävän hyviä pseudosatunnaislukuja HillClimber luokan tarpeisiin. Yksi luokan testeistä (eli seed10001thTest1) tulee suoraan paperista *Random Number Generators: Good Ones Are Hard To Find*, mikä oli erityisen kätevä testaamaan implementaatiota kokonaislukujen ylivuodon suhteen.

## Miten ohjelma on edistynyt


## Mitä opin tällä viikolla


## Vaikeudet


## Kysymykset/Mikä jäi epäselväksi



## Mitä teen seuraavaksi


## Käytetty tuntimäärä

| päivä   | käytetty aika (h) | toimenpiteet |
| :----:|:--------| :----------|
| Viikko 6 |
| 25.8. | 6 | Käyttöliittymään lisätty kaikkien salausten perustoiminnallisuus ilman syötteentarkistusta (ja ilman tekstin manipulointityökalua, joka tulossa), samalla KeyedVigenereCipher refaktoroitiin siten että aakkostoavaimen voi muuttaa set-metodilla |
| 26.8. | 2 | Dokumentoinnin päivitys ja käyttöliittymässä alutavien ohjetekstien lisäys eri salauksille |
| 27.8. | 6 | Lehmer random number generaattorin luonti ja testit |


[Tuntikirjanpito](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/tuntikirjanpito.md)
