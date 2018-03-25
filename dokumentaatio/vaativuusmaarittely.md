# Software requirements specification for Project Podship
## Description
Project Podship is a single-player game that puts the player in a role of overseeing a creation of a colony space ship.
Gameplay is mainly selecting different options and thus making political, ethical, moral, and engineering decisions that form up the actual spaceship, its crew, and rules.
After the spaceship is launched, player no longer has control over it, but will instead see the log of the voyage as received on Earth, depicting the ultimate fate of the spaceship and its inhabitants.

## Users
Player is the only user of the game.

## User Interface
Game will have three main views:
- Start screen:
  - Choose your alias
  - Customize starting resources and conditions
  - Launch game
  - Quit game
- Main gameplay screen
  - Shows the amount of resources
  - List of previous choices
  - State of the ship (visual)
  - Upcoming schedule
  - Choice screen
    - Description of the current event
    - Options to choose from
  - Launch button
  - Quit game and return to Start screen -button
- Post-launch screen
  - State of the ship (visual)
  - Log of the events
  - Quit review and returnto Start screen -button
  
## Basic functionality
### After application launch
Player can customize the starting conditions and resources, choose their name, and start or quit the game.
The screen shows the high score list of previous voyages.

### After game launch
Player can make choices that affect the creation of the spaceship & its crew. Each turn, one choice is made, and making the choice automatically moves the game to the next turn.
Choices are made by choosing the appropriate button after reading the description of the event and the options. Choice will affect the resources/crew/schedule.
Once the player is satisfied with the spaceship and its crew, or time is running out, they Launch the spaceship, ending the gameplay and moving on to see the fate of the ship post-launch.

### After spaceship launch
Player sees the fate of the ship unfold on screen as news/ship log scrolls by as credits, ending in the ship's destruction, death of inhabitants, or safe arrival.
After this the voyage's score is presented, and added to high score list if warranted, and the player is taken back to the main screen.


## Minimum features
- Game can be created (basic UI)
- Choices are offered and can be made (tracking of choices)
  - 3 events that define crew type, ship type, and population type, after three events, ship must be launched
- Spaceship can be launched (end gameplay, see results)
- End result is reported (algoritm provides a result based on choices and resources.)

## Important features
- Choices are meaningful and logical, yet also difficult to make
  - pool of 5 events in each category (crew, ship, population, miscellaneous), popping up randomly until time (10 turns) runs out or player chooses to launch
- Informative UI
- Ship building:
  - Visual presentation of the ship
- Log of the travel & Score calculation
  - What happened on the journey, and how far did the ship get before encountering a terminal event
  
## Bonus features
- Multiple ship frames to choose from
- More choices in each pool
- New category: politics
  - Preparation time (i.e. how long until you must launch) is affected by political choices
