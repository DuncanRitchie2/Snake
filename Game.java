package Snake;

import javax.swing.*;

public class Game extends JFrame {

    Game() {
        add(new Board());
        setResizable(true);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}