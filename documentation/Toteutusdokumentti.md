# CryptoApp toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelma jakaantuu salausalgoritmeihin eli ciphereihin ja salauksen murtamiseen eli cryptanalysis osioon.

## Erot määrittelydokumenttiin

VIC vipheria ei toteutettu johtuen hyvin epäselvistä menetelmää selittävistä lähteistä. One-time-pad ei välttämättä olisi tuonut erityistä lisäarvoa työlle varsinkaan kryptoanalyysin suhteen (koska on murtamaton oikein toteutettuna) ja näin myöskään kryptografisesti turvalliselle satunnaislukugeneraattorille ei ollut enää tarvetta. Edellisestä johtuen tyydyttiin paljon yksinkertaisempaan Lehmer random number generaattoriin (joka siis ei ole kryptografisesti turvallinen). Lisäksi Kasiskin testin implementaatiosta luovuttiin index of coincidence ja chi-squared menetelmien hyväksi.

### Salausalgoritmit

Ohjelman käyttöliittymän kautta ja salausalgoritmien avulla on mahdollista salata viestejä käyttäen Vigenère salausta ja sen variantteja sekä transposition tyyppisiä salauksia. Algoritmit ovat 100 % deterministisiä, ja jos salauksen molemmilla osapuolilla on tiedossa käytetty salausavain, niin ohjelman avulla viestejä voi salata ja avata automaattisesti salausavaimen avulla.

Nämä salausalgoritmit löytyvät pakkauksesta **crypto.ciphers**.

### Salauksen murtaminen

Salauksen murtaminen perustuu seuraaviin oletuksiin: Salateksti (ciphertext) on tuotettu englanninkielisestä selkotekstistä (plaintext), missä esiintyy pelkästään kirjaimia abcdefghijklmnopqrstuvwxyz ja koko teksti on salattu yhtenä blokkina (eli ikäänkuin koko teksti olisi yksi pitkä sana). Koska käytössä on vain salateksti kuuluvat hyökkäykset luokkaan ciphertext-only attack, ja tavoitteena on aina selvittää se sekä käytetty salausavain että itse selkoteksti.

Sekä Vigenère cipherin että yksinkertaisen transposition cipheriin liittyvä murtamistoiminnallisuus löytyy pakkauksesta **crypto.cryptanalysis**

Luokassa Ngrams on importit 

    java.io.File 
    java.io.FileNotFoundException
    java.util.Scanner 
    
tekstitiedoston lukemista varten.

### Muut

Pakkauksista **crypto.helpers** sisältää lähinnä apuluokkia, **crypto.sorting** järjestämisalgoritmeja, **crypto.datastructures** kaksi hajautustaulutoteutusta ja linkitettyjä listoja sekä pseudo-satunnaislukugeneraattorin. 

### Käyttöliittymä

Käyttöliittymä on pakkauksessa **crypto.cryptoapp**. Tämän pakkauksen ainoassa luokassa eli käyttöliittymäluokassa on Javan omia tietorakennetoteutuksia, joita on kuitenkin käytetty vain graafisen käyttöliittymän luomiseen ja ylläpitämiseen eli esimerkiki  FXCollections ja ObservableList sekä lukuisia graafisia komponentteja.

## Aika- ja tilavaativuudet (teoreettiset)

Työ painottui testaamaan sitä minkälaisia salatekstejä voidaan murtaa, ja siksi aikavaatimuksia ei ole empiirisesti testattu, koska salausalgoritmeilla se olisi luultavasti triviaalia niiden lineaarisuuden (tekstin pituuden suhteen) vuoksi ja toisaalta salauksen murtamisessa on lähinnä keskitytty siihen, että edes joitain salatekstejä saatataisiin murrettua joissain olosuhteissa. Lisäksi klassisissa salausalgoritmeissa salauksen murtaminen muuttuu sitä todennäköisemmäksi mitä enemmän salatekstiä on suhteessa avaimeen (ja myös absoluuttisesti tekstin pituutena). 

