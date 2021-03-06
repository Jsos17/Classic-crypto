# Classic-crypto

[![Build Status](https://travis-ci.com/Jsos17/Classic-crypto.svg?branch=master)](https://travis-ci.com/Jsos17/Classic-crypto) [![codecov](https://codecov.io/gh/Jsos17/Classic-crypto/branch/master/graph/badge.svg)](https://codecov.io/gh/Jsos17/Classic-crypto) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/8cb108b3e6294ef58af41c669d1539b7)](https://www.codacy.com/app/Jsos17/Classic-crypto?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Jsos17/Classic-crypto&amp;utm_campaign=Badge_Grade)

## Data Structures and Algorithms Lab: Summer 2018

Originally this project was done for the University of Helsinki course *Data Structures and Algorithms Lab*. My choice of topic was classical cryptography. The project consisted of implementing the encryption and decryption algorithms for [Vigenère cipher](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher), keyed Vigenère cipher and [autokey Vigenère cipher](https://en.wikipedia.org/wiki/Autokey_cipher) along with both [single](https://en.wikipedia.org/wiki/Transposition_cipher#Columnar_transposition) and [double columnar transposition](https://en.wikipedia.org/wiki/Transposition_cipher#Double_transposition) ciphers. Additionally, I produced functionality related to cryptanalysis of the Vigenère cipher.

An integral part of the course was to implement all algorithms and data structures from scratch. Naturally, the cipher algorithms were the central aspect of the project. Additionally, basic algorithms, such as iterative merge sort, insertion sort and Euclid's algorithm, were implemented as well. However, Euclid's algorithm was never used in the actual project. 

A hash table, a hash set, a doubly linked list and a random number generator were among the implemented data structures. I chose [The Lehmer random number generator](https://en.wikipedia.org/wiki/Lehmer_random_number_generator) mainly because it was simple to implement. Furthermore, an article by Park and Miller showed how to test the correctness of the random number generator implementation [[1]](#1).

The original project was done between late July 2018 and early September 2018. At the start of this project, I had no previous knowledge  of classical or modern cryptography. Thus, I had to learn on the go, implementing cipher algorithms as soon as I understood their basic principles. All of the cryptography related work was done during that short period of time.

Since the end of the course, refactoring of the graphical user interface (gui) has been started, but it has not been completed, and the original messy gui code is still used. **The code for the gui was not in the assessment criteria for the course, and it was mainly provided for the convenience of the course inspector**. Hence, [prudent and deliberate](https://martinfowler.com/bliki/TechnicalDebtQuadrant.html) technical debt was taken, when the gui was written. Additionally, the gui code is ignored in the Codecov and Codacy analysis for the aforementioned reasons.

After studying Markov chain Monte Carlo (MCMC) methods, I have since discovered literature which says that classical ciphers could be attacked with MCMC methods. Therefore, the cryptanalysis part of this project could be further extended by employing MCMC methods.

## Tietorakenteet ja algoritmit aineopintojen harjoitustyö

Harjoitustyö toteuttaa Java-kielellä klassisia kryptografisia algoritmeja ja kryptoanalyysiä näihin liittyen.

Salausalgoritmeista on toteutettu [Vigenère cipher](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher), Keyed Vigenère cipher ja [Autokey Vigenère cipher](https://en.wikipedia.org/wiki/Autokey_cipher) sekä [yksinkertainen (Single)](https://en.wikipedia.org/wiki/Transposition_cipher#Columnar_transposition) ja [kaksinkertainen (Double) Columnar Transposition](https://en.wikipedia.org/wiki/Transposition_cipher#Double_transposition).

Ohjelmassa on käyttöliittymä, jonka kautta salauksia voi tehdä (encrypt) ja avata (decrypt), ja lisäksi ohjelmassa on olemassa Vigenère cipheriin ja yksinkertaiseen transposition cipherin murtamiseen liittyvää toiminnallisuutta.

### Vigenère cipher

Vigenère cipher ja sen variantit kuuluvat luokkaan polyalphabetic substitution cipher eli ne ovat salauksia, joissa salauksessa jokainen kirjain vaihdetaan toiseen erityisen avainsanan perusteella ja käyttäen useita eri aakkostoja.

### Transposition cipher

Transposition cipher taas perustuu kirjainten järjestysten vaihtamiseen asettamalla viesti erityisen avainsanan pituisille riveille matriisi-muotoon ja sitten muodostamalla salateksti poimimalla matriisista sarakkeita (perustuen avainsanan kirjainten aakkosjärjestykseen). 

Tarvittaessa avainsanan voisi myös korvata numerosarjalla, koska itse avaimessa ainoa merkitsevä tekijä on avaimen kirjainten aakkosjärjestys. Tästä syystä on suositeltavaa, että avainsanassa jokainen kirjain esiintyy vain yhden kerran, koska muuten salauksen aakkosjärjestyksen määrääminen ei välttämättä enää ole yksikäsitteistä.

Yksinkertaisessa (Single) columnar transposition cipherissa edellä kuvattu salaus tehdään kerran yhden avaimen perusteella, kun taas kaksinkertaisessa (double) columnar transposition cipherissa yksinkertainen salaus tehdään kaksi kertaa peräjälkeen käyttäen kahta avainta. Käytetyt avaimet voivat olla samoja, tosin kahden eri avaimen käyttö antaa vahvemman salauksen.

### Lisähuomautus

[Vigenère cipheriin](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher) ja sen variantteihin viitataan tässä työssä usein pelkästään sanoilla "Vigenere cipher" kirjoittamisen helpottamiseksi, vaikka oikeaan kirjoitusasuun kuuluu tuo è-merkki.

### Salauksen murtaminen eli cryptanalysis

Työssä on toteutettu toiminnallisuutta tavallisen Vigenère cipherin murtamiseen.

## References / Keskeiset lähteet

<a id="1">[1]</a> 
Stephen K. Park; Keith W. Miller (1988). Random Number Generators: Good Ones Are Hard To Find. Communications of the ACM. Volume 31. pages 1192-1201

The website of James Lyons http://practicalcryptography.com/ is a central reference in this project, and he has been kind enough to provide extremely useful text files containing statistical data of the English language on his website http://practicalcryptography.com/cryptanalysis/text-characterisation/quadgrams/

Without these text files some cryptanalysis of this project would be impossible.

Työssä on käytetty erityisesti James Lyonsin sivustoa http://practicalcryptography.com/ lähteenä ja erityisesti sivun http://practicalcryptography.com/cryptanalysis/text-characterisation/quadgrams/ lopussa olevia tekstitiedostoja englannin kielessä esiintyvien mono-, bi-, tri-, ja quadgrammien esiintyvyyteen. Ilman näiden tiedostojen tarjoamaa tilastoaineistoa, tietyt osat kryptoanalyysistä eivät olisi ollenkaan mahdollisia.

## Keskeiset dokumentit

[Määrittelydokumentti](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Maarittelydokumentti.md)

[Käyttöohje](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Kaytto-ohje.md)

[Oikeellisuuden testausdokumentti](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Oikeellisuus-testausdokumentti.md)

[Suorituskyvyn testausdokumentti](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Suorituskyky-testausdokumentti.md)

[Toteutusdokumentti](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Toteutusdokumentti.md)

## Viikkoraportit

[Viikkoraportti 1](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Viikkoraportti-1.md)

[Viikkoraportti 2](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Viikkoraportti-2.md)

[Viikkoraportti 3](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Viikkoraportti-3.md)

[Viikkoraportti 4](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Viikkoraportti-4.md)

[Viikkoraportti 5](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Viikkoraportti-5.md)

[Viikkoraportti 6](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Viikkoraportti-6.md)

## Tuntikirjanpito

[Tuntikirjanpito](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/tuntikirjanpito.md)

## Muuta

Tiedosto, jota käytetty ja johon dokumentoitu osa testausprosessista liittyen erityisesti paljon laskentaa vaativien metodien testaukseen IndexOfCoincidence luokassa. LibreOffice Calcin avulla on semi-automatisoitu laskentaa monelta osin täysin riippumattomasti omasta koodista. 

[IC_test.xlxs](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/IC_test.xlsx)
