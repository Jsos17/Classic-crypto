# Käyttöohje

## Ohjelman hyväksymät syötteet

Kaikille Vigenere ciphereille pitää syöttää lowercase tekstiä joka sisältää vain standardi latinankielisen aakkoston 26 kirjainta abcdefghijklmnopqrstuvwxyz. Jos teksti sisältää väleja, erikoismerkkejä jne niin salauksen tulos ei välttämättä ole onnistunut. Transposition cipher salauksille voi syöttää vapaamuotoista tekstiä joka sisältää myös isoja kirjaimai, välejä jne.

Salauksen murtamistoiminnallisuudessa syötetyn tekstin pitää olla yhdessä pötkössä käyttäen vain standardi latinankielisen aakkoston 26 kirjainta abcdefghijklmnopqrstuvwxyz. Tämä pätee sekä Vigenere cipherin murtamistoiminnallisuudessa että Transpositions cipherin murtamistoiminnallisuudessa.

Salauksen murtamiseen ohjeistava gif löytyyy [viikon 6 raportista](https://github.com/Jsos17/Classic-crypto/blob/master/documentation/Viikkoraportti-6.md) (ulkoasu on hiukan muuttunut mutta ei paljon).

Avaimien sisältöön on ohjelmassa erittäin hyvä ohje ohjelmassa.

Jos tekstiä copypastetaan, niin kannattaa kiinnittää huomiota että rivinvaihtoja ei copypastea mukana tai lisävälilyöntejä sillä tällöin eri toiminnallisuudet eivät luultavasti toimi oikein.

## Testiluokat

Testit löytyvät kansiosta 

    CryptoApp/rc/test/java/crypto
    
josta valitaan halutun pakkauksen testit.

## Jar

Jar löytyy CryptoApp/target kansiosta.
