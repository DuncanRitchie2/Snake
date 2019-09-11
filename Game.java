package Snake;

import javax.swing.*;
import java.io.IOException;

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