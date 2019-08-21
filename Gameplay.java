package Snake;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private ArrayList snakeXCoords = new ArrayList<Integer>();
    private ArrayList snakeYCoords = new ArrayList<Integer>();

    private ImageIcon titleImage = new ImageIcon("assets/snaketitle.jpg");
    private ImageIcon leftMouth = new ImageIcon("assets/leftmouth.png");
    private ImageIcon rightMouth = new ImageIcon("assets/rightmouth.png");
    private ImageIcon upMouth = new ImageIcon("assets/upmouth.png");
    private ImageIcon downMouth = new ImageIcon("assets/downmouth.png");
    private ImageIcon snakeImage = new ImageIcon("assets/snakeimage.png");

    public enum DIRECTIONS {
        UP, DOWN, LEFT, RIGHT
    }

    public DIRECTIONS direction = DIRECTIONS.RIGHT;

    private Timer timer;
    private int delay = 1000;

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(24,10,851,55);

        titleImage.paintIcon(this,g,25,11);

        g.setColor(Color.white);
        g.drawRect(24,74,851,577);

        g.setColor(Color.black);
        g.fillRect(25,75,850,575);

        for(int i = 0; i < snakeXCoords.size(); i++) {
            ImageIcon image = snakeImage;
            if (i == 0) {
                if (direction == DIRECTIONS.RIGHT) {
                    image = rightMouth;
                } else if (direction == DIRECTIONS.LEFT) {
                    image = leftMouth;
                } else if (direction == DIRECTIONS.UP) {
                    image = upMouth;
                } else if (direction == DIRECTIONS.DOWN) {
                    image = downMouth;
                }
            }
            image.paintIcon(this, g, (int) snakeXCoords.get(i), (int) snakeYCoords.get(i));
        }

        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
