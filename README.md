Sitsiplassaaja

Sovelluksen avulla voidaan generoida istumajärjestys sitseille. Ohjelmaan syötetään sitsaajan tiedot
ja ne tallentaan tietokantaan. Tietokannasta voidaan generoida sattumanvarainen istumajärjestys, joka
ottaa huomioon sitsaajan tiedot.

Dokumentaatio

[Vaatimusmäärittely](https://github.com/iniskala/otm-harjoitustyo/blob/master/harjoitustyo/seatinggenerator/Dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely.md)

[Työaikakirjanpito](https://github.com/iniskala/otm-harjoitustyo/blob/master/harjoitustyo/seatinggenerator/Dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/iniskala/otm-harjoitustyo/blob/master/harjoitustyo/seatinggenerator/Dokumentaatio/Arkkitehtuuri.md)

[Julkaisu](https://github.com/iniskala/otm-harjoitustyo/releases/tag/Viikko5)

Komentorivitoiminnot

Testaus

Testit voidaan suoritttaa komenolla

mvn test

Testikattavuusraportti voidaan luoda komennolla

mvn jacoco:report

Luotu kattavuus raportti löytyy repositoriosta target/site/jacoco/index.html sen voi avata selaimella.

Suoritettavan jarin generointi

tapahtuu komennolla

mvn package

Checkstyle

Tiedostoon checkstyle.xml määritellyt tarkistukset vidaan suorittaa komennolla.

mvn jxr:jxr checkstyle:checkstyle

Mahdolliset virheet voidaan katsoa tiedostosta target/site/checkstyle.html ja se voidaan avata selaimella.
