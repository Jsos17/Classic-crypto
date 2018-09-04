# CryptoApp suorituskyky-testausdokumentti (kesken)

## Vigenere salauksen murtamisen tehokkuus tilastollisella chi-squared menetelmällä

Toteutettua Vigenere salauksen murtamista testattiin keräämällä [501 eri pituista plaintextiä](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/unmanipulated_501_sample_plaintexts.txt) mielivaltaisista Wikipedian artikkeleista ja [Project Gutenbergin](http://www.gutenberg.org/wiki/Category:Bookshelf) kirjoista ja lopulta salaamalla tekstit eri avaimien pituuksilla. Testiaineistot luokiteltiin seuraavasti:

| Selkotekstin/salatatekstin pituusluokka | Pituuksien keskiarvo luokan sisällä | Määrä |
| ----|-----|----------|
| [1-50](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/plaintexts1-50.txt) | 37.1 | 71 |
| [51-100](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/plaintexts51-100.txt) | 75.9 | 71 |
| [101-150](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/plaintexts101-150.txt) | 124.2 | 93 |
| [151-200](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/plaintexts151-200.txt) | 173.1 | 64 |
| [201-250](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/plaintexts201-250.txt) | 225.3 | 45 |
| [251-300](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/plaintexts251-300.txt) | 274.9 | 49 |
| [301-350](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/plaintexts301-350.txt) | 328.6 | 35 |
| [351-400](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/plaintexts351-400.txt) | 379.3 | 34 |
| [401-500](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/plaintexts401-500.txt) | 442.8 | 39 |
| Yhteensä | | 501 |

Tämän jälkeen käsitellyt selkotekstit salattiin avainpituuksilla 1-14 ja joka kerralla testattiin kuinka monta oikeaa avainta menetelmä löytää, sillä oletuksella että avaimen pituus tiedetään jo. Avaimen pituuden tietämysolettama on vähintään kohtuullinen  sillä index of coincidence arvot paljastavat yleensä hyvin selkeästi avainkandidaatit, joista pienin on looginen aloituskohta.
Tässä testatuksessa kerättiin vain täsmälleen oikeat vastaukset, eikä esimerkiksi yhdellä kirjaimella pielessä olevia avaimia otettu huomioon.

[Lukumäärät](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/vigenere_krypto_avaimet.md)

| Väli | 1-50 | 51-100 | 101-150 | 151-200 | 201-250 | 251-300 | 301-350 | 351-400 | 401-500 |
|----|----|----|----|----|----|----|----|----|----|
| Avain (Pituus) | Oikeita avaimia **%** |
| datastructures (14) | 0.0 | 0.0 | 0.0 | 7.8 | 22.2 | 32.7 | 28.6 | 76.5 | 71.8 |
| footballplayer (14) | 0.0 | 0.0 | 0.0 | 7.8 | 22.2 | 32.7 | 28.6 | 76.5 | 71.8 |
| decompensated (13) | 0.0 | 0.0 | 2.2 | 10.9 | 24.4 | 42.9 | 54.3 | 76.5 | 87.2 |
| hazardousness (13) | 0.0 | 0.0 | 2.2 | 10.9 | 24.4 | 42.9 | 54.3 | 76.5 | 87.2 |
| eavesdropper (12) | 0.0 | 1.4 | 2.2 | 18.8 | 37.8 | 49.0 | 68.6 | 97.1 | 89.7 |
| magnetically (12) | 0.0 | 1.4 | 2.2 | 18.8 | 37.8 | 49.0 | 68.6 | 97.1 | 89.7 |
| unbreakable (11) | 0.0 | 0.0 | 9.7 | 23.4 | 40.0 | 67.3 | 74.3 | 85.3 | 92.3 |
| identically (11) | 0.0 | 0.0 | 9.7 | 23.4 | 40.0 | 67.3 | 74.3 | 85.3 | 92.3 |
| calculator (10) | 0.0 | 1.4 | 14.0 | 37.5 | 48.9 | 79.6 | 88.6 | 94.1 | 97.4 |
| academical (10) | 0.0 | 1.4 | 14.0 | 37.5 | 48.9 | 79.6 | 88.6 | 94.1 | 97.4 |
| pacifists (9) | 0.0 | 5.6 | 34.4 | 48.4 | 66.7 | 77.6 | 85.7 | 100.0 | 100.0 |
| waistcoat (9) | 0.0 | 5.6 | 34.4 | 48.4 | 66.7 | 77.6 | 85.7 | 100.0 | 100.0 |
| gangster (8) | 0.0 | 9.9 | 39.8 | 67.2 |73.3 | 87.8 | 94.3 | 100.0 | 100.0 |
| radiance (8) | 0.0 | 9.9 | 39.8 | 67.2 |73.3 | 87.8 | 94.3 | 100.0 | 100.0 |
| tactics (7) | 0.0 | 18.3 | 55.9 | 71.9 | 93.3 | 95.9 | 91.4 | 100.0 | 100.0 |
| factory (7) | 0.0 | 18.3 | 55.9 | 71.9 | 93.3 | 95.9 | 91.4 | 100.0 | 100.0 |
| habits (6) | 2.8 | 31.0 | 71.0 | 92.2 | 93.3 | 100.0 | 100.0 | 100.0 | 100.0 |
| easily (6) | 2.8 | 31.0 | 71.0 | 92.2 | 93.3 | 100.0 | 100.0 | 100.0 | 100.0 |
| mafia (5) | 9.9 | 47.9 | 84.9 | 93.8 | 97.8 | 100.0 | 100.0 | 100.0 | 100.0 |
| toxic (5) | 9.9 | 47.9 | 84.9 | 93.8 | 97.8 | 100.0 | 100.0 | 100.0 | 100.0 |
| beef (4) | 16.9 | 71.8 | 95.7 | 96.9 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 |
| life (4) | 16.9 | 71.8 | 95.7 | 96.9 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 |
| six (3) | 50.7 | 88.7 | 97.8 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 |
| ego (3) | 50.7 | 88.7 | 97.8 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 |
| do (2) | 78.9 | 98.6 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 |
| my (2) | 78.9 | 98.6 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 |
| z (1) | 97.2 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 |
| a (1) | 97.2 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 | 100.0 |

**HUOM!** kirjain-a ei suorita salausta ollenkaan, mutta koska menetelmä on tilastollinen niin joillain hyvin lyhyillä avaimilla menetelmä löytää väärän salausavaimen, mikä kertoo tilastollisen lähestymistavan heikkoudesta kun salatekstiä on hyvin vähän.

### Huomioita tuloksista:

* Huomataan, että sama avaimenpituus näyttää tuottavan saman tuloksen riippumatta avaimen sisällöstä.

* Lisäksi kun salatekstin pituus kasvaa, niin onnistuneiden murtamisyritysten määrä kasvaa, ja toisaalta avaimen pituuden pienentyessä onnistumisten määrä kasvaa myös. 

* Huomionarvoista on myös se seikka, että esimerkiksi salateksti, jonka pituus on 40 merkkkiä ja joka on salattua avaimella, jonka pituus on 5, tuottaa viisi 8 merkin pituista salateksti pätkää, joista jokainen on salattu samalla aakkostolla (ja samalla kirjaimella siis). Kuitenkin 8 merkkiä on hyvin lyhyt tekstinpätkä kunnollisen tilastollisten tunnuslukujen saamiseksi ja tämä yleinen havainto selittänee lyhyiden tekstien alhaisia murtamisprosentteja kaikilla paitsi aivan lyhimmillä avaimilla.

### Alustavia testejä Vigenere salauksen murtamiseen

[Alkuperäiset plaintextit](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/unmanipulated_sample_plaintexts.txt) ja [manipuloidut tekstinpätkät](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/sample_plaintexts.txt)

Eli edellisten tiedostojen perusteella luotiin salatekstejä Vigenere salauksella käyttäen avainpituuksia 1-8 ja laskettiin kuinka moni IndexOfCoincidence luokan findKey-metodin tuottamista avaimista oli oikein (kun tehtiin vielä lisäoletus että avaimenpituus on juuri oikea). Lisäksi kirjattiin "melkein oikein" tapaukset eli joissa saatu avain poikkesi täsmälleen yhdellä kirjaimella.


| Avain | Avaimen pituus | Oikeita avaimia | Melkein oikeita avaimia | Yhteensä salatekstejä |
| :----:|:-----|:----------|:----------|:----------|
| inventor | 8 | 8 | 9 | 113 |
| derivate | 8 | 8 | 9 | 113 |
| kryptos | 7 | 14 | 14 | 113 |
| compute | 7 | 14 | 14 | 113 |
| enigma | 6 | 17 | 24 | 113 |
| cipher | 6 | 17 | 24 | 113 |
| lemon | 5 | 31 | 26 | 113 |
| money | 5 | 31 | 26 | 113 |
| king | 4 | 43 | 48 | 113 |
| here | 4 | 43 | 48 | 113 |
| key | 3 | 77 | 26 | 113 |
| gun | 3 | 77 | 26 | 113 |
| me | 2 | 97 | (15) | 113 |
| hi | 2 | 97 | (15) | 113 |
| a | 1 | 111 | (**2 !!!!**) | 113 |
| l | 1 | 111 | (2) | 113 |

Salatekstin keskimääräinen pituus: 65,9 merkkiä, (otos) keskihajonta: 82,1

Lyhin tekstin pituus oli 16 ja pisin 710 merkkiä eli testidata ei ollut kovin tasaista pituuksiltaan sillä se sisälsit muutamia suhteellisen pitkiä tekstejä ja toisaalta suhteellisen paljon melko lyhyehköjä salatekstejä. Tulevissa testeissä on tarkoitus luokitella tekstit suurinpiirtein samalla pituustasolla olevin luokkiin.

Huomattavaa on että pelkällä kirjaimella a salaaminen ei tee selkotekstille mitään ja silti saadaan kaksi väärä avainta! Lisäksi avaimien pituuksien 2 ja 1 kohdalle melkein oikein suluissa koska "melkein oikein" ei oikeastaan tarkoita enää mitään noin lyhyiden avaimien kohdalla.

Ensimmäiseksi, huomataan että sama avainpituus tuottaa täsämälleen samanlaista dataa riippumatta itse avaimen sisällöstä (tämä näytti toistuvan myös muilla avaimilla). Toiseksi huomataan kasvava trendi avaimen pituuden lyhentyessä salatekstin pituuden suhteen (joka säilyy vakiona).

## Transposition salauksen murtamisen tehokkuus Hill climbing/Random search/Stcohastic optimization menetelmän avulla



## Testiaineiston luonti

Testiaineistoa on kerätty kopioimalla mielivaltaisia tekstinpätkiä wikipediasta ja  [Project Gutenbergin](http://www.gutenberg.org/wiki/Harvard_Classics_(Bookshelf)) tarjoamista kirjoista. On myös yritetty ottaa tekstiä eri tyyppisiltä alueilta: Esim Crime and Punishment, Meditations, Prince jne ja wikipediasta tiede-, urheilu ja historiatekstinpätkiä. Kuitenkin tämä on yllättävä hidasta, ellen sitten päätä vain kopioida suurta tekstinpätkää ja sitten katkaise sitä pienemmiksi paloiksi. Yksi mahdollisuus olisi löytää jotain valmiita aineistoja, mutta tämä voi olla vaikeaa.  
