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
  - Customize starting resources
  - Launch game
  - Quit game
- Main gameplay screen
  - Shows the amount of resources
  - List of previous choices (TBA)
  - Choice screen
    - Description of the current event
    - Options to choose from
  - Quit game and return to Start Screen -button
- Post-launch screen
  - Log of the events
  - Current resources
  - Quit review and return to Start Screen -button
  
## Basic functionality
### After application launch
Player can customize the starting resources, choose their name, and start or quit the game.
The screen shows the high score list of previous voyages.

### After game launch
Player can make choices that affect the creation of the spaceship & its crew. Each turn, one choice is made, and making the choice automatically moves the game to the next turn.
Choices are made by choosing the appropriate button after reading the description of the event and the options. Choice will affect the resources.
Once the time runs out, player launches the spaceship, ending the gameplay and moving on to see the fate of the ship post-launch.

### After spaceship launch
Player sees the fate of the ship unfold on screen as news/ship log scrolls by as credits, ending in the ship's destruction, death of inhabitants, or safe arrival.
After this the voyage's score is presented, and added to high score list if warranted, and the player is taken back to the main screen.


## Basic features
- Game can be compiled and ran
- Choices are offered and can be made (tracking of choices and effects on resources)
- Spaceship can be launched (end gameplay, see journey)
- End result is reported (algoritm provides a result based on resources.)

## Important features
- Choices are meaningful and logical, yet also difficult to make (Event content is not yet available.)
- Informative UI
- Log of the travel & Score calculation
  - What happened on the journey, and how far did the ship get before encountering a terminal event
  
## Bonus features (not available)
- ACTUAL CONTENT!
- Getting event info from Google Sheets via API key
- Persisting local high scores
- Political events during construction
  - Preparation time (i.e. how long until you must launch) is affected by political choices
- Ship building:
  - Visual presentation of the ship
- Multiple ship frames to choose from
- State of the ship (visual)
