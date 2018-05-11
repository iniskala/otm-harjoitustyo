# Testausdokumentti

Ohjemaa on testattu sekä automatisoiduilla yksikkö- integraatiotesteillä JUnitilla, sekä manuaalisesti tapahtunein järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Automatisoidut testit testaavat pääosin Generator- ja Finder luokkaa, jotka tarvitsevat muita luokkia toimiakseen, jolloin muut luokat tulevat mukaan testiin.

Luokille Participant tehtiin yksikkötesti kattamaan tapaukset, joita muut testit eivät kata.

### Testauskattavuus

Käyttöliittymää luovaa luokkaa lukuunottamatta sovelluksen testauksen rivikattavuus on 92% ja haaraumakattavuus 80%. Luvut vaihtelevat hiukan, koska Generator luokassa on sattumanvarainen muuttuja, jolloin testin tulos vaihtuu hieman. Kaikki toiminnallisuudet toimivat kuitenkin.

## Järjestelmätestaus

Sovelluksen järjestelmä testaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellusta on testattu ainoastaan windows ympäristössä käyttöohjeen mukaisesti. Tekniset ongelmat estivät sovelluksen testauksen Linux - ympäristössä (Yliopiston kotihakemistossa ei voinut käyttää gittiä puuttuvien oikeuksien takia.).

### Toiminnallisuudet

Sovellus toteuttaa määrittely dokumentissa olevat toiminnallisuudet ja ne ovat testattu. Virheellisiä arvoja on mahdollista syöttää, tosin se ei vaikuta sovelluksen toimintaan vaan aiheuttaa vääriä nimiä istumajärjestykseen, jolloin käyttäjä ei välttämättä saa haluamaansa istumajärjestystä.

## Sovellukseen jääneet laatuongelmat

Sovellus tallentaa istumajärjestyksen samalla nimellä jolloin on mahdollista vahingossa poistaa jo tehty istumajärjestys.
