# Viikkoraportti 4

## Mitä olen tehnyt

### Maanantai:

Järjestysalgoritmien toteutusta Java Generics -tyylillä. Lisäysjärjestämis- ja iteratiivinen lomitusjärjestämisalgoritmi toteutettiin perusversiona (eli hyvin pitkälti juuri niinkuin TiRan luentomateriaalissa ne on esitetty sillä erotuksella, että ääretön arvoista SENTINELiä ei käytetä vaan lomitustaulukoiden indeksit tarkastetaan sen sijaan, koska tietämättä olioiden tyyppiä olisi ollut vaikea antaa mitää inf-arvoa niille.

### Keskiviikko:

IndexOfCoincidence luokalle testejä. Tässä apuna käytettiin useiden nettilähteiden (http://rumkin.com/tools/cipher/manipulate.php ja https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html) lisäksi taulukkolaskentaohjelmaa LibreOffice Calc ja samalla osa testisyötteiden luonnista dokumentoitiin tiedostoon [IC_test.xlsx](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/IC_test.xlsx). Dokumentin "sheetit" on suojattu ilman salasanaa tarkoituksena estää tulosten korruptoiminen vahingosssa.

LibreOffice Calcin avulla toistin samat laskutoimitukset mitä Java-ohjelman pitäisi tehdä keskimääräisiä IC-arvoja laskiessa eli loin suurella vaivalla testin metodille allAggregateDeltaBarICs, samalla loin apuluokan (mahdollisesti poistetaan ohjelmasta) jossa lähinnä dokumentoidaan koodi, jonka avulla tulostettiin eri pituiset ciphertextin "osajonot" eli subsequencet ja nämä sitten syötettiin taulukkolaskentaohjelmaan, joka muutti jokaisen merkin omaan soluunsa ja sitten siitä pystyi suhteellisella vaivalla ja copypasteamalla laskemaan testisyötearvoja. Kaikki testidatan laskut löytyvät tiedostosta [IC_test.xlsx](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/IC_test.xlsx)
 
### Torstai:

IndexOfCoinciden luokan testisyötteidein luonnin jatkamista edelleen käyttäen ja samalla dokumentoiden tiedostoon [IC_test.xlsx](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/IC_test.xlsx). Transposition ciphereiden murtamiseen tutustumista.

### Perjantai:

Transposition cipherin murtamiseen liittyviä toimia sivun http://practicalcryptography.com/cryptanalysis/stochastic-searching/cryptanalysis-columnar-transposition-cipher/ metodia noudattaen. Samalta sivulta on myös otettu data quadgramien esiintyvyydestä englanninkielisessä tekstissä. Tähän liittyen quadgram statistiikan laskennan aloittelua ja permutaatioden generointi.

## Miten ohjelma on edistynyt




## Mitä opin tällä viikolla

Miten luoda vähän esoteerisemmalla tavalla testejä. Transposition cipherin murtamisesta jonkin verran.


## Vaikeudet

IndexOfCoincidence luokan testisyötteiden luontia piti miettiä pitkään. Lopulta löysin edeskohtuullisessa ajassa toimivan menetelmän eli taulukkolaskentaohjelman avulla syötteiden luonti, mutta menetelmä vaati aika lailla manuaalista työtä varsinkin haastavampien testien osalta. Sinällään Excelin (ja siten myös avoimen lähdekoodin taulukkolaskentaohjelmien) käyttö tällaisessa datan manipuloinnissa oli minulle tuttua, mutta hiukan kömpelöksi syötteiden luonti jäi. 

## Kysymykset/Mikä jäi epäselväksi

Tällä hetkellä toteutettuna on Vigenere cipher ja sen varintit sekä Columnar transposition (Single ja Double transposition) ja lisäksi Vigenere-tyyppisten salauksen murtamiseen liittyvät pääalgoritmit ja transposition ciphereiden murtamiseen liittyvä työ on aloitettu. 

Koska jäljellä on enää kolme viikkoa niin en usko että merkittävässä määrin ohjelmaa enää ehtii laajentamaan, sillä murtamista pitää vielä hioa merkittävästi, käyttöliittymä luoda ja omien perustietorakenteiden luonti (hajautustaul) sekä lisäksi vielä kaiken dokumentointi ja testaus (toimivuus ja suorituskyky). 

Eli kysymys liittyy siihen, että mihin kannattaa keskittyä? Onko parempi syventyä siihen mitä on jo olemassa vai kenties lisätä salausrepertooria (jolloin työstä tulee selvästi pinnallisempi koska nämä salausalgoritmit ovat kuitenkin huomattavasti yksinkertaisempia kuin salauksen murtaminen)? Itse kallistun työn syventämisen puolelle.

Aikaa minulla on runsaasti käytössä koska en ole töissä ja ainoastaan yksi luentokurssi on samaan aikaan päällä seuraavat kaksi viikkoa (viimeisellä viikolla alkaa jo sitten 1. periodi jolloin tehokas työskentelyaika tulee luultavasti menemään siihen että työ viimeistellään palautuskuntoon), mutta toisaalta 2-3 viikkoa on lyhyt aika.

## Mitä teen seuraavaksi

* Murtamistoiminnallisuuden täydentäminen, eli yritys paketoida Vigenere cipherin murtamista kokonaisuudeksi käyttöliittymään ja transposition cipherin murtamisen algoritmien jatkotyöstämistä.

* Hajautustaulun toteutus.

* Käyttöliittymän aloittelu

## Käytetty tuntimäärä

[Tuntikirjanpito](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/tuntikirjanpito.md)
