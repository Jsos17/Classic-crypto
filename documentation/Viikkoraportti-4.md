# Viikkoraportti 4

## Mitä olen tehnyt

### Maanantai:

Järjestysalgoritmien toteutusta Java Generics -tyylillä. Lisäysjärjestämis- ja iteratiivinen lomitusjärjestämisalgoritmi toteutettiin perusversiona (eli hyvin pitkälti juuri niinkuin TiRan luentomateriaalissa ne on esitetty sillä erotuksella, että ääretön arvoista SENTINELiä ei käytetä vaan lomitustaulukoiden indeksit tarkastetaan sen sijaan, koska tietämättä olioiden tyyppiä olisi ollut vaikea antaa mitää inf-arvoa niille.

### Keskiviikko:

IndexOfCoincidence luokalle testejä. Tässä apuna käytettiin useiden nettilähteiden (http://rumkin.com/tools/cipher/manipulate.php ja https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html) lisäksi taulukkolaskentaohjelmaa LibreOffice Calc ja samalla osa testisyötteiden luonnista dokumentoitiin tiedostoon [IC_test.xlsx](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/IC_test.xlsx). Dokumentin "sheetit" on suojattu ilman salasanaa tarkoituksena estää tulosten korruptoiminen vahingosssa.

LibreOffice Calcin avulla toistin samat laskutoimitukset mitä Java-ohjelman pitäisi tehdä keskimääräisiä IC-arvoja laskiessa eli loin testin metodille allAggregateDeltaBarICs ja samalla loin apuluokan [SubSequencePrinter.java](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/SubSequencePrinter.java) pelkkää testausta varten (tiedosto on dokumentaation seassa, ei ohjelmakoodissa koska sitä ei käytetä ohjelmassa).

Tämä ohjelma on modifioitu versio subSequences metodista luokasta IndexOfCoincidence (ja joka on testattu), ja jonka avulla lähinnä tulostettiin eri pituiset ciphertextin "osajonot" eli subsequencet ja nämä sitten syötettiin taulukkolaskentaohjelmaan, joka muutti jokaisen merkin omaan soluunsa ja sitten siitä pystyi suhteellisella vaivalla laskemaan testisyötearvoja. Kaikki testidatan laskut löytyvät tiedostosta [IC_test.xlsx](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/IC_test.xlsx)
 
### Torstai:

IndexOfCoinciden luokan testisyötteidein luonnin jatkamista edelleen käyttäen ja samalla dokumentoiden tiedostoon [IC_test.xlsx](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/IC_test.xlsx). Transposition ciphereiden murtamiseen tutustumista.

### Perjantai:

Transposition cipherin murtamiseen liittyviä toimia sivun http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-columnar-transposition-cipher/ menetelmää noudattaen. Samalta sivulta on myös otettu data mono-, bi-, tri- ja quadgramien esiintyvyydestä englanninkielisessä tekstissä. Tähän liittyen quadgram statistiikan laskennan aloittelua ja permutaatioden generointi. Hyvin alustava testaus on lupaava, eli menetelmä murtaa tekstejä jotka ovat suhteellisien pitkiä ja joiden salausavain on lyhyt (1-9 merkkiä). 

## Miten ohjelma on edistynyt

Koko IndexOfCoincidence luokka on nyt testattub(viime viikolla se oli täysin testaamaton), tosin joissain tapauksissa on olemassa vain yksi testi (esim. findKey) metodille johtuen testiaineiston/syötteen luomisen haastavuudesta/raskaudesta. Näitä testejä tullaan lisäämään, mutta toisaalta nämä metodit ovat hyvin suoraviivaisia siinä mielessä, että haaraautumisia ei juuri ole ja lähinnä summataan, kerrotaan ja jaetaan lukuja.

Transposition cipherin murtaminen on aloitettu lyhyiden avaimien osalta generoiden permutaatioita merkkien järjestyksestä ja sitten laskien tilastollisia tunnuslukuja kokeilu-dekryptauksista.

Testikattavuus on nimellisesti taas korkea kautta linjan, mutta kuten aiemmin on todettiin joidenkin metodien kohdalla on olemassa vain yksi kunnollinen testi, joka testaa metodin oikeellisuutta. Tätä pyritään luonnollisesti parantamaan. TransposionAttack luokan kyky löytää selkoteksti on myöskin riippuvainen ainakin tekstin pituudesta ja siten testit eivät vielä kerro muuta kuin että joissain tapauksissa menetelmä toimii.

![Testikattavuus vko 4](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/testikattavuus_vko_4.png)

## Mitä opin tällä viikolla

Miten luoda vähän esoteerisemmalla tavalla testejä. Toisaalta kaiken lasketun datan näkeminen omin silmin taulukkolaskentaohjelmasta oli hyödyllistä tämän salauksen murtamismenetelmän ymmärtämisen kannalta. Lisäksi opin transposition cipherin murtamisesta paljon.

## Vaikeudet

IndexOfCoincidence luokan testisyötteiden luontia piti miettiä pitkään. Lopulta löysin jotakuinkin kohtuullisessa ajassa suoritettavan menetelmän eli taulukkolaskentaohjelman avulla syötteiden luonnin, mutta menetelmä vaati aika lailla manuaalista työtä varsinkin haastavampien testien osalta. Sinällään Excelin (ja siten yleisesti taulukkolaskentaohjelmien) käyttö tällaisessa datan manipuloinnissa oli minulle tuttua, mutta hiukan kömpelöksi syötteiden luonti vielä jäi. Toisaalta jo testeä luodessa huomasin tapoja nopeuttaa prosessia. 

Erityisesti tuo IndexOfCoincidence luokan findKey-metodin testaus oli hyvin haastavaa koska se palauttaa kaksiulotteisen taulukon, ja huomattavat määrät laskentaa tehdään metodin sisällä, lisäksi osajonojen generoinnnissa käytin lopulta omaa ohjelmaa (jota oli siinä vaiheessa jo testattu) vaikka mieluiten toteuttaisin kaikki testit omasta koodista riippumattomasti.

## Kysymykset/Mikä jäi epäselväksi

Koska jäljellä on enää kolme viikkoa niin en usko että merkittävässä määrin ohjelmaa enää ehtii laajentamaan, sillä murtamista pitää vielä hioa merkittävästi, käyttöliittymä luoda ja omien perustietorakenteiden luonti (hajautustaul) sekä lisäksi vielä kaiken dokumentointi ja testaus (toimivuus ja suorituskyky). 

Eli **ensimmäinen kysymys** liittyy siihen, että mihin kannattaa keskittyä? Onko parempi syventyä siihen mitä on jo olemassa ja parantaa sitä vai kenties lisätä salausrepertooria (jolloin työstä tulee selvästi pinnallisempi koska nämä salausalgoritmit ovat kuitenkin huomattavasti yksinkertaisempia kuin salauksen murtaminen)? Itse kallistun työn syventämisen puolelle.

Aikaa minulla on runsaasti käytössä koska en ole töissä ja ainoastaan yksi luentokurssi on samaan aikaan päällä seuraavat kaksi viikkoa (viimeisellä viikolla alkaa jo sitten 1. periodi jolloin tehokas työskentelyaika tullee luultavasti menemään siihen että työ viimeistellään palautuskuntoon), mutta toisaalta 2-3 viikkoa on lyhyt aika.

**Toinen kysymys**, on se pitääkö [SubSequencePrinter.java](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/SubSequencePrinter.java) kaltainen ohjelmapätkä sisällyttää dokumentaation? Mielestäni se ei ainakaan ohjelmakoodiin kuulu, koska se on ollut vain apuvälineenä merkkijonon tiettyjen osajonojen tuottamisessa ja sitä kautta testisyötteiden luonnissa. 

## Mitä teen seuraavaksi

* Murtamistoiminnallisuuden täydentäminen, eli yritys paketoida Vigenere cipherin murtamista kokonaisuudeksi käyttöliittymään ja transposition cipherin murtamisen algoritmien jatkotyöstämistä.

* Permutaatioiden generoimisen optimoiminen mahdollisesti tallentamalla osatuloksia, koska aina tuotetaan samat permutaatiot ja niitä tuotetaan korkeintaan 9:lle elementille

* Hajautustaulun toteutus.

* Käyttöliittymän aloittelu

## Käytetty tuntimäärä

| päivä   | käytetty aika (h) | toimenpiteet |
| :----:|:--------| :----------|
| Viikko 4 |
| 13.8. | 8 | Geneerinen merge sort 1. versio, geneerinen insertion sort sekä  näille + primitiivityyppi järjestysalgoille testejä, yleistä testikattavuuden parantamista, yleistä tutkimusta |
| 15.8. | 8 | Testikattavuuden kasvattamista erityisesti IndexOfCoincidence luokalle ja samalla yhden virheen korjaus, testejä varten tiedoston IC_test.xlsx luonti, jonka avulla lasketaan testisyötteitä ja johon dokumentoidaan myös testejä |
| 16.8. | 9 | Testien luonnin jatkoa, työmäärältään hyvin massiivisen testin luonti IndexOfCoincidence-luokalle taulukkolaskentaohjelman avulla ja jo testattujen oman ohjelman funktioiden avulla (osajonojen tulostus ja osajonon dekryptaus jokaisella aakkosella), Perehtymistä Transposition cipherin murtamiseen |
| 17.8. | 15 | Transposition cipherin murtaminen lyhyillä avaimilla käyden läpi kaikki avaimen kirjainten järjestysten permutaatiot läpi, quad-, tri, bi ja monogram statistiikan laskeminen tekstitiedostossa olevan datan perusteella, permutaatioiden generointi, kaikille näille testejä. Dokumentaation päivittämistä |

[Tuntikirjanpito](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/tuntikirjanpito.md)
