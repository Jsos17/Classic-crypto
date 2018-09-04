# CryptoApp suorituskyky-testausdokumentti

## Suorituskykytestauksen suunnitelma

Koska aihe on kryptografia, ja suuri osa salauksen murtamiseen liittyvistä menetelmistä ei ole täysin deterministinen, niin tarkoitus on keskittyä testauksessa siihen minkälaisia syötteitä todennäköisesti voidaan murtaa ja miten usein sekä kerätä tilastoja näihin liittyvistä avaimien ja salatekstien pituuksista.

Eli luodaan/on luotu tekstitiedosto (nyt kasassa noin 113 syötettä) jossa on eri pituisia selkotekstejä ja sitten nämä voidaan ohjelmallisesti luokitella eri pituuksien suhteen esim: 0-25, 26-50, 51-75 jne. Tarkoitus on myös saada suurinpiirtein yhtä paljon aineistoa joka luokitusväliin. 

Tämän tekemiseksi tehokkaasti on luotava/luotu koodia jonka avulla voidaan sitten helpommin varioida käytettävää salausavaimen pituutta (ja sisältöä) ja sitten vertaillaan miten murtaminen löytää oikean avaimen (tai ainakin lähes oikean avaimen).

Lisäksi yritys on vertailla hajautustaulun ylivuotolistojen pituuksia mieluiten hiukan erilaisilla aineistoilla (vaikka tässä työssä tosin hajautustaulujen input on melkeinpä muuttumaton).

## Vigenere salauksen murtamisen tehokkuus tilastollisella chi-squared menetelmällä

Toteutettua Vigenere salauksen murtamista testattiin keräämällä 501 eri pituista plaintextiä ja sitten salaamalla ne eri avaimien pituuksilla. Testiaineistot luokiteltiin seuraavasti:

| Selkotekstin/salatatekstin pituusluokka | Pituuksien keskiarvo luokan sisällä | Määrä |
| :----:|:-----|:----------|
| 1-50 | 37,1 | 71 |
| 51-100 | 75,9 | 71 |
| 101-150 | 124,2 | 93 |
| 151-200 | 173,1 | 64 |
| 201-250 | 225,3 | 45 |
| 251-300 | 274,9 | 49 |
| 301-350 | 328,6 | 35 |
| 351-400 | 379,3 | 34 |
| 401-500 | 442,8 | 39 |
| Yhteensä | | 501 |

Tämän jälkeen käsitellyt selkotekstit salattiin avainpituuksilla 1-14 ja joka kerralla testattiin kuinka monta oikeaa avainta menetelmä löytää, sillä oletuksella että avaimen pituus tiedetään jo. Avaimen pituuden tietämysolettama on vähintään kohtuullinen  sillä index of coincidence arvot paljastavat yleensä hyvin selkeästi avainkandidaatit, joista pienin on looginen aloituskohta.
Tässä testatuksessa kerättiin vain täsmälleen oikeat vastaukset, eikä esimerkiksi yhdellä kirjaimella pielessä olevia avaimia otettu huomioon.

| Luokitteluväli | | 1-50 | 51-100 | 101-150 | 151-200 | 201-250 | 251-300 | 301-350 | 351-400 | 401-500 |
| :----:|:-----|:----------|:----------|:-------|:--------|:--------|:--------|:--------|:--------|:--------|
| Salatekstejä luokassa | | 71 | 71 | 93 | 64 | 45 | 49 | 35 | 34 | 39 |
| Avain | Avaimen pituus | Oikeita avaimia |
| datastructures | 14  |  |  |  |  |  |  |  |  |  |
| footballplayer | 14  |  |  |  |  |  |  |  |  |  |
| decompensated | 13  |  |  |  |  |  |  |  |  |  |
| hazardousness | 13  |  |  |  |  |  |  |  |  |  |
| eavesdropper | 12  |  |  |  |  |  |  |  |  |  |
| magnetically | 12  |  |  |  |  |  |  |  |  |  |
| unbreakable | 11  |  |  |  |  |  |  |  |  |  |
| identically | 11  |  |  |  |  |  |  |  |  |  |
| calculator | 10  |  |  |  |  |  |  |  |  |  |
| academical | 10  |  |  |  |  |  |  |  |  |  |
| pacifists | 9  |  |  |  |  |  |  |  |  |  |
| waistcoat | 9  |  |  |  |  |  |  |  |  |  |
| gangster | 8  |  |  |  |  |  |  |  |  |  |
| radiance | 8  |  |  |  |  |  |  |  |  |  |
| tactics | 7  |  |  |  |  |  |  |  |  |  |
| factory | 7  |  |  |  |  |  |  |  |  |  |
| habits | 6  |  |  |  |  |  |  |  |  |  |
| easily | 6  |  |  |  |  |  |  |  |  |  |
| mafia | 5  |  |  |  |  |  |  |  |  |  |
| toxic | 5  |  |  |  |  |  |  |  |  |  |
| beef | 4  |  |  |  |  |  |  |  |  |  |
| life | 4  |  |  |  |  |  |  |  |  |  |
| six | 3  |  |  |  |  |  |  |  |  |  |
| ego | 3  |  |  |  |  |  |  |  |  |  |
| do | 2  |  |  |  |  |  |  |  |  |  |
| my | 2  |  |  |  |  |  |  |  |  |  |
| z | 1  |  |  |  |  |  |  |  |  |  |
| a | 1  |  |  |  |  |  |  |  |  |  |

