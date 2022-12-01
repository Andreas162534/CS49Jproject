import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import java.util.Random;

public class Game {
    public final static int FIELD_SIZE = 8;
    private int[][] field = new int[FIELD_SIZE][FIELD_SIZE];


    public static void main(String[] args) {
        Stack<Integer> scores = new Stack<>();   //parse scores to integer
        String filename = "highscore.txt";  //clean up

        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                int data = scanner.nextInt();
                scores.push(data);  //push in stack

                System.out.println(data);  //TODO delete
            }
            // scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        }

        int bestScore = Collections.max(scores);  //hope
        int lastScore = scores.pop();


        int score = 0;
        ArrayList<Character> gameTurn = new ArrayList<>();

        Random random = new Random();

        int xPosition = random.nextInt(FIELD_SIZE - 1);
        int yPosition = random.nextInt(FIELD_SIZE - 1);
        int[] initialPosition = {xPosition, yPosition};   //2d array for position
        Character player = new Player(initialPosition);
        gameTurn.add(player);

        xPosition = random.nextInt(FIELD_SIZE - 1);
        yPosition = random.nextInt(FIELD_SIZE - 1);
        initialPosition = new int[]{xPosition, yPosition};   //2d array for position
        Character andreasChaser = new AndreasCharacter(initialPosition);
        gameTurn.add(andreasChaser);


        /*
        xPosition = random.nextInt(FIELD_SIZE - 1);
        yPosition = random.nextInt(FIELD_SIZE - 1);
        initialPosition = new int[]{xPosition, yPosition};
        Character harryChaser = new harryCharacter(initialPosition);
        gameTurn.add(new HarrysCharacter(initialPosition));

        xPosition = random.nextInt(FIELD_SIZE - 1);
        yPosition = random.nextInt(FIELD_SIZE - 1);
        initialPosition = new int[]{xPosition, yPosition};
        Character sophieChaser = new sophieCharacter(initialPosition);
        gameTurn.add(new SophiesCharacter(initialPosition));*/

        // GUI
        JPanel window = new JPanel();
        /*window.setBounds(25, 25, 400,450);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(FIELD_SIZE+1, FIELD_SIZE);
        Container content = window.getContentPane();
        content.setLayout(grid);*/
        window.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        window.setLayout(new GridLayout(FIELD_SIZE + 1, FIELD_SIZE));
        for (int i = 0; i < ((FIELD_SIZE + 1)); i++) {
            for (int j = 0; j < ((FIELD_SIZE)); j++) {
                window.add(new JLabel());
            }
        }

        ///
        while (!checkPlayerDead(player, andreasChaser, harryChaser, sophieChaser)) {
//ToDo warning  for compareTo


            int it = 0;

            for (Component jc : window.getComponents()) {
                if (jc instanceof JLabel) {

                    switch (it) {
                        case 0 -> {
                            ((JLabel) jc).setText("Best Score:");
                        }
                        case 1 -> {
                            ((JLabel) jc).setText(Integer.toString(bestScore));
                        }
                        case 2 -> {
                            ((JLabel) jc).setText("");
                        }
                        case 3 -> {
                            ((JLabel) jc).setText("Last score:");
                        }
                        case 4 -> {
                            ((JLabel) jc).setText(Integer.toString(lastScore));
                        }
                        case 5 -> {
                            ((JLabel) jc).setText("");
                        }
                        case 6 -> {
                            ((JLabel) jc).setText("Score:");
                        }
                        case 7 -> {
                            ((JLabel) jc).setText(Integer.toString(score));
                        }

                        default -> {
                            int x = (it - FIELD_SIZE) % FIELD_SIZE;
                            int y = (it - FIELD_SIZE) / FIELD_SIZE;
                            if (x == player.getPosition()[0] && y == player.getPosition()[1]) {
                                ((JLabel) jc).setText("P");
                            } else if (x == andreasChaser.getPosition()[0] && y == andreasChaser.getPosition()[1]) {
                                ((JLabel) jc).setText("C");
                            }
                        /*
                        else if(x == sophieChaser.getPosition()[0] && y == sophieChaser.getPosition()[1]){
                            ((JLabel) jc).setText("C");
                        }
                        else if(x == harryChaser.getPosition()[0] && y == harryChaser.getPosition()[1]){
                            ((JLabel) jc).setText("C");
                        }*/
                            else {
                                ((JLabel) jc).setText("");
                            }
                        }
                    }


                }
                it++;
            }

            //call printmove
            //implement key listener in player to move
            //recursion (whatever)

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


    }

    public static boolean checkPlayerDead(Character player, Character andreasChaser, Character harryChaser, Character sophieChaser) {
        if (Arrays.equals(player.getPosition(), andreasChaser.getPosition()) ||
                Arrays.equals(player.getPosition(), harryChaser.getPosition()) ||
                Arrays.equals(player.getPosition(), sophieChaser.getPosition())) {
            return true;
        }
        return false;
    }
}

//call printmove
//implement key listener in player to move
//recursion (whatever)

