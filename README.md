# CS49Jproject

### 1) Link to github repository  
    https://github.com/Andreas162534/CS49Jproject.git

### 2) Link to presentation if needed (slides will be in ZIP)  

### 3) Programm Descripton  
Game class:  
- This class implements the strategic of the game and includes the psvm
- 3 chasers and one player move in different way over a quadratic playing field of fixed size
  - main: 
    - stores last and best score in a stack read from a file
    - initializes random positions to the players and 3 chaseers
    - The player and chaser each move once each round
    - warns if player gets to close
    - displays the playing field with the Player and 3 Chaser
  - checkPlayerDead:
    compares the position of the player with the position of each chasers and returns true if they align
  - fibonacciRecursion: Computes the nth fibonacci number using recursion


### 4) Needed Imports  
No need to install any but default modules  
Needed imports are (already included in beginning of class files):  
for the game class
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
We used version: of Intellij  (find log file?)
1. Open intellij IDE
2. Open Terminal 
3. git clone https://github.com/Andreas162534/CS49Jproject.git (creates folder in directory where Terminal points to with all files of project)
4. open that directory in intellij (IDE)
5. Import list

### 6) JavaDoc  
   https://htmlpreview.github.io/?https://raw.githubusercontent.com/Andreas162534/CS49Jproject/master/JavaDoc/package-summary.html