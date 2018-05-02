# User's Manual - Podship

## Download the executable file for the game
Download [podship.jar](https://github.com/Granigan/otm-harjoitustyo/releases/download/alpha/podshipv0.5.jar)

## Run the game
In the folder you downloaded podship.jar, run the command line command:

```
java -jar podship.jar
```

## Playing the game

Playing is straightforward: once you run the command, you'll see some project information, and then you'll be playing the game.

### Construction Phase

First you'll be asked for your name.
[!What is your name, director?](https://github.com/Granigan/otm-harjoitustyo/documentation/images/name_request.png)

Next, you'll get a brief introduction to the situation, and soon after you'll get to make first of your many choices.

[!This is your task.](https://github.com/Granigan/otm-harjoitustyo/documentation/images/intro_text.png)

[!One of many choices to make](https://github.com/Granigan/otm-harjoitustyo/documentation/images/population_choice.png)
_Here you'll need to make a choice regarding the population of the podship._

With the text UI, you'll make choices by typing in the choice number, or other prompted keyword or letter. With GUI, you'll be able to choose the options by mouse.

### Travel Phase

Once you're content with the state of the project, or if the time runs out, the ship will be launched. After this, you'll have no choice but to follow it's status from the ensuing report stream.


In the end, you'll learn the fate of the mission, and receive your score.

[!One of many choices to make](https://github.com/Granigan/otm-harjoitustyo/documentation/images/population_choice.png)
_Hopefully you can fare better..._

### Game Over
The game send you back to the terminal after the voyage is finished. Should you wish, you can run the game again with the same command.

```
java -jar podship.jar
```


## Notes
There are very few different events at this stage, and most of the game is run with debug-events that are somewhat random. Thus the game experience is not there yet, but the structure is in place.
