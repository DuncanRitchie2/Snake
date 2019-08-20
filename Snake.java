package Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Snake {
    private JPanel rootPanel;
    private JLabel snakeTitle;
    private JButton startGameButton;

    private JLabel textLabel;

    public Snake() {
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textLabel.setText("I've not yet written the game, sorry!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setContentPane(new Snake().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
