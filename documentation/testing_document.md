# Testing Document

The game has been tested with unit and integration tests with JUnit, and manually on system level.

## Unit and integration testing

Travel and Events packages are fairly well covered, the Logic package will need more tests, or perhaps refactoring to allow for easier testing.

Along simpler tests focusing on just one method, there are also integration level tests that involve multiple methods and classes.

### Test Coverage
Row coverage is 79%, and branch coverage is 75%. Higher coverage would be useful and will be added later on when time permits. Most troublesome are two main methods inside GameLogic class that may need refactoring before proper testing can be done.
![Jacoco report](https://github.com/Granigan/otm-harjoitustyo/blob/master/documentation/images/jacoco_report.png)


## System testing
System testing has been manual. It includes downloading and running the .jar as instructed in the [User Manual](https://github.com/Granigan/otm-harjoitustyo/blob/master/documentation/user_manual.md) on Linux OS. Extensive testing was done on Linux, and brief one on OSX.

### Functionality
All the features and functionality listed in the [Software Requirements doc](https://github.com/Granigan/otm-harjoitustyo/blob/master/documentation/software_requirements.md) have been tested for, including playing the game multiple times without restarting the app.

## Known issues
Due to deadline driven development, there are no current **known** issues. These will undoubtedly appear as development continues!
