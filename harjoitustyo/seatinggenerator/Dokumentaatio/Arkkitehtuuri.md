# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne on kolmitasoinen kerrosarkkitehtuuri ja sen rakenne näkyy seuraavassa kaaviossa:

<img src="https://github.com/iniskala/otm-harjoitustyo/blob/master/harjoitustyo/seatinggenerator/Dokumentaatio/Otm.png" width="800">

Ui sisältää käyttöliittymän, joka on tehty javaFX:llän avulla, database sisältää tietojen tallenuksesta vastaavan koodin, lukuunottamatta istumajärjestyksen kirjoittavaa koodia, ja generatoretc pakkaus sisältää sovelluslogiikan.

## Käyttöliittymä

Käyttöliittymässä on kaksi erillistä näkymää, jotka ovat lista osallistujista ja päänäkymän, jossa voidaan lisää tai poistaa osallistujia.

Molemmat näkymät ovat [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-olioita ja ne eivät voi näkyä yhtäaikaa. Käyttöliittymä on täysin eristetty sovelluslogiikasta.

## Sovelluslogiikka

Istuma järjestyksen luomisesta vastaa luokka Generator, joka käyttää luokan Listgenerator luomia listoja järjestyksessä. Käyttöliittymän toiminnot toteutetaan, sekä Generator, että ParticipantDao luokassa. ParticipantDao on vastuussa tiedon lukemisesta tietokannasta, sekä sinne tiedon syöttämisestä, kun taas Generator saa Listgeneratorilta osallistujat ja kirjoittaa niiden avulla istumajärjestyksen.

## Tietojen pysyväistallennus

ParticipantDao ja Generator luokat ovat vastuussa tiedon tallentamisesta tiedostoihin.

ParticipantDao noudattaa [Data Access Object](https://en.wikipedia.org/wiki/Data_access_object)- suunnittelumallia. 

### Tiedostot

Sovellus tallentaa osallistuja ja istumajärjestyksen omiin tiedostoihinsa, joista osallistujat ovat tietokannassa ja istumajärjestys taulukkona.

Tietokanta on normaali sql tietokanta, jossa jokaisella osallistujalla on id, nimi, avec ja pöytäseura toive.

Istumajärjestys on csv tiedosto, jossa sarakkeiden erottajana toimii puolipiste(;).

Tietokanta on luotu seuraavalla lauseella:

```
CREATE TABLE IF NOT EXISTS Sitsit(
id integer PRIMARY KEY,
nimi varchar(200), 
avec varchar(200), 
toive varchar(200)
);
```



## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymä sisältää jonkin verran toisteissa koodia ja on aika sekava. Käyttöliittymä on myös hyvin suppea.

### Generator-luokka

Luokka on hyvin raskas ja sen ajaminen on hidasta. Sitä voisi yksinkertaistaa jolloin generoiminen olisi nopeampaa.

###

