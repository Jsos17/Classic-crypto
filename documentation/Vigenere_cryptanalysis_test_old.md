# Vanha Vigenere salauksen murtamisen testi

### Alustavia testejä Vigenere salauksen murtamiseen

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
