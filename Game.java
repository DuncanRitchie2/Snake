package Snake;

import javax.swing.*;

public class Game extends JFrame {

    Game() {
        setVisible(true);
        add(new Board());
        setResizable(false);
        pack();

        setTitle("Duncan's Snake Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}