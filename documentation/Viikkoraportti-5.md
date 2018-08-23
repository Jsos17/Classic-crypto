# Viikkoraportti 5

## Mitä olen tehnyt


## Miten ohjelma on edistynyt

Hashapin toimintaa enemmän tai vähemmän jäljittelevä HashTable, joka käyttää kahteen suuntaan linkitettyä listoja yhteentörmäysten ratkaisemisessa (hashing with chaining). Tämä rakenne sallii usean saman avaimen tallennuksen rakenteeseen eikä edes tarkista duplikaatteja, ja siten on lähinnä tarkoitettu uniikeille avaimille, sillä jos rakenteessa on useita samoja avaimia ei voi tietää mikä niistä palautetaan.

HashSetin toimintaa enemmän tai vähemmän jäljittelevä HashedSet, joka toimii uniikkeja olioita tallentavana joukkototeutuksena ja tälle hajautusrakenteelle oma kahteen suuntaan linkitetty lista (hashing with chaining). Tämä rakenne on käytössä HillClimber luokassa, jossa HashedSetin avulla yritetään välttää jo kerran generoitujen satunnaisten avaimien fitness-arvon uudelleen laskemista.

HillClimber luokka, ja erityisesti siinä Transposition cipherin murtaminen luomalla satunnaisia avaimia ja yrittämällä löytää lokaali optimi ja sitten tämän koko algoritmin uudelleenajo useita kertoja tallentaen kaikki lokaalit optimit ja toivoen, että globaali optimi löytyy näiden joukosta.

Vigenere salauksissa hajautustaulun käytön välttäminen "hakkerointiratkaisulla" hyödyntämällä merkkien uniikkeja ASCII/Unicode arvoja Java-kielessä. Kuten mainittu,  tämä ratkaisu on hiukan hakkerointia, koska voi olla että merkkien kokonaislukuarvot eivät säily samana tulevaisuudessa ja sen takia koko toiminnallisuus voisi hajota tämän vuoksi. Lisäksi tehokkuushyöty on todennäköisesti hyvin pieni ja sen vuoksi voi olla että palaan normaalin hajautustaulun käyttöön. 

* Esimerkiksi aakkostossa abcdefghijklmnopqrstuvwxyz merkin 'a' käyttämistä moduluksena ja laskemalla oikea indeksin *character mod 'a'* menetelmällä. Tämä menetelmä nojaa siihen että yllämainittujen aakkosten ASCII- ja Unicode arvot ovat peräkkäin (97-122) ja siihen että niiden voi olettaa pysyvän samana myös tulevaisuudessa.

* Keyed Vigenere cipherissa hyödynnetään sitä faktaa, että k % 29 on uniikki luku, missä k = 97,...,122 (eli siis merkit a,b,...,z) ja näin tämä on eräänlainen ad-hoc hajautusfunktio, joka edelleen nojaa näiden kyseisten merkkien ASCII/Unicode arvoihin Java-kielessä.

## Mitä opin tällä viikolla

Hill climbing menetelmästä jonkin verran, hajautustaulun toteutuksesta suhteellisen paljon.

## Vaikeudet


## Kysymykset/Mikä jäi epäselväksi

**hashCode**: Riittäkö, että nojaa Javan omaan toteutukseen vai pitääkö luoda oma menetelmä hashCoden generointiin? Tällä hetkellä itse alkiot hajautustauluun hajauttava funktio on:

    (key.hashCode() & 0x7fffffff) % this.hashtable.length

missä bittimanipulaatio on negatiiviisia lukuja varten ja this.hashtable.length on valittu kovakoodatuista alkuluvuista, jotka ovat kaukana kakkosen potensseista, ja joiden koot suurinpiirtein kaksinkertaistuvat kun taulukon kokoa kasvatetaan.

**Merkkijonojen manipulointi**: Onko välttämätöntä luoda omat toiminallisuudet? toUpperCase, toLowerCase, välien ja muiden merkkien poisto sekä uusien merkkijonojen luonti char arraystä ovat hyvin yleisiä toimintoja jo nyt ja käyttöliittymässä tullaan käyttämään erityisesti. 

**Pseudo-random generator**:

## Mitä teen seuraavaksi

Yleisesti tarkoitus on saada työ niin pitkälle valmiiksi kuin mahdollista.

Salausalgoritmeja (ciphers) ei lisätä vaan paketoidaan Vigenere ja sen variantit sekä Transposition cipherit käytöliittymään, jossa käyttäjä voi suorittaa salauksia ja niiden dekryptauksia haluamillaan parametreilla. Käyttöliittymästä pyritään tekemään yksinkertainen graafinen näyttöikkuna (minkä pitäisi onnistua suhteellisessa ajassa).

Salauksen murtamisen osalta uusia toiminnallisuuksia ei enää pyritä juurikaan lisäämään vaan tyydytään murtamisen osalta Vigenere cipherin murtamiseen olemasssa olevien frekvenssianalyysin ja index of coincidencen avulla sekä single columnar transposition cipherin murtamiseen brute forcen (permutaatiot) ja hill climbingin avulla. Lisäksi mahdollisesti hill climbing tekniikkaa sovelletaan Vigenere cipherin murtamiseen. Myös murtamistoiminnallisuus pyritään paketoimaan samaan graafiseen käyttöliittymään omaksi osiokseen.

Tietorakenteita saatetaan optimoida testauksen perusteella tai jos aikaa jää.

Sanakirjahyökkäystoiminnallisuus saatetaan lisätä transpositioncipheriin, jos sopiva sanakirja saadaan kokoon ja aikaa jää.

## Käytetty tuntimäärä

| päivä   | käytetty aika (h) | toimenpiteet |
| :----:|:--------| :----------|
| Viikko 5 |
| 18.8. | 1 | Combinatorics-luokan optimoinnin kokeilua (josta lopulta vain taulukoiden int[] -> byte[] muutos päätyi koodiin), Ngrams -luokan tekstitiedoston lukemisen virhetilanteille testejä |
| 20.8. | 3 |  Hajautustaulujen toteutukseen liittyvä tutkimus |
| 21.8. | 6 | Lisää tutkimusta, kahteen suuntaan linkitetyn listan toteutus ja testit, ja yhteentörmäykset ketjutuksella ratkaisevan perushajautustaulun toteutuksen aloitus |
| 22.8. | ~ 8 | Hajautustalun toteutus, Vigenere salauksissa hajaatustalun käytön välttely esimerkiksi hyödyntäen merkkien Unicode arvoja ja tallentamalla niitä taulukkoon niiden Unicode arvon modulo (Unicode arvo) 'a' perusteella. Hill climbing algoritmin tutkimusta |
| 23.8. | 8 | HashSet typpisen rakenteen ja sille omien listarakenteiden luonti, Hill climbing  algoritmin aloittelua, ja eritysesti sen sovellus Transposition cipherin avaimien löytämisessä etsimllä lokaaleja maksimeja ja toivoen että niiden joukossa on globaali maksimi, dokumentaation lisäys |
| 24.8. | ? | |

[Tuntikirjanpito](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/tuntikirjanpito.md)
