
# OTM-Harjoitustyö

## Project Podship
### Description
In Podship, player oversees a program to construct a podship - ship that travels in deep space while hosting a tiny civilization within itself.

Gameplay consists of player first making choices for the ships population, governance, tech decisions etc. After the launch, player sees the log entries to see how the voyage succeeded.

- Java for logic
- JavaFX for GUI
- (TBA: Google Docs to hold event etc data)
- (TBA: actual build and travel events, not just test and debug events)

### Releases
[0.7 - We Must Launch Now! (Final version for OTM-course)](https://github.com/Granigan/otm-harjoitustyo/releases/tag/beta1)

[0.6 - Travelling Through Empty Space](https://github.com/Granigan/otm-harjoitustyo/releases/tag/alpha2)

[0.5 - Working Logic](https://github.com/Granigan/otm-harjoitustyo/releases/tag/alpha)


### Links
[User manual](https://github.com/Granigan/otm-harjoitustyo/blob/master/documentation/user_manual.md)

[Architecture and diagrams](https://github.com/Granigan/otm-harjoitustyo/blob/master/documentation/arkkitehtuuri.md)

[Requirements specification/Vaativuusmäärittely](https://github.com/Granigan/otm-harjoitustyo/blob/master/documentation/software_requirements.md)

[Working diary/Tuntikirjanpito](https://github.com/Granigan/otm-harjoitustyo/blob/master/documentation/working_diary.md)

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

#### Update JavaDocs
```
mvn javadoc:javadoc
```

#### See JavaDocs in HTML
```
xdg-open target/site/apidocs/index.html
```
