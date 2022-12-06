import java.io.*;
import java.util.*;
import java.util.Random;
import static java.lang.Thread.sleep;

/**
 * This class has the strategic of the game and therefore consists the psvm.
 */
public class Game {
    /**
     * Needed variables
     */
    public final static int FIELD_SIZE = 8;
    public final static int WARNING_RADIUS = 2;
    private final static int[] DIRECTION = {-1, 0, 1};

    /**
     * Main which has the flow of the game.
     * @param args not used
     * @throws InterruptedException comes from Sleep but does not to be handled because no Multithreading
     */
    public static void main(String[] args) throws InterruptedException {
        Stack<Integer> scores = new Stack<>();      // Requirement to have one of the given datastructure
        String filename = "highscore.txt";
        File file = new File(filename);

        // Requirement to have a try catch and requirement to read a file
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                int data = scanner.nextInt();
                scores.push(data);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        }

        // Provide score variables
        int bestScore = Collections.max(scores);
        int lastScore = scores.pop();
        System.out.println("Best Score: " + bestScore + "\tLatest Score: " + lastScore);
        int score = 0;
        ArrayList<Character> gameTurn = new ArrayList<>();

        // Requirement to use random in a useful way by making a random initial position of the characters
        Random random = new Random();
        int xPosition = random.nextInt(FIELD_SIZE - 1);
        int yPosition = random.nextInt(FIELD_SIZE - 1);
        int[] initialPosition = {xPosition, yPosition};      // Intial position for andreasChaser
        AndreasClass andreasChaser = new AndreasClass(initialPosition);
        andreasChaser.printPosition();
        gameTurn.add(andreasChaser);

        xPosition = random.nextInt(FIELD_SIZE - 1);
        yPosition = random.nextInt(FIELD_SIZE - 1);
        initialPosition = new int[]{xPosition, yPosition};      // Intial position for harryChaser
        RanveerClass harryChaser = new RanveerClass(initialPosition);
        harryChaser.printPosition();
        gameTurn.add(new RanveerCharacter(initialPosition));

        xPosition = random.nextInt(FIELD_SIZE - 1);
        yPosition = random.nextInt(FIELD_SIZE - 1);
        initialPosition = new int[]{xPosition, yPosition};      // Intial position for sophieChaser
        SophieClass sophieChaser = new SophieClass(initialPosition);
        sophieChaser.printPosition();
        gameTurn.add(new SophieCharacter(initialPosition));

        xPosition = random.nextInt(FIELD_SIZE - 1);
        yPosition = random.nextInt(FIELD_SIZE - 1);
        initialPosition = new int[]{xPosition, yPosition};         // Intial position for player
        Character player = new Player(initialPosition);
        System.out.println("Position of Player is (" +  player.getPosition()[0] + "," + player.getPosition()[1] + ")");
        gameTurn.add(player);

        // The game runs until the player is dead
        while (!checkPlayerDead(player, andreasChaser, harryChaser, sophieChaser)) {
            // Next Position for Chasers
            andreasChaser.nextMove();
            andreasChaser.printPosition();
            harryChaser.nextMove();
            harryChaser.printPosition();
            sophieChaser.nextMove();
            sophieChaser.printPosition();

            // Next Position for Player (Requirement loop in loop)
            random = new Random();
            int posX;
            do {
                int randDir = random.nextInt(DIRECTION.length);
                posX = player.getPosition()[0]+DIRECTION[randDir];
            } while(posX<0 || posX>=Game.FIELD_SIZE);
            int posY;
            do {
                int randDir = random.nextInt(DIRECTION.length);
                posY = player.getPosition()[1]+DIRECTION[randDir];
            } while(posY<0 || posY>=Game.FIELD_SIZE);
            player.setPosition(new int[]{posX, posY});
            System.out.println("Position of Player is (" +  player.getPosition()[0] + "," + player.getPosition()[1] + ")");

            // Warning if a chaser is too close to the player
            Collections.sort(gameTurn);
            for (int i = 1; i < gameTurn.size(); i++) {
                double distance = Math.hypot((gameTurn.get(i).getPosition()[0] - gameTurn.get(0).getPosition()[0]),
                                            (gameTurn.get(i).getPosition()[1] - gameTurn.get(0).getPosition()[1]));
                if (distance < WARNING_RADIUS) {
                    System.out.println("Warning! Chaser " + gameTurn.get(i).getName() + " very close to " + gameTurn.get(0).getName());
                    break;          // Requirement special breakpoint
                }
            }

            sleep(1000);        // To slow down the game
            score++;
        }
        System.out.println("This games score is " + score);

        // Requirement file writing and exception handling
        try (FileWriter fileWriter = new FileWriter(filename, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter out = new PrintWriter(bufferedWriter)) {
            out.println(score);
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }

        // Calling the recursive function
        System.out.println("The sum until number of this highscore is: " + sumUntilNumber(score));
    }

    /**
     * It is a static method which checks if the player is still alive or got already caught by a chaser.
     * @param player object of the class Player
     * @param andreasChaser object of Andreas Character
     * @param harryChaser object of Ranveer Character
     * @param sophieChaser object of Sophie Character
     * @return true if player is dead
     */
    public static boolean checkPlayerDead(Character player, Character andreasChaser, Character harryChaser, Character sophieChaser) {
        return Arrays.equals(player.getPosition(), andreasChaser.getPosition()) ||
                Arrays.equals(player.getPosition(), harryChaser.getPosition()) ||
                Arrays.equals(player.getPosition(), sophieChaser.getPosition());
    }

    /**
     * A recursion function to fulfill the requirements
     * @param n a number
     * @return the fibonacci number
     */
    private static long sumUntilNumber(int n) {
        if (n < 1) {
            return 0;
        }
        else {
            return sumUntilNumber(n - 1) + n;
        }
    }
}

