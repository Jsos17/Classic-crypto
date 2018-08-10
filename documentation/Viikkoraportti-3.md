# Viikkoraportti 3

## Mitä olen tehnyt

### Maanantai:

Vähän alustavaa työtä salauksen murtamiseen (Frekvenssianalyysi-luokan aloittelu).

### Torstai:

Index of coincidencen https://en.wikipedia.org/wiki/Index_of_coincidence laskemisen ja frekvenssianalyysin avulla loin Vigenere salauksen murtamiseen ainakin joillain syötteillä kykenevän koodin. Lähteinä käytetty wikipedian lisäksi muun muassa:
http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-vigenere-cipher/ 
http://practicalcryptography.com/cryptanalysis/text-characterisation/chi-squared-statistic/ 

Koodia ei ole erityisemmin refaktoroitu (vielä) ja testit puuttuvat osittain luokan keskeneräisyyden vuoksi. Lisäksi huomataan että metodi ei ole täysin deterministinen sillä esimerkiksi esimerkkisyöte:

    vptnvffuntshtarptymjwzirappljmhhqvsubwlzzygvtyitarptyiougxiuydtgzhhvvmum"
    + "shwkzgstfmekvmpkswdgbilvjljmglmjfqwioiivknulvvfemioiemojtywdsajtwmtcgluy"
    + "sdsumfbieugmvalvxkjduetukatymvkqzhvqvgvptytjwwldyeevquhlulwpkt"

antaa salausavaimeksi "ciahers" vaikka oikea olisi "ciphers" (kuten sivulla http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-vigenere-cipher/ kerrotaan). Tämän vuoksi metodin findKey palautusarvo muutettiin kaksiulotteiseksi taulukoksi, jotta kryptoanalyytikko voi valistuneesti päätellä että a kirjain pitää korvata p:llä joka on toisena järjestyksessä (chi-squared arvon mukaan) a:n jälkeen.

Frekvenssianalyysiluokkaan on kovakoodattu englannin kielen kirjainten keskimääräinen esiintymisfrekvenssi, ja lähteenä käytetty sivua https://en.wikipedia.org/wiki/Letter_frequency#Relative_frequencies_of_letters_in_the_English_language sekä wikipedian alkuperäislähdettä http://en.algoritmy.net/article/40379/Letter-frequency-English (joka puolestaan ilmoittaa alkuperäislähteekseen LEWAND, Robert. Cryptological mathematics. [s.l.] : The Mathematical Association of America, 2000. 199 p. ISBN 0-88385-719-7). Samat frekvenssit löytyvät myös tiedostosta *letter_frequency_eng.csv*.

Huomattavaa on, että index of coincidencen  "odotusarvon" laskeminen käyttäen kovakoodattuja arvoja antaa hiukan poikkeavan lukeman wikipedian artikkeliin https://en.wikipedia.org/wiki/Index_of_coincidence verrattuna: ~ 1.70 versus Wikipedian 1.73. 

Kasiskin testin luonti Vigenere cipherin murtamiseen näyttää näillä näkymin turhalta koska tuo yhteensattumien laskeminen (Index of coincidence) näyttää olevan huomattavasti suoraviivaisempi ja parempi metodi.

Apuluokkien ja algoritmien luontia kuten suurimman yhteisen tekijän löytäminen.

### Perjantai:

Lähinnä testien lisäämistä, perusalgoritmitoteutusten selvittelyä, javadocin lisäämistä uusien luokkien ja metodien osalta sekä yleistä dokumentaation päivittämistä.

Merkkien esiintymistä laskevan metodin testaamisessa käytin sivuja https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html ja http://www.characterfrequencyanalyzer.com/english/index.php hyödyksi siten että tarkistin molempien sivujen antavan saman tuloksen, ja sitten käsin kopioimalla taulukoihin loin testisyötteet. Jälkimmäisestä sivusta on huomioitava, että se ei näytä ollenkaan kirjaimia joita ei esiintynyt tekstissä.

## Miten ohjelma on edistynyt

Työ ei ole edistynyt ihan niin paljon kuin olisin toivonut koska viikonloppuna ja alkuviikolla työskentelyaikaani meni matematiikan yleistenttiin (Johdatus logiikkaan I ke 8.8.) valmistautuessa.

Salauksen murtaminen on kunnolla aloitettu Vigenere salauksen osalta index of coincincidencen ja frekevenssianalyysin keinoin. Periaatteessa koodi vaikuttaa olevan toimivaa mutta sen jatkokehitys "automatisointi VS käyttäjän valinnat" kannalta sekä tähän liittyen jonkinlaisen käyttöliittymän luominen on tarpeen.

IndexOfCoincindence -luokan kohdalta testejä ei juuri ole koska vaikka periaattessa luokka on täysin toiminnallinen, niin testien muotoa pitää vielä miettiä koska aina ei ole mahdollista saada täysin oikeaa vastausta ja lisäksi ylipäätänsä koko luokan toiminnallisuutta pitää vielä miettiä uudelleen. Lisäksi järjestysalgoritmiluokkaan ei vielä ole tehty testejä kun siellä on vasta yksi metodi, joka sekin on lähes suora kopio TiRan luentomateriaalista.

Muilta osin testien kattavuus on korkea.

![Kaikki testit](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/week_3_test_coverages/all_tests.png)

![Cipherit](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/week_3_test_coverages/cipher_tests.png)

![Kryptoanalyysi]()

![Sorting](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/week_3_test_coverages/sorting_tests.png)

![Helpers](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/week_3_test_coverages/helper_tests.png)

## Mitä opin tällä viikolla

Salauksen murtamisesta aika paljon.

## Vaikeudet

Tuo perusalgoritmien toteutus juuri eri datatyyppien käsittelyn osalta: primitiivityyyppien kohdalta asia ainakin selkeni koska tarvittaessa voi sitten vain copypasteta saman koodin eri parametrityypeillä. Olioiden suhteen en ole aivan varma ymmärränkö vielä miten se toteutetaan mutta en ole vielä kovin paljoa ehtinyt perehtymään asiaan.

## Kysymykset/Mikä jäi epäselväksi

Ei erityisiä kysymyksiä.

## Mitä teen seuraavaksi

Tarkoitus on käyttää huomattavasti enemmän aikaa harjoitustyöhön seuraavalla viikolla kun häiriötekijöitä (koevalmistautuminen) ei ole.

Omien tietorakenteiden ja perusalgoritmien toteutusta ja salauksen murtamisen jatkamista niin pitkälle kuin mahdollista.

## Käytetty tuntimäärä

| päivä   | käytetty aika (h) | toimenpiteet |
| :----:|:--------| :----------|
| Viikko 3 |
| 6.8. | 1 | Saluksen murtamisen alkutoimia ja tutkimusta |
| 9.8. | 11 | IndexOfCoincidence ja FrequencyAnalysis -luokkien avulla Vigenere cipherin murtamista eli salausavaimen löytämistä (alustava koodi, ei refaktoroitu), apuluokkia ja -algoritmeja (mm. suurin yhteinen tekijä) |
| 10.8. | 8 | Lisää testejä, javadocin täydennystä, tutkimusta, dokumentaation kirjoitusta, iteratiivinen euclid |

[Tuntikirjanpito](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/tuntikirjanpito.md)
