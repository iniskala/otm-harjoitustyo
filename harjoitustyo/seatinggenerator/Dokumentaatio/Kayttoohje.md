# Käyttöohje

Lataa tiedosto [seattinggenerator.jar](https://github.com/iniskala/otm-harjoitustyo/releases/download/Viikko7/seattinggenerator.jar)

## Ohjelman käynnistäminen

Ohjelma käynnistetään seuraavalla komennolla

```
java -jar seattinggenerator.jar
```

## Henkilöiden lisääminen ja poistaminen generaattorista

Sovellus käynnistyy näkymään, jossa on mahdollista lisätä henkilöitä, generoida istumajärjestys, sekä katsoa jo lisätyt henkilöt.

Henkilöiden lisääminen onnistuu kirjoittamalla aloitusnäkymään tekstikenttiin nimi ja vaihtoehtoisesti avec sekä pöytäseuratoive, jos ei ole avecia tai pöytäseuratoivetta jätetään nämä kohdat tyhjiksi. Tietojen ollessa kunnossa painetaa save nappulaa, jos nappulaa painetaan vahingossa tai nimissä oli kirjoitus virhe voidaan henkilö poistaa listalta kirjoittamalla uudelleen tiedot niikuin ne aluksi ohjelmaan syötettiin (ne voidaan tarkistaa participants näkymästä) ja painamalla remove.

## Osallistujien tarkistaminen

Käyttäjä voi tarkistaa generaattoriin syötettyjen osallistujien tiedot participants näkymästä.

## Istumajärjestyksen generointi

Käyttäjä voi generoida istumajärjestyksen painamalla generate nappulaa. Generoimisessa menee hetki, joten pitää olla kärsivällinen. Ohjelma tallentaa istumajärjestyksen csv tiedostoon ja käyttää sarakkeiden eroitteluun puolipistettä (;).  

