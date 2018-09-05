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

Tämän jälkeen käsitellyt selkotekstit salattiin avainpituuksilla 1-14 ja joka kerralla testattiin kuinka monta oikeaa avainta menetelmä löytää, sillä oletuksella että avaimen pituus tiedetään jo. Avaimen pituuden tietämysolettama on vähintään kohtuullinen  sillä index of coincidence arvot paljastavat yleensä hyvin selkeästi avainkandidaatit, joista pienin avaimenpituus on looginen aloituskohta.
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

* Huomionarvoista on myös se seikka, että esimerkiksi salateksti, jonka pituus on 40 merkkkiä ja joka on salattua avaimella, jonka pituus on 5, tuottaa viisi 8 merkin pituista salatekstipätkää, joista jokainen on salattu samalla aakkostolla (ja siis samalla kirjaimella). Kuitenkin 8 merkkiä on hyvin lyhyt tekstinpätkä kunnollisten tilastollisten tunnuslukujen saamiseksi ja tämä yleinen havainto selittänee lyhyiden tekstien alhaisia murtamisprosentteja kaikilla paitsi aivan lyhimmillä avaimilla.

### Muita Vigenere salauksen murtamisen testejä

[Aiempi testiasetelmaltaan huonompi suorituskykytesti Vigenere salauksen murtamiselle](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Vigenere_cryptanalysis_test_old.md)

## Transposition salauksen murtamisen tehokkuus Hill climbing/Random search/Stcohastic optimization menetelmän avulla

(kesken)

## Hajautustaulutoteutusten ylivuotoketjujen pituuksien tarkastelu

Testaus tehtiin pelkästään HashTable-luokalle, sillä HashedSet on hajautusfunktion toiminnan suhteen identtinen.

### Ohjelman (mahdollisesti) käyttämien english_quadgrams.txt, english_trigrams.txt, english_bigrams.txt ja english_monograms.txt sisällön hajautus

Vain english_trigrams.txt tiedoston siältö aiheuttaa ylivuotoja, eli kahteen suuntaan linkitettyjä listoja joiden pituus on surempi kuin yksi. Kaikki kolmen muun tiedoston sisältävät stringit hashautuvat uniikkeihin kohtiin hajautustaulua. Muistettavaa on, että HashTable:n suurin mahdollinen täyttöaste on 0,75 ennenkuin sen koko suurin piirtein kaksinkertaistetaan.

HashTablen:n sisäinen taulukko oli asetettu public määreellä, jotta siihen päätiin käsiksi, ja myös hajautustaulun kohdat jotka eivät sisällä listaaa ovat null ja ne on myös laskettu. Tässä keskiarvoinen listanpituus on listojen yhteispituus jaettuna listojen määrällä, ja siis null listoja ei oteta huomioon.

| Aineisto | Aineiston koko | Pisin lista | Listojen yhteenlasketut pituudet | Listojen määrä | Listan pituus keskiarvo | Nulleja | Hajautustaulun koko |
|----|----|----|----|----|----|----|----|
| [english_quadgrams](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/hashtable_collision_tests/quadgrams_overflow.png) | 389373 | 1 | 389373 | 389373 | 1.0 | 397060 | 786433 |
| [english_trigrams](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/hashtable_collision_tests/trigrams_overflow.png) | 17556 | 2 | 17556 | 17381 | 1.01 | 7190 |  24571 |
| [english_bigrams](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/hashtable_collision_tests/bigrams_overflow.png) | 676 | 1 | 676 | 676 | 1.0 | 867 | 1543 |
| [english_monograms](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/hashtable_collision_tests/monograms_overflow.png) | 26 | 1 | 26 | 26 | 1.0 | 21 |  47 |

### HashTable:n ylivuotolistat, kun tallennetaan random permutaatioita aakkostosta

Aakkostoa abcdefghijklmnopqrstuvwxyz permutoitiin randomizeInPlace-algoritmilla tuottaen mielivaltaisia Stringejä, ja jos HashTable ei vielä sisältänyt tätä Stringiä niin se tallennetteiin sinne. Samalla kerättiin tilastoaineistoa ylivuotoketjuista.

## Testiaineiston luonti

Testiaineistoa on kerätty kopioimalla mielivaltaisia tekstinpätkiä wikipediasta ja  [Project Gutenbergin](http://www.gutenberg.org/wiki/Harvard_Classics_(Bookshelf)) tarjoamista kirjoista. On myös yritetty ottaa tekstiä eri tyyppisiltä alueilta: Esim Crime and Punishment, Meditations, Prince jne ja wikipediasta tiede-, urheilu ja historiatekstinpätkiä. Kuitenkin tämä on yllättävä hidasta, ellen sitten päätä vain kopioida suurta tekstinpätkää ja sitten katkaise sitä pienemmiksi paloiksi. Yksi mahdollisuus olisi löytää jotain valmiita aineistoja, mutta tämä voi olla vaikeaa.  
