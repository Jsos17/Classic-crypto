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

### Tiistai:

Käyttöliittymään lisättiin 1. versio murtamistoiminnalllisuudesta: Esimerkiksi IndexOfCoincidence-luokan findKey-metodin palauttaman kaksiulotteisen CharacterValue taulukon kaikki arvot ovat nähtävissä käyttöliittymässä erillisissä pudotusvalikoissa paremmuusjärjestyksessä ja näin käyttäjä voi helposti kokeilla muita avaimia, jos metodin palauttama ensimmäinen avain ei ollut täsmälleen oikea (tässä auttaa listattuna olevat chi-squared arvot jokaiselle merkille). Tässä on tietysti se ongelma, että jos avain on erityisen pitkä, eivät kaikki valikot enää näy käyttäjälle. Kuva selventää:


![Key dropdown menu](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/attackvigenere_key_dropdown.png)


Huomattavaa on, että löydetty salausavain on väärä (melkein oikein eli "ciahers" kun pitäisi olla "ciphers"), ja tässä käyttäjän pitäisi tehdä sitten itse päätelmiä mikä kirjain pitäisi muuttaa hänen englannin kielen tietämyksensä perusteella (oletuksena siis että alkuperäinen teksti on englanniksi ja näin ollen avainsana linee myös jokin tunnistettava sana).

Lisäksi HillClimber luokassa hajautustaulu muutettiin pois luokan sisäisestä muuttujasta yksittäisen metodin muuttujaksi, sillä perkkäiset runToTheHills-metodin ajot aiheuttivat kummallisia (selkeästi vääriä) tuloksia (yhdelle kokeilusyötteelle), koska hajautustaulussa oli jo tavaraa, minkä vuoksi parempia vaihtoehtoja ei enää käyty läpi koska ne oli jo löydetty edellisillä ajoilla.

### Keskiviikko:

Työskentelyä salauksen murtamisen algoritmistamiseksi, erityisesti yritin miettiä miten ohjelma osaisi valita oikean avaimen pituuden Vigenère cipherin murtamisessa. Tähän liittyen laajennos greatest common divisor-luokkaan (voi olla että koko luokka jää käyttämättä, sillä ajatus etsiä avaimen pituutta löytämällä suurin yhteinen tekijä  sillä perusteella että index of coincidence arvot ovat korkeita kaikille avaimen pituuden monikerroille, ei toimikaan koska myös satunnaisesti myös muut kuin avaimen monikertaa vastaavat index of coincidence arvot voivat tuottaa suuria arvoja, mikä johtaa helposti suurimmaksi yhteiseksi tekijäksi 1:sen). 

Seuraava käyttöliittymän avulla tuotettu kuva toivottavasti selventää mitä yritän selittää: Eli tässä tapauksessa luku 7 ja sen monikerrat ovat selkeästi erotettavissa, mutta data voi helposti sisältää myös korkean index of coincidence arvon omaavan avainpituuden,joka ei ole jaollinen seitsemällä ja näin suurimman yhteisen tekijän käyttö kaatuu.


![Key data visualisation](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/example_key_data_visualization.png)


Tähän liittyen myös joitain yritelmiä ja tutkimusta siitä, miten monihuippuisesta datasta löydettäisiin kaikki relevantit huiput. Tässäkin ongelma on, että oikea avaimen pituus ei suinkaan anna suurinta index of coincidence arvoa, ja toisaalta sen antama arvo ei myöskään vaikuta olevan mitenkään erityisen sidottu tuon englannin kielen keskiarvon noin 1.70 ympäristöön luultavasti johtuen lyhyen tekstinpätkän poikkeamisesta suuurempien tekstien keskiarvoista. Esimerkiksi edellisen kuvan oikea avaimen pituus on 7, mutta kuten kuvasta huomataan muut seitsemän monikerrat tuottavat suurempia arvoja.

## Miten ohjelma on edistynyt

### Salauksen murtamisen havainnollistus 

Sivulta https://en.wikipedia.org/wiki/Mathematical_finance otettiin tekstinpätkä ja osin sivun http://rumkin.com/tools/cipher/manipulate.php työkalujen avulla poistettiin välit ja laitettiin kaikki lower caseksi (ja manuaalisesti pilkkujen poisto). Sitten edelleen sivun http://rumkin.com/tools/cipher/vigenere.php työkalun avulla se salattiin käyttäen avainsanaa "enigma" ja lopulta saatiing seuraava ciphertext:

    qnbnqmegqimljvvgzcintyakrbetmsuhitfixnbohejvvgzcivagriiyluratctoqdqnbnqmegqiecsakkdniqeofhqnbnqmegqimlqblkxirtwlrirnviuapzixwexfokzevntrkmegpkyaxvkgxfmaitoeavtrpevvdkmnhrfzqnhgpkyaxumsmtmpirarrhukdigntsadiyacutlbczzegraymrmygketeotoehmaogxirxburirnviuapgpkarcgiqunkbjyqrzrlsmrorbvdigrageircczyaxumsmtmpiroorfqyferpgoeridcodehawzooqcizubmyqzkwmgpkoorbuootlrwxktlhalarikisblijpoxeesqtmngvirqcsawsusxzqmttwgcjktlrazduggcxmlvriyanwjpemcszxgzyqngnmvinkkdtevvytavrxxucinnozarpqgxmegpkyaxvkomnqngzmkigpkeheemvdigriymgmimtmnhnbzqmtgbugsifbuohefbooceykaxuwgwuntevvztegbzxqstbvjunkiirgesslkdiznbohewbnztewgwiw