## Alustavia testejä Vigenere salauksen murtamiseen

[Alkuperäiset plaintextit](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/unmanipulated_sample_plaintexts.txt) ja [manipuloidut tekstinpätkät](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/sample_plaintexts.txt)

Eli edellisten tiedostojen perusteella luotiin salatekstejä Vigenere salauksella käyttäen avainpituuksia 1-8 ja laskettiin kuinka moni IndexOfCoincidence luokan findKey-metodin tuottamista avaimista oli oikein (kun tehtiin vielä lisäoletus että avaimenpituus on juuri oikea). Lisäksi kirjattiin "melkein oikein" tapaukset eli joissa saatu avain poikkesi täsmälleen yhdellä kirjaimella.


| Avain | Avaimen pituus | Oikeita avaimia | Melkein oikeita avaimia | Yhteensä salatekstejä |
| :----:|:-----|:----------|:----------|:----------|
| inventor | 8 | 8 | 9 | 113 |
| derivate | 8 | 8 | 9 | 113 |
| kryptos | 7 | 14 | 14 | 113 |
| compute | 7 | 14 | 14 | 113 |
| enigma | 6 | 17 | 24 | 113 |
| cipher | 6 | 17 | 24 | 113 |
| lemon | 5 | 31 | 26 | 113 |
| money | 5 | 31 | 26 | 113 |
| king | 4 | 43 | 48 | 113 |
| here | 4 | 43 | 48 | 113 |
| key | 3 | 77 | 26 | 113 |
| gun | 3 | 77 | 26 | 113 |
| me | 2 | 97 | (15) | 113 |
| hi | 2 | 97 | (15) | 113 |
| a | 1 | 111 | (**2 !!!!**) | 113 |
| l | 1 | 111 | (2) | 113 |

Salatekstin keskimääräinen pituus: 65,9 merkkiä, (otos) keskihajonta: 82,1

Lyhin tekstin pituus oli 16 ja pisin 710 merkkiä eli testidata ei ollut kovin tasaista pituuksiltaan sillä se sisälsit muutamia suhteellisen pitkiä tekstejä ja toisaalta suhteellisen paljon melko lyhyehköjä salatekstejä. Tulevissa testeissä on tarkoitus luokitella tekstit suurinpiirtein samalla pituustasolla olevin luokkiin.

Huomattavaa on että pelkällä kirjaimella a salaaminen ei tee selkotekstille mitään ja silti saadaan kaksi väärä avainta! Lisäksi avaimien pituuksien 2 ja 1 kohdalle melkein oikein suluissa koska "melkein oikein" ei oikeastaan tarkoita enää mitään noin lyhyiden avaimien kohdalla.

Ensimmäiseksi, huomataan että sama avainpituus tuottaa täsämälleen samanlaista dataa riippumatta itse avaimen sisällöstä (tämä näytti toistuvan myös muilla avaimilla). Toiseksi huomataan kasvava trendi avaimen pituuden lyhentyessä salatekstin pituuden suhteen (joka säilyy vakiona).


## Testiaineiston luonti

Testiaineistoa on kerätty kopioimalla mielivaltaisia tekstinpätkiä wikipediasta ja  [Project Gutenbergin](http://www.gutenberg.org/wiki/Harvard_Classics_(Bookshelf)) tarjoamista kirjoista. On myös yritetty ottaa tekstiä eri tyyppisiltä alueilta: Esim Crime and Punishment, Meditations, Prince jne ja wikipediasta tiede-, urheilu ja historiatekstinpätkiä. Kuitenkin tämä on yllättävä hidasta, ellen sitten päätä vain kopioida suurta tekstinpätkää ja sitten katkaise sitä pienemmiksi paloiksi. Yksi mahdollisuus olisi löytää jotain valmiita aineistoja, mutta tämä voi olla vaikeaa.  