Sen sijaan pitkät avaimet olisivat varmasti tehokkudelle kova testi varsinkin transposition salauksissa, mutta tässä projektissa juuri ja juuri saatiin jotain alustavaa salauksen murtamistoiminnallisuutta aikaan, ja aikaa ei oikeastaan jäänyt isoihin testeihin pitkille avaimille transposition cipherissa.

### Oletusmerkinnät:

Ellei erikseen muuta mainita, n = selko-/salatekstin pituus merkkeinä

### Salaukset:

Salausalgoritmien (sekä encrypt että decrypt) aikavaativuudet ovat kaikki O(n). Salausalgoritmi-luokkien kaikki metodit ovat tilavaativuudeltaan joko O(1) tai O(n), sillä esimerkiksi transposition salauksessa käytetään kaksiulotteista taulukkoa hyväksi, mutta senkin koko on O(n), ja lisäksi usein salateksti tai selkoteksti joko kopioidaan Stringinä tai sitten char-arraynä.

Yleisesti siis aikavaativuuksien suhteen salauksessa ei tapahdu mitään ihmeellistä.

## Salauksen murtaminen:

Transposition cipherin murtamisen päämenetelmässä runToTheHills, algoritmin rungossa aikaa vievin operaatio on varmasti fitness-arvon laskeminen joka vie ajan O(n) koska esimerkikis quadgrammeja on n-pituisessa tekstissä n-3 kappaletta ja muut operaatiot ovat O-analyysin mielessä vakiaikaisia. 

Siis runToTheHills aikavaativuus on luokkaa O(algoRuns * iterations * n), sillä jokaisessa for-loopin rungossa suoritetaan fitness-arvon lasku. Parametrit algoRuns ja iterations eivät suinkaan ole vakioita sillä, niiden kokoa pitää kasvattaa jos salausavaimen koko kasvaa, koska muuten ohjelma ei (hyvin-alustavan) empiirisen testauksen perusteella löydä oikeita avaimia.

Vigenere cipherin murtamisessa aikaa vievimmät algoritmit löytyvät luokasta IndexOfCoincidence, sillä eri tilastollisten tunnuslukujen lasku vaati käytännössä aina koko syötteenä saatavan tekstin läpikäynnin ja siitä tunnusluujen laskemisen.

(Joitain teoreettisia) aikavaativuuksia IndexOfCoincidence luokasta: 

* subSequences(ciphertext, keyLen): O(n)

* chiSquared(occurrences, frequencies, textLen): O(o), missä o = occurrences.length

* deltaBarIC(String ciphertext): O(n)

* aggregateDeltaBarIC(ciphertext, keyLen): O(n), koska deltaBarIc saa parametriksi subseuquencen ja täm toistetaan subsequencien määrän verran ja näin subsequences.length * subesequences = n

* allAggregateDeltaBarICs(ciphertext): O(n^2), koska aggregateDeltaBarIC suoritetaan n kertaa

# Omat tietorakenteet ja (perus)algoritmit

Järjestysalgoritmit, hajautustaulutoteutus, permutaatioiden generointi ja suurimman yhteisen tekijän löytäminen noudattavat pitkälti Tietorakenteiden ja algoritmien kevään 2018 luentomateriaalin ja kirjan Introduction to Algorithms 3rd. edition pseudokoodia ja näin on luotettu niiden tehokkuuteen. 

Ainoa asia joka on testattu on hajautustaulun ylivuotolistojen pituus, ja testaus paljasti että ohjelman tyypillisesti käyttämällä aineistolla (josta suuri osa on staattisissa tekstitiedostoissa tai kuuluu standardi latinalaisen aakkostooon) ylivuotolistojen koko pysyy kurissa. Tämä testaus löytyy [suorituskykytestatuksesta](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Suorituskyky-testausdokumentti.md).

## Työn puutteet

**HUOM jar-tiedostoon liittyy se ongelma että english_quadgrams.txt tiedosto ei löydy (vaikka se on mukana jarissa), minkä vuoksi transposition cipherin murtamistoiminnallisuus ei toimi jos ohjelma suoritetaan jarin kautta** 

