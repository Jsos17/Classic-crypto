# CryptoApp oikeellisuus testausdokumentti (kesken)

## Mitä on testattu

Metodien oikeellisutta on pyritty testaamaan luomalla paljon erilaisia syötteitä ja paikoin satunnaistamalla näitä syötteitä. Osalla metodeista ei ole vielä kuin yksi suuri testi johtuen testisyötteiden luonnin työläydestä (lähinnä koskee IndexOfCoincidence luokkaa).

## Miten on testattu

Pyrkimys on ollut testata omasta koodista/ohjelmoinnista riippumattomasti niin paljon kuin mahdollista, eli jos on helposti saatavilla esimerkiksi jokin webapp, joka tekee samanlaisia asioita niin tätä on pyritty hyödyntämään. Lisäksi taulukkolaskentaohjelma LibreOffice Calc nousi merkittäväksi apuvälineeksi IndexOfCoincidence -luokan testauksessa kun useat sen metodit tekivät raskaita mutta kuitenkin suhteellisen mekaanisia laskuoperaatioita ja lisäksi taulukkolaskentaohjelman avulla on helppo järjestää aineistoa.

Eritysesti tiedostoon [IC_test.xlsx](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/IC_test.xlsx) on dokumentoitu testidataa ja laskutoimituksia sekä niiden tuloksia moniin luokan IndexOfCoincidence metodeihin liittyen. Monet tiedoston välilehdistä (sheet) on nimetty siten mihin testiin ne liittyvät. Tiedoston välilehdet on suojatttu ilman salasanaa, jotta vältyttäisiin datan korruptoitumiselta, eli tarvittaessa salauksen poisto onnistuu valitsemalla Tools -> Protect sheet LibreOffice Calcista. Tämä ei kuitenkaan ole välttämättä tarpeen sillä kaikki formulat ovat näkyvissä.

Muutamassa tapauksessa testiluokkien sisällä on jokin apumetodi, joka auttaa luomaan testisyötteitä. Esimerkiksi VigenereCipherTest luokassa on randomizeInPlace, jonka avulla voidaan tuottaa pseudosatunnaisia salatekstejä.

CombinatoricsTest luokassa taas on metodi joka on lähes sama kuin Tietorakenteet ja algoritmit luentomateriaalissa oleva generate(table, used, k) sillä erotuksella, että permutaatiota ei tulosteta vaan se tallennetaan taulukkoon. Tämän metodin tarkoitus on auttaa tuottamaan suurempi testisyöte hiukan paremmalle versiolle tästä metodista. 
 
## Testien toistaminen


## Erityisen raskaat testit

TranspositionAttackTest luokassa on tällä hetkellä vain neljä testiä, mutta silti tämä testi vie noin 3-4 kertaa pitempään kuin muut 163 testiä yhteensä. Tämä johtuu siitä, että jokainen testin metodi generoi permutaatioita.
