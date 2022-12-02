import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    private JPanel panel= new JPanel();
    private JLabel header[] = new JLabel[Game.FIELD_SIZE];
    private JLabel field[]= new JLabel[Game.FIELD_SIZE*Game.FIELD_SIZE];


    public Display(int bestScore, int lastScore, int score, Character player, Character andreasChaser,
                   Character sophieChaser, Character harryChaser) {
        //setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        setLayout(new GridLayout(Game.FIELD_SIZE + 1, Game.FIELD_SIZE));
        for (int it = 0; it < Game.FIELD_SIZE; it++) {
            header[it] = new JLabel();
            panel.add(header[it]);

            switch (it) {
                case 0 -> {
                    header[it].setText("Best Score:");
                }
                case 1 -> {
                    header[it].setText(Integer.toString(bestScore));
                }
                case 2 -> {
                    header[it].setText("");
                }
                case 3 -> {
                    header[it].setText("Last score:");
                }
                case 4 -> {
                    header[it].setText(Integer.toString(lastScore));
                }
                case 5 -> {
                    header[it].setText("");
                }
                case 6 -> {
                    header[it].setText("Score:");
                }
                case 7 -> {
                    header[it].setText(Integer.toString(score));
                }

            }
        }

        for (int it = 0; it < Game.FIELD_SIZE * Game.FIELD_SIZE; it++) {
            field[it] = new JLabel();
            panel.add(field[it]);
            //busted condition implemented for all  3 chasers
            int x = (it - Game.FIELD_SIZE) % Game.FIELD_SIZE;
            int y = (it - Game.FIELD_SIZE) / Game.FIELD_SIZE;
            if (x == player.getPosition()[0] && y == player.getPosition()[1]) {
                field[it].setText("P");
            } else if (x == andreasChaser.getPosition()[0] && y == andreasChaser.getPosition()[1]) {
                field[it].setText("C");
            } else if (x == sophieChaser.getPosition()[0] && y == sophieChaser.getPosition()[1]) {
                field[it].setText("C");
            } else if (x == harryChaser.getPosition()[0] && y == harryChaser.getPosition()[1]) {
                field[it].setText("C");
            } else {
                field[it].setText("");
            }
        }

    }


    public void update(int bestScore, int lastScore, int score, Character player, Character andreasChaser,
                       Character sophieChaser, Character harryChaser) {
        for (int it = 0; it < Game.FIELD_SIZE; it++) {

            switch (it) {
                case 0 -> {
                    header[it].setText("Best Score:");
                }
                case 1 -> {
                    header[it].setText(Integer.toString(bestScore));
                }
                case 2 -> {
                    header[it].setText("");
                }
                case 3 -> {
                    header[it].setText("Last score:");
                }
                case 4 -> {
                    header[it].setText(Integer.toString(lastScore));
                }
                case 5 -> {
                    header[it].setText("");
                }
                case 6 -> {
                    header[it].setText("Score:");
                }
                case 7 -> {
                    header[it].setText(Integer.toString(score));
                }

            }

        }
        for (int it = 0; it < Game.FIELD_SIZE * Game.FIELD_SIZE; it++) {
            //busted condition implemented for all  3 chasers
            int x = (it - Game.FIELD_SIZE) % Game.FIELD_SIZE;
            int y = (it - Game.FIELD_SIZE) / Game.FIELD_SIZE;
            if (x == player.getPosition()[0] && y == player.getPosition()[1]) {
                field[it].setText("P");
            } else if (x == andreasChaser.getPosition()[0] && y == andreasChaser.getPosition()[1]) {
                field[it].setText("C");
            } else if (x == sophieChaser.getPosition()[0] && y == sophieChaser.getPosition()[1]) {
                field[it].setText("C");
            } else if (x == harryChaser.getPosition()[0] && y == harryChaser.getPosition()[1]) {
                field[it].setText("C");
            } else {
                field[it].setText("");
            }
        }
    }
}


