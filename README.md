# CS49Jproject

### 1) Link to github repository  
    https://github.com/Andreas162534/CS49Jproject.git

### 2) Link to presentation if needed (slides will be in ZIP)  

### 3) Programm Description  
- Game class:  
  - This class implements the strategic of the game and includes the psvm 
  - 3 chasers and one player move in different ways over a quadratic playing field of fixed size
    - main: 
      - stores last and best score in a stack read from a file
      - initializes random positions to the players and 3 chaseers
      - The player and chaser each move once each round
      - warns if player gets to close
      - displays the playing field with the Player and 3 Chaser
    - checkPlayerDead:
    compares the position of the player with the position of each chasers and returns true if they align
    - sumUntilNumber: sums up all numbers until n <br />
- Character abstract class:
  - implements Comparable 
  - describes a play figure with position, name and if its a player or a chaser
    - Next Move: returns the name of the player, concrete implementation willl determine how Character moves  
    - Getter: makes Name and Position available for ouside classes
    - Setter: lets Name and Position be changed in outside classes
    - compareTo: computes the distance between two Characters (returns a positive number if first item is bigger, returns negative number if first item is smaller)
- Move Interface:
  - printPosition: print position of Character where this method is implememnted
- Player class:  
  - is player not a chaser
  - nextMove: updates the x and y components of the position of the player
- AndreasClass:  
  - printPosition: prints Position of AndreasChaser
- AndreasCharacter:  
  - nextMove: lets AndreasChaser move diagonally over the playing field
- SophieClass:
  - printPosition: prints Position of SophieChaser
- SophieCharacter:
  - nextMove: lets SophieChaser move randomly one field in every direction like the King in chess
- RanveerClass:
  - printPosition: prints Position of RanveerChaser
- RanveerCharacter:
  - nextMove: lets RanveerChaser jump randomly around playing field
- DiscordLike class (independent of rest of project):
  - main (not in Game class): creates GUI to send a text message with text input, a send butten and a panel where one can see the text message


### 4) Needed Imports  
No need to install any but default modules  
Needed imports are (already included in beginning of class files):  
For the game class:
- java.io.*
- java.util.*
- java.util.Random
- java.lang.Thread.sleep
  
For the Display class:  
- javax.swing.*
- java.awt.*
- java.awt.event.KeyAdapter
- java.awt.event.KeyEvent

### 5) Instructions  
We used version: Version 8 Update 341 (Build 1.8.0_341-b10) and Intellij IDE
1. Open intellij IDE
2. Open Terminal 
3. git clone https://github.com/Andreas162534/CS49Jproject.git (creates folder in directory where Terminal points to with all files of project)
4. open that directory in intellij (IDE)
5. Import list

### 6) JavaDoc  
   https://htmlpreview.github.io/?https://raw.githubusercontent.com/Andreas162534/CS49Jproject/master/JavaDoc/package-summary.html
