package Snake;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame {

    public static void main(String[] args) {

        // Creates a new thread so our GUI can process itself
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Game();
            }
        });
    }
}
