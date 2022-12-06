import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game {
    public final static int FIELD_SIZE = 8;
    public final static int WARNING_RADIUS = 2;
    private int[][] field = new int[FIELD_SIZE][FIELD_SIZE];


    public static void main(String[] args) throws InterruptedException {
        Stack<Integer> scores = new Stack<>();   //parse scores to integer
        String filename = "highscore.txt";  //clean up

        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextInt()) {
                int data = scanner.nextInt();
                scores.push(data);  //push on stack
            }
            // scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        }

        int bestScore = Collections.max(scores);  //hope
        int lastScore = scores.pop();


        int score = 0;
        ArrayList<Character> gameTurn = new ArrayList<Character>();

        Random random = new Random();

        int xPosition = random.nextInt(FIELD_SIZE - 1);
        int yPosition = random.nextInt(FIELD_SIZE - 1);
        int[] initialPosition = {xPosition, yPosition};   //2d array for position
        Character player = new Player(initialPosition);
        gameTurn.add(player);

        //initial position different for all chasers?

        xPosition = random.nextInt(FIELD_SIZE - 1);
        yPosition = random.nextInt(FIELD_SIZE - 1);
        initialPosition = new int[]{xPosition, yPosition};   //2d array for position
        Character andreasChaser = new AndreasCharacter(initialPosition);
        gameTurn.add(andreasChaser);


        xPosition = random.nextInt(FIELD_SIZE - 1);
        yPosition = random.nextInt(FIELD_SIZE - 1);
        initialPosition = new int[]{xPosition, yPosition};
        Character harryChaser = new RanveerCharacter(initialPosition);
        gameTurn.add(new RanveerCharacter(initialPosition));

        xPosition = random.nextInt(FIELD_SIZE - 1);
        yPosition = random.nextInt(FIELD_SIZE - 1);
        initialPosition = new int[]{xPosition, yPosition};
        Character sophieChaser = new SophieCharacter(initialPosition);
        gameTurn.add(new SophieCharacter(initialPosition));

        //creating Playingground!
        Display display = new Display(bestScore, lastScore, score, player, andreasChaser, sophieChaser, harryChaser);
        display.setSize(160, 180);
        display.setVisible(true);
        display.pack();
        display.setTitle("PacMan");

        ///

        //ToDo warning  for compareTo
        while (!checkPlayerDead(player, andreasChaser, harryChaser, sophieChaser)) {
            andreasChaser.nextMove(new int[]{0, 0});  //there is no default parameter in java
            harryChaser.nextMove(new int[]{0, 0});
            sophieChaser.nextMove(new int[]{0, 0});
            // TODO player nextMove
            Collections.sort(gameTurn);
            int distancePlayer = (int) Math.sqrt(gameTurn.get(0).getPosition()[0] ^ 2 + gameTurn.get(0).getPosition()[1] ^ 2);
            for (int i = 1; i < gameTurn.size(); i++) {
                int distance = (int) Math.sqrt((gameTurn.get(i).getPosition()[0] - gameTurn.get(0).getPosition()[0]) ^ 2
                        + (gameTurn.get(i).getPosition()[1] - gameTurn.get(0).getPosition()[1]) ^ 2);
                if (distance <= WARNING_RADIUS) {
                    System.out.println("Warning Chaser very close");
                    break;                          //special breakpoint
                }
            }



            System.out.println("Position of Player is " +  player.getPosition()[0] + ","+ player.getPosition()[1] );
            display.update(bestScore, lastScore, score, player, andreasChaser, sophieChaser, harryChaser);
            display.setSize(80, 90);
            display.setVisible(true);
            display.pack();
            sleep(1000);
            score++;
        }

///
        //FileWriter
        try (FileWriter fileWriter = new FileWriter(filename, true);  //buffering if file is to long
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter out = new PrintWriter(bufferedWriter)) {
            out.println(Integer.toString(score));
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }

        System.out.println("The fibonacci number of the highscore is: " + fibonacciRecursion(score));
        return;
    }

    public static boolean checkPlayerDead(Character player, Character andreasChaser, Character harryChaser, Character sophieChaser) {
        if (Arrays.equals(player.getPosition(), andreasChaser.getPosition()) ||
                Arrays.equals(player.getPosition(), harryChaser.getPosition()) ||
                Arrays.equals(player.getPosition(), sophieChaser.getPosition())) {
            return true;
        }
        return false;
    }

    private static int fibonacciRecursion(int n) {  //n is natural number
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
        }
    }
}

//call printpos
// warning
//use interface


//Todo loops special breakpoint

