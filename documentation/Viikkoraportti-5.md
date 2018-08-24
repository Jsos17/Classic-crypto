# Viikkoraportti 5

## Mitä olen tehnyt

### Keskiviikko:

HashTable toteutus vastaamaan perinteistä hajautustaulua, jossa yhteentörmäykset ratkaistaan ketjuttamalla avain-arvo parit kahteen suuntaan linkitettyihin listoihin. Tähän tietorakenteeseen voi tallentaa monta samaa avainta jotka viittaavat eri arvoon (ei suositeltavaa/ei ole käyttötarkoitus: tällä hetkellä näiden kaikkien eri arvojen hakua ei tueta)

### Torstai:

HashedSetin toteutus mallintamaan joukkoa matemaattisesti (ei duplikaatteja, pelkkä olio/olioviite tallennetaan)

Hill climbing algoritimin aloittelu seuraavien yleisten ohjeiden pohjalta:

http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-columnar-transposition-cipher/

https://en.wikipedia.org/wiki/Hill_climbing 

https://en.wikipedia.org/wiki/Stochastic_hill_climbing

https://crypto.stackexchange.com/questions/19439/generating-child-keys-for-a-hill-climb-algorithm

### Perjantai:

Graafisen käyttöliittymän pohja, jossa nyt toivia päävalikko, josta pääsee napeilla eri salausmenetelmien pariin ja takaisin. Itse algoritmeja ei vielä ole liitetty, ja muutenkin itse koodissa surutta copypastetaan eikä sitä ole refaktoroitu juurikaan.

## Miten ohjelma on edistynyt

*HashMapin* toimintaa enemmän tai vähemmän jäljittelevä **HashTable**, joka käyttää kahteen suuntaan linkitettyä listoja yhteentörmäysten ratkaisemisessa (hashing with chaining). Tämä rakenne sallii usean saman avaimen tallennuksen rakenteeseen eikä edes tarkista duplikaatteja, ja siten on lähinnä tarkoitettu uniikeille avaimille, sillä jos rakenteessa on useita samoja avaimia ei voi tietää mikä niistä palautetaan.

*HashSetin* toimintaa enemmän tai vähemmän jäljittelevä **HashedSet**, joka toimii uniikkeja olioita tallentavana joukkototeutuksena ja tälle hajautusrakenteelle on oma kahteen suuntaan linkitetty lista (hashing with chaining). Tämä rakenne on käytössä HillClimber luokassa, jossa HashedSetin avulla yritetään välttää jo kerran generoitujen satunnaisten avaimien fitness-arvon uudelleen laskemista.

**HillClimber** luokka, ja erityisesti siinä Transposition cipherin murtaminen luomalla satunnaisia avaimia ja yrittämällä löytää lokaali optimi ja sitten tämän koko algoritmin uudelleenajo useita kertoja tallentaen kaikki lokaalit optimit ja toivoen, että globaali optimi löytyy näiden joukosta.

Vigenere salauksissa hajautustaulun käytön välttäminen "hakkerointiratkaisulla" hyödyntämällä merkkien uniikkeja ASCII/Unicode arvoja Java-kielessä. Kuten mainittu,  tämä ratkaisu on hiukan hakkerointia, koska voi olla että merkkien kokonaislukuarvot eivät säily samana tulevaisuudessa ja sen takia koko toiminnallisuus voisi hajota tämän vuoksi. Lisäksi tehokkuushyöty on todennäköisesti hyvin pieni ja sen vuoksi voi olla että palaan normaalin hajautustaulun käyttöön. 

* Esimerkiksi aakkostossa abcdefghijklmnopqrstuvwxyz merkin 'a' käyttämistä moduluksena ja laskemalla oikea indeksin *character mod 'a'* menetelmällä. Tämä menetelmä nojaa siihen että yllämainittujen aakkosten ASCII- ja Unicode arvot ovat peräkkäin (97-122) ja siihen että niiden voi olettaa pysyvän samana myös tulevaisuudessa.

