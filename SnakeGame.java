package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JPanel implements ActionListener {
    public static final int WIDTH = 24; // Width of grid in cells.
    public static final int HEIGHT = 24; // Height of grid in cells.
    public static final int CELLSIZE = 24; // Width and height of each cell in pixels.
    public static final int REFRESH = 1000; // Snake moves every second.

    public static int appleX;
    public static int appleY;

    Timer timer = new Timer(REFRESH, this);

    public SnakeGame() {
        timer.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(colour(5, 50, 10));
        g.fillRect(0, 0, WIDTH * CELLSIZE, HEIGHT * CELLSIZE);
        g.setColor(colour(255, 216, 0));

        for (int xx = 0; xx <= WIDTH * CELLSIZE; xx += CELLSIZE) {
            g.drawLine(xx, 0, xx, HEIGHT * CELLSIZE);
        }

        for (int yy = 0; yy <= HEIGHT * CELLSIZE; yy += CELLSIZE) {
            g.drawLine(0, yy, WIDTH * CELLSIZE, yy);
        }

//        for (int d = 0; d < snake.length; d++) {
//            g.setColor(colour(0, 0, 255));
//            g.fillRect(snake.snakeX[d] * CELLSIZE + 1, snake.snakeY[d] * CELLSIZE + 1, CELLSIZE - 1, CELLSIZE - 1);
//        }

        g.setColor(colour(255, 0, 0));
        g.fillRect(appleX * CELLSIZE + 1, appleY * CELLSIZE + 1, CELLSIZE - 1, CELLSIZE - 1);
    }

    public void actionPerformed(ActionEvent e) {
//        snake.move();
        repaint();
    }

    public Color colour(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    private class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            int key = event.getKeyCode();

//            if ((key == KeyEvent.VK_RIGHT) & snake.direction != 2) {
//                snake.direction = 0;
//            }
//            if ((key == KeyEvent.VK_DOWN) & snake.direction != 3) {
//                snake.direction = 1;
//            }
//            if ((key == KeyEvent.VK_LEFT) & snake.direction != 0) {
//                snake.direction = 2;
//            }
//            if ((key == KeyEvent.VK_UP) & snake.direction != 1) {
//                snake.direction = 3;
//            }
        }
    }

}
