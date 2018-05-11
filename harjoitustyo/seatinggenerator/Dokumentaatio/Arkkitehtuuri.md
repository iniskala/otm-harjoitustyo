# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne on kolmitasoinen kerrosarkkitehtuuri ja sen rakenne näkyy seuraavassa kaaviossa:

<img src="https://github.com/iniskala/otm-harjoitustyo/blob/master/harjoitustyo/seatinggenerator/Dokumentaatio/Otm.png" width="800">

Ui sisältää käyttöliittymän, joka on tehty javaFX:llän avulla, database sisältää tietojen tallenuksesta vastaavan koodin, lukuunottamatta istumajärjestyksen kirjoittavaa koodia, ja generatoretc pakkaus sisältää sovelluslogiikan.

## Käyttöliittymä

Käyttöliittymässä on kaksi erillistä näkymää, jotka ovat lista osallistujista ja päänäkymän, jossa voidaan lisää tai poistaa osallistujia.

Molemmat näkymät ovat Scene-olioita ja ne eivät voi näkyä yhtäaikaa. Käyttöliittymä on täysin eristetty sovelluslogiikasta.

## Sovelluslogiikka

