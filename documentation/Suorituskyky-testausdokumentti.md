# CryptoApp suorituskyky-testausdokumentti

## Suorituskykytestauksen suunnitelma

Koska aihe on kryptografia, ja suuri osa salauksen murtamiseen liittyvistä menetelmistä ei ole täysin deterministinen, niin tarkoitus on keskittyä testauksessa siihen minkälaisia syötteitä todennäköisesti voidaan murtaa ja miten usein sekä kerätä tilastoja näihin liittyvistä avaimien ja salatekstien pituuksista.

Eli luodaan/on luotu tekstitiedosto (nyt kasassa noin 113 syötettä) jossa on eri pituisia selkotekstejä ja sitten nämä voidaan ohjelmallisesti luokitella eri pituuksien suhteen esim: 0-25, 26-50, 51-75 jne. Tarkoitus on myös saada suurinpiirtein yhtä paljon aineistoa joka luokitusväliin. 

Tämän tekemiseksi tehokkaasti on luotava/luotu koodia jonka avulla voidaan sitten helpommin varioida käytettävää salausavaimen pituutta (ja sisältöä) ja sitten vertaillaan miten murtaminen löytää oikean avaimen (tai ainakin lähes oikean avaimen).

Lisäksi yritys on vertailla hajautustaulun ylivuotolistojen pituuksia mieluiten hiukan erilaisilla aineistoilla (vaikka tässä työssä tosin hajautustaulujen input on melkeinpä muuttumaton).

## Testiaineiston luonti

Testiaineistoa on kerätty kopioimalla mielivaltaisia tekstinpätkiä wikipediasta ja  [Project Gutenbergin](http://www.gutenberg.org/wiki/Harvard_Classics_(Bookshelf)) tarjoamista kirjoista. On myös yritetty ottaa tekstiä eri tyyppisiltä alueilta: Esim Crime and Punishment, Meditations, Prince jne ja wikipediasta rando tiede-, urheilu ja historiatekstinpätkiä. Kuitenkin tämä on yllättävä hidasta, ellen sitten päätä vain kopioida suurta tekstinpätkää ja sitten katkaise sitä pienemmiksi paloiksi. Yksi mahdollisuus olisi löytää jotain valmiita aineistoja, mutta tämä voi olla vaikeaa.  
