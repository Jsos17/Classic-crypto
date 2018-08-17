# CryptoApp testausdokumentti

## Mitä on testattu



## Miten on testattu

Pyrkimys on ollut testata omasta koodista/ohjelmoinnista riippumattomasti niin paljon kuin mahdollista, eli jos helposti saatavilla on esimerkiksi jokin webapp, joka tekee samanlaisia asioita niin tätä on pyritty hyödyntämään. Lisäksi taulukkolaskentaohjelma LibreOffice Calc nousi merkittäväksi apuvälineeksi IndexOfCoincidence -luokan testauksessa kun useat sen metodit tekivät raskaita mutta kuitenkin suhteellisen mekaanisia laskuoperaatioita ja lisäksi taulukkolaskentaohjelman avulla on helppo järjestää aineistoa.

Muutamassa tapauksessa testiluokkien sisällä on jokin apumetodi, joka auttaa luomaan testisyötteitä. Esimerkiksi VigenereCipherTest luokassa on randomizeInPlace, jonka avulla voidaan tuottaa pseudosatunnaisia salatekstejä.

CombinatoricsTest luokassa taas on metodi joka on lähes sama kuin Tietorakenteet ja algoritmit luentomateriaalissa oleva generate(table, used, k) sillä erotuksella, että permutaatiota ei tulosteta vaan se tallennetaan taulukkoon. Tämän metodin tarkoitus on auttaa tuottamaan suurempi testisyöte hiukan paremmalle versiolle tästä metodista. 
 
## Testien toistaminen


## Suorituskykytestauksen suunnitelma

Koska aihe on kryptografia, ja suuri osa salauksen murtamiseen liittyvistä menetelmistä ei ole täysin deterministinen, niin tarkoitus on keskittyä testauksessa siihen minkälaisia syötteitä todennäköisesti voidaan murtaa.

Tätä testausta tuetaan myös perinteisellä tehokkuusmittauksilla, mutta pääpaino tullee olemaan siinä mitä voidaan murtaa ja tilastojen keräämistä tästä.

## Erityisen raskaat testit

TranspositionAttackTest luokassa on tällä hetkellä vain neljä testiä, mutta silti tämä testi vie noin 3-4 kertaa pitempään kuin muut 163 testiä yhteensä. Tämä johtuu siitä, että jokainen testin metodi generoi permutaatioita.
