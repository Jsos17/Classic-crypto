# CryptoApp oikeellisuuden testausdokumentti

Tämä dokumentti käsittelee ohjelman oikeellisuuden testausta eli että metodit ja algoritmit toimivat oikein. Suorituskykytestaus on eriytetty [erilliseen dokumenttiin](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Suorituskyky-testausdokumentti.md).

## Testikattavuus

![Testikattavuus](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/testikattavuus_final.png)

Testikattavuus on hyvin lähelle 100 % joitain rajatapauksia lähinnä Hajautustaulutoteutuksiin liittyen. Lisäksi kuten aiemmin on todettu, LehmerRandomNumberGeneratorissa on hyvin vaikea testata tilannetta, että koneen kello antaa ajaksi sellaisen luvun joka on jaollinen moduluksella, ja tällöin seed asetetaan erikseen luvuksi 1.

## Mitä on testattu

Metodien oikeellisutta on pyritty testaamaan luomalla paljon erilaisia syötteitä ja paikoin satunnaistamalla näitä syötteitä. Osalla metodeista ei ole kuin yksi suuri testi johtuen testisyötteiden luonnin työläydestä (lähinnä koskee IndexOfCoincidence luokkaa).

## Miten on testattu

Pyrkimys on ollut testata omasta koodista/ohjelmoinnista riippumattomasti niin paljon kuin mahdollista, eli jos on helposti saatavilla esimerkiksi jokin web app, joka tekee samanlaisia asioita niin tätä on pyritty hyödyntämään. Lisäksi taulukkolaskentaohjelma LibreOffice Calc nousi merkittäväksi apuvälineeksi IndexOfCoincidence -luokan testauksessa kun useat sen metodit tekivät raskaita mutta kuitenkin suhteellisen mekaanisia laskuoperaatioita ja lisäksi taulukkolaskentaohjelman avulla on helppo järjestää aineistoa.

Eritysesti tiedostoon [IC_test.xlsx](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/IC_test.xlsx) on dokumentoitu testidataa ja laskutoimituksia sekä niiden tuloksia moniin luokan IndexOfCoincidence metodeihin liittyen. Monet tiedoston välilehdistä (sheet) on nimetty siten mihin testiin ne liittyvät. Tiedoston välilehdet on suojatttu ilman salasanaa, jotta vältyttäisiin datan korruptoitumiselta, eli tarvittaessa salauksen poisto onnistuu valitsemalla Tools -> Protect sheet LibreOffice Calcista. Tämä ei kuitenkaan ole välttämättä tarpeen sillä kaikki formulat ovat näkyvissä.

Muutamassa tapauksessa testiluokkien sisällä on jokin apumetodi, joka auttaa luomaan testisyötteitä. Esimerkiksi VigenereCipherTest luokassa on randomizeInPlace, jonka avulla voidaan tuottaa pseudosatunnaisia salatekstejä.

CombinatoricsTest luokassa taas on metodi joka on lähes sama kuin Tietorakenteet ja algoritmit luentomateriaalissa oleva generate(table, used, k) sillä erotuksella, että permutaatiota ei tulosteta vaan se tallennetaan taulukkoon. Tämän metodin tarkoitus on auttaa tuottamaan suurempi testisyöte erilaiselle versiolle tästä metodista. 
 
## Testien toistaminen

Testit voi ajaa CryptoApp kansiossa ollessa kometoriviltä komennolla:

    mvn test

## Erityisen raskaat testit

TranspositionAttackTest luokan testit vievät huomattavasti enemmän aikaa kuin valtaosa muista testeistä yhteensä. Tämä johtuu siitä, että jokainen testin metodi generoi permutaatioita
