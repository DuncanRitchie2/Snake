package Snake;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Snake {
    private JPanel rootPanel;
    private JLabel snakeTitle;
    private JButton startGameButton;
    private JLabel textLabel;

    public Snake() {
        snakeTitle.setFont(new Font("Alegreya", Font.BOLD,24));
        textLabel.setFont(new Font("Alegreya", Font.PLAIN,14));
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textLabel.setText("I've not yet written the game, sorry!");
                startGameButton.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Duncan's Snake Game");
        frame.setContentPane(new Snake().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