* Keyed Vigenere cipherissa hyödynnetään sitä faktaa, että k % 29 on uniikki luku, missä k = 97,...,122 (eli siis merkit a,b,...,z) ja näin tämä on eräänlainen ad-hoc hajautusfunktio, joka edelleen nojaa näiden kyseisten merkkien ASCII/Unicode arvoihin Java-kielessä.

Testikattavuus on suhteellisen hyvä. Ainoastaan hajautusrakenteiden kokoon ja koon kasvattamiseen ja pienentämiseen liittyvissä rajatapausten testauksesa on puutteita. Lisäksi HillClimber luokassa kaksi päämetodia, jotka perustuvat satunnaisen avaimen valintaan ovat täysin testaamattomia (manuaalisesti on testattu) koska algoritmit eivät ole deterministisiä tulosten suhteen ja toistaiseksi en keksinyt järkevää tapaa testaamiseen. Oikeastaan kaikki HillClimber luokan metodit ovat satunnaisuuteen perustuvia ja niiden todellinen testaus tapahtunee suorituskykytestauksen kautta eli kuinka usein menetelmä antaa oikean vastauksen.

![Testikattavuus_vko_5](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/testikattavuus_vko_5.png)

### HillClimber luokka

Kun seuraava teksti salattiin (ilman välejä) avaimella "machinerys" single columnar transposition salauksella (eli käyttäen pelkästään aakkosia abcdefghij avain olisi kirjainten aakkosjärejestykseltään: fabdegchji)

    a perfect hash function with values in a limited range can be used for efficient lookup operations by placing keys from s or other associated values in a lookup table indexed by the output of the function one can then test whether a key is present in s or lookup a value associated with that key by looking for it at its cell of the table each such lookup takes constant time in the worst case
    
saadaan ciphertext:
 
    phinascpskrcepxtuctetustyrlllsireftaneiobeoistepnawyipohlileocmsctliarlaarrdletfoehrrlttiihhpttsruhlgdepyytaiaducnhinactotoeooetfnviefnepshtnbbtttessvihoafaknicaswiruiungoouueufesknksiboebhetoecamcotrlfeealyoihtpoaaakttcusnatiutneotcoavoihtnneeluekntestaheansdefkonsslkdoeneaeoawyfcacktwhoeebfoiimsaonehotrsoedegstuane
    
ja kun tätä salaustaa yrittää murtaa HillClimber luokan avulla: climber.runToTheHills(10, ciphertext.toUpperCase(), 20, 1000)

niin ohjelma usein palauttaa oikean avaimen fabdegchji mutta toisinaan melkein oikean avaimen ifabdegchj:

![Oikea tulos](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/right_key.png)

![Väärä tulos](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/wrong_key.png)

Eli viitteitä algoritmin toimivuudesta siis on, mutta tässä tosin heti käytettiin avaimen pituutta 10 (koska se tiedettiin) ja muutenkin tämä on tietysti yksittäistapaus. Kuitenkin algoritmi näyttää lupaavalta.


## Mitä opin tällä viikolla

Hill climbing menetelmästä jonkin verran, hajautustaulun toteutuksesta suhteellisen paljon.

## Vaikeudet

Hajautustaulun toteutusyksityiskohdat olivat yllättävän haastavia vaikka ymmärrän rakenteen sinällään aika hyvin. 

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
| 22.8. | ~ 8 | Hajautustaulun (HashTable luokka) sekä linkitetyn listan uudelleensuunnittelu ja toteutus, Vigenere cipherin ja sen varianttien refaktorointi siten että hajautustataulu on tarpeeton, Hill climbing algoritmin tutkimusta |
| 23.8. | 8 | HashedSet luokan ja sille oman kahteen suuntaan linkitetyn listan luonti mallintamaan suurinpiirtein Javan HashSettiä, Hill climbing algoritmin aloittelu,  dokumentaation lisäys |
| 24.8. | 5 | Graafisen käyttöliittymän hyvin karu ei-refaktoroitu luonnos, missä nyt olemassa toiminnallisuus siirtyä päävalikosta salaukseen ja takaisin, mutta ei vielä liitettyä algoritmillista toiminnallisuutta |

[Tuntikirjanpito](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/tuntikirjanpito.md)