Seuraava gif havainnollistaa (osittain manuaalista) prosessia:

![Vigenere gif](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/vigenere_cracking.gif)


Eli käyttäjä syöttää ciphertextin, painaa nappia *Find possible key length* ja sitten avaa visualisoinnin mahdollisista avainpituuksista *Show associated values for key lengths* napilla ja huomaa, että avaimen pituus 6 erottuu selkästi ja päättää kokeilla avaimen löytämistä tällä avaimen pituudella, ja painaa *Find key*, jonka jälkeen avainkandidaatti ilmestyy pudotusvalikoihin. Lopuksi käyttäjä painaa nappia *Try decryption with this key*, jonka jälkeen mahdollinen plaintext ilmestyy ruutuun.

Tässä tapauksessa dekryptaus onnistui täydellisesti, koska valittu avaimen pituus 6 nyt sattui olemaan oikea (koska se oli looginen ensimmäinen valinta ja toisaalta itse tietysti tiesin että se on oikea) ja jokainen avaimen merkki oli selvästi pienin chi-squared arvoltaan joten avainkin oli heti oikein. Lopulta saatiin siis selkoteksti:

    mathematicalfinancealsoknownasquantitativefinanceisafieldofappliedmathematicsconcernedwithmathematicalmodelingoffinancialmarketsgenerallymathematicalfinancewillderiveandextendthemathematicalornumericalmodelswithoutnecessarilyestablishingalinktofinancialtheorytakingobservedmarketpricesasinputmathematicalconsistencyisrequirednotcompatibilitywitheconomictheorythusforexamplewhileafinancialeconomistmightstudythestructuralreasonswhyacompanymayhaveacertainsharepriceafinancialmathematicianmaytakethesharepriceasagivenandattempttousestochasticcalculustoobtainthecorrespondingvalueofderivativesofthestock
     
Eli kun tekstiin lisätään välit:
     
    mathematical finance also known as quantitative finance is a field of applied mathematics concerned with mathematical modeling of financial markets generally mathematical finance will derive and extend the mathematical or numerical models without necessarily establishing a link to financial theory taking observed market prices as input mathematical consistency is required not compatibility with economic theory thus for example while a financial economist might study the structural reasons why a company may havea certain share price a financial mathematician may take the share price as a given and attempt to use stochastic calculus to obtain the corresponding value of derivatives of the stock
    
Tämän esimerkin tarkoitus on siis havainnollistaa miten Vigenere salauksia voi yrittää murtaa ohjelman kautta, eikä niinkään väittää että salaus löydetään yhtä helposti ja vaivattomasti joka kerta.

## Mitä opin tällä viikolla


## Vaikeudet


## Kysymykset/Mikä jäi epäselväksi



## Mitä teen seuraavaksi


## Käytetty tuntimäärä

| päivä   | käytetty aika (h) | toimenpiteet |
| :----:|:--------| :----------|
| Viikko 6 |
| 25.8. | 6 | Käyttöliittymään lisätty kaikkien salausten perustoiminnallisuus ilman syötteentarkistusta (ja ilman tekstin manipulointityökalua, joka toivotavasti tulossa), samalla KeyedVigenereCipher refaktoroitiin siten että aakkostoavaimen voi muuttaa set-metodilla |
| 26.8. | 2 | Dokumentoinnin päivitys ja käyttöliittymässä alustavien ohjetekstien lisäys eri salauksille |
| 27.8. | 6 | Lehmer random number generaattorin luonti ja testit |
| 28.8. | 11 | Käyttöliittymään 1. versio murtamistoiminnallisuudesta, HillClimber luokan päivitys |
| 29.8. | ~ 5 | Vigenere cipherin murtamisen algoritmistamisten yritelmiä |
| 30.8. | 2 | Kuvien ja ohjelman toimintaa kaappaavan gifin lisäys dokumentaatioon tukemaan kommentointia |
| 31.8. | ? |  |


[Tuntikirjanpito](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/tuntikirjanpito.md)
