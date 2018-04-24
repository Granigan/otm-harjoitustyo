
# OTM-Harjoitustyö

## Project Podship
[Get release 0.5 alpha](https://github.com/Granigan/otm-harjoitustyo/releases/tag/alpha)

[Architecture and diagrams](https://github.com/Granigan/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Requirements specification/Vaativuusmäärittely](https://github.com/Granigan/otm-harjoitustyo/blob/master/dokumentaatio/vaativuusmaarittely.md)

[Working diary/Tuntikirjanpito](https://github.com/Granigan/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Trello-board](https://trello.com/b/sjB2XI3j/podship)


### CLI commands
Execute these under otm-harjoitustyo/projectpodship/

#### Create .jar package
```
mvn package
```

#### Run .jar package
```
java -jar target/projectpodship-1.0-SNAPSHOT.jar
```

#### Compile & Run
```
mvn compile exec:java -Dexec.mainClass=podship.domain.Main
```

#### Run Jacoco tests and build a report
```
mvn test jacoco:report
```

#### See Jacoco test report
```
xdg-open target/site/jacoco/index.html
```

#### Run Checkstyle tests and build a report
```
mvn jxr:jxr checkstyle:checkstyle
```

#### See Checkstyle report
```
xdg-open target/site/checkstyle.html
```
