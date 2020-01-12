# Oversikt over Bysykkel
Dette er en liten applikasjon som viser oversikt over de ulike sykkelstajsonene til Bysykkel, og hvor mange tilgjengelige låser og ledige sykler som er på dem i øyeblikket. Applikasjonen benytter sanntidsdata fra Oslo bysykkel sitt API. 

## Miljø
Java versjon 9+ <br>
Maven versjon 3+

## Kjøring
Last ned prosjektet, unzip filen og kjør følgende kommandoer i terminalen: 
``` 
$ cd bysykkelstatus-master
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="bysykkel.App
```