
# OTM-Harjoitustyö

## Project Podship
[Requirements specification/Vaativuusmäärittely](https://github.com/Granigan/otm-harjoitustyo/blob/master/dokumentaatio/vaativuusmaarittely.md)

[Working diary/Tuntikirjanpito](https://github.com/Granigan/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Trello-board](https://trello.com/b/sjB2XI3j/podship)


### CLI commands
Execute these under otm-harjoitustyo/projectpodship/

#### Compile & Run
mvn compile exec:java -Dexec.mainClass=podship.domain.Main

#### Run tests and build a report
mvn test jacoco:report

#### See report
xdg-open target/site/jacoco/index.html