Vaikka tähän työhön on käytetty huomattavasti aikaa (kokonaistuntimäärä lähestyy 200), niin aika ei silti riittänyt tehdä kaikkea, ja moni asia jäi jossain määrin keskeneräiseksi. Erityisesti tässä työssä aikaa vievää oli testiaineistojen kerääminen/luonti ja toisaalta tutkimukseen kulunut aika.

Salauksen murtaminen on lähinnä kokoelma jossain määrin irrallisia algoritmeja, ja itse murtamisprosessi vaatii käyttjältä manuaalisia toimia ja valistuneita päätelmiä. Esiemrkiksi Vigenere salauksen murtamisessa  käyttäjän on itse pääteltävä salausavaimen pituus pylväskaavion visualisoinnin avulla. Lisäksi ajanpuutteen vuoksi jotkut toiminnallisuudet jäivät puuttumaan käyttöliittymästä, kuten brute-force permutaatioiden generointi ja tekstin manipulointityökalu. Transposition cipherin murtamisessa ei ole mitään keinoa löytää avaimen pituutta, vaan sen löytämiseksi olisi vain kokeiltava avaimen pituuksia läpi ja katsottava milloin dekryptaus näyttää järkevältä. Tässä tietysti tekstin oleminen yhdessä pötkössä vaikeuttaa asian toteamista.

Lisäksi käyttöliittymässä Vigenere salauksen murtamisessa pitkillä avaimilla kaikki mahdolliset kirjaimet eivät enää näy käyttäjälle johtuen pudotusvalikoista. Tätä ei kuitenkaan ole ehditty muuttaa paremmaksi ajanpuutteen vuoksi, ja koska käyttöliittymä on kuitenkin vain lisänä tälle työlle ja itse toiminnallisuus on kuitenkin olemassa.

Koodia pystyisi monin paikoin refaktoroimaan vieläkin enemmän, mutta tähän ei ole jäänyt aikaa, projektin ajankäytöllisen vaativuuden vuoksi.

## Parannusehdotukset

Salauksen murtamista voisi sekä kehittää algoritmisempaan suuntaan, eli automatisoida miltei kaiken. Lisäksi työkalujen kehittäminen sen tunnistamiseen minkälaista salausta salatekstissä todennäköisesti on käytetty, olisi hyödyllistä. Nyt ohjelma nimittäin lähtee siitä oletuksesta, että käyttäjä joko tietää tai sitten vain arvaa onko salaus esimerkiksi Vigenere tai yksinkertainen Transposition cipher.

Vigenere salauksen murtamisessa stochastic hill climbing/random local search menetelmän hyödyntäminen (siis eri versio nykyisestä mutta samoja perusperiaatteita hyödyntävä). Nimittäin, epäilen että tämä menetelmä olisi toiminut paremmin kuin chi-squared arvojen perusteella tehtävä kryptoanalyysi varsinkin lyhyiden tekstien salaamisessa käytettyjen avaimien selvittämisessä.

Sekä salauksien että salauksen murtamismenetelmien laaajentaminen ja syventäminen. Työ on kuitenkin vasta pintaraapaisu edes klassisten salausmenetelmien suhteen, puhumattakaan vaikkapa Enigma-laitteen tyyppisistä salauksista.

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

Jyrki Kivinen sekä Matti Nykänen, Matti Luukkainen ja Patrik Floréen. *Tietorakenteet ja algoritmit luentomateriaali*, kevät 2018

Thomas Cormen, Charles Leiserson, Ronald Rivest, Clifford Stein. *Introduction to Algorithms, 3rd. Edition*

Stephen K. Park; Keith W. Miller. *Random Number Generators: Good Ones Are Hard To Find* (1988). Communications of the ACM. Volume 31. pages 1192-1201

George Marsaglia. *Technical correspondence: Remarks on Choosing and Implementing Random Number Generators* (1993). Communications of the ACM. Volume 36. pages 108-110
