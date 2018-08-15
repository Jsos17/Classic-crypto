# Viikkoraportti 4

## Mitä olen tehnyt

### Maanantai:

Järjestysalgoritmien toteutusta Java Generics -tyylillä. Lisäysjärjestämis- ja iteratiivinen lomitusjärjestämisalgoritmi toteutettiin perusversiona (eli hyvin pitkälti juuri niinkuin TiRan luentomateriaalissa ne on esitetty sillä erotuksella, että ääretön arvoista SENTINELiä ei käytetä vaan lomitustaulukoiden indeksit tarkastetaan sen sijaan.

### Keskiviikko:

IndexOfCoincidence luokalle testejä. Tässä apuna käytettiin useiden nettilähteiden (http://rumkin.com/tools/cipher/manipulate.php ja https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html) lisäksi taulukkolaskentaohjelmaa LibreOffice Calc ja samalla osa testisyötteiden luonnista dokumentoitiin tiedostoon [IC_test.xlsx](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/IC_test.xlsx). Dokumentin "sheetit" on suojattu ilman salasanaa tarkoituksena estää tulosten korruptoiminen vahingosssa.

LibreOffice Calcin avulla toistin samat laskutoimitukset mitä Java-ohjelman pitäisi tehdä keskimääräisiä IC-arvoja laskiessa eli loin suurella vaivalla testin metodille allAggregateDeltaBarICs, samalla loin apuluokan testipakkaukseen jossa lähinnä dokumentoidaan koodi, jonka avulla tulostettiin kaikki eri pituiset ciphertextin "osajonot" eli subsequencet ja nämä sitten syötettiin taulukkolaskentaohjelmaan, joka muutti jokaisen merkin omaan soluunsa ja sitten siitä pystyi suhteellisella vaivalla ja copypasteamalla laskemaan testisyötearvoja.
 
 ### Torstai:
 

## Miten ohjelma on edistynyt


## Mitä opin tällä viikolla



## Vaikeudet


## Kysymykset/Mikä jäi epäselväksi

.

## Mitä teen seuraavaksi


## Käytetty tuntimäärä


[Tuntikirjanpito](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/tuntikirjanpito.md)
