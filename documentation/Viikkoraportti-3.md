# Viikkoraportti 3

## Mitä olen tehnyt

### Maanantai:

Vähän alustavaa työtä salauksen murtamiseen (Frekvenssianalyysi-luokan aloittelu).

### Torstai:

Index of coincidencen https://en.wikipedia.org/wiki/Index_of_coincidence laskemisen ja frekvenssianalyysin avulla loin Vigenere salauksen murtamiseen ainakin joillain syötteillä kykenevän koodin. Lähteinä käytetty wikipedian lisäksi muun muassa:
http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-vigenere-cipher/ 
http://practicalcryptography.com/cryptanalysis/text-characterisation/chi-squared-statistic/ 

Koodia ei ole erityisemmin refaktoroitu (vielä).

Frekvenssianalyysiluokkaan on kovakoodattu englannin kielen kirjainten keskimääräinen esiintymisfrekvenssi, ja lähteenä käytetty sivua https://en.wikipedia.org/wiki/Letter_frequency#Relative_frequencies_of_letters_in_the_English_language sekä wikipedian alkuperäislähdettä http://en.algoritmy.net/article/40379/Letter-frequency-English (joka puolestaan ilmoittaa alkuperäislähteekseen LEWAND, Robert. Cryptological mathematics. [s.l.] : The Mathematical Association of America, 2000. 199 p. ISBN 0-88385-719-7). Samat frekvenssit löytyvät myös tiedostosta *letter_frequency_eng.csv*.

Kasiskin testin luonti Vigenere cipherin murtamiseen näyttää näillä näkymin turhalta koska tuo yhteensattumien laskeminen (Index of coincidence) näyttää olevan huomattavasti suoraviivaisempi ja parempi metodi.

Apuluokkien ja algoritmien luontia kuten suurimman yhteisen tekijän löytäminen.

## Miten ohjelma on edistynyt

Viikonloppuna ja alkuviikolla työskentelyaikaani meni matematiikan yleistenttiin (ke 8.8. klo 10-14) valmistautuessa, joten siksi tällä viikolla vain torstai ja perjantai olivat tehokkaita työskentelypäiviä harjoitustyön parissa. Siksi työ ei ole edistynyt ihan niin paljon kuin olisin toivonut.  



## Mitä opin tällä viikolla

Salauksen murtaminen alkoi vähän jo aueta.


## Vaikeudet



## Kysymykset/Mikä jäi epäselväksi


## Mitä teen seuraavaksi

Tarkoitus on käyttää huomattavasti enemmän aikaa harjoitustyöhön tällä viikolla kun tämän viikon kaltaista tilannetta (koevalmistautuminen) ei ole häiritsemässä.

Omien tietorakenteiden toteutusta ja salauksen murtamisen jatkamista.

## Käytetty tuntimäärä

| päivä   | käytetty aika (h) | toimenpiteet |
| :----:|:--------| :----------|
| Viikko 3 |
| 6.8. | 1 | Saluksen murtamisen alkutoimia ja tutkimusta |
| 9.8. | 9 | IndexOfCoincidence ja FrequencyAnalysis -luokkien avulla Vigenere cipherin murtaminen eli salausavaimen löytäminen (alustava koodi, ei refaktoroitu), apuluokkia ja -algoritmeja (mm. suurin yhteinen tekijä) |
| 10.8. | ? | |
