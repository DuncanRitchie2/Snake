package Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    // Holds height and width of the window in cells.
    private final static int BOARDWIDTH = 40;
    private final static int BOARDHEIGHT = 20;

    // Width and height of food and every snake-joint; window size will be a multiple.
    private final static int CELLSIZE = 25;

    // The total amount of pixels the game could possibly have.
    // We don't want less, because the game would end prematurely.
    // We don't more because there would be no way to let the player win.

    private final static int TOTALPIXELS = (BOARDWIDTH * BOARDHEIGHT);

    // Check to see if the game is running.
    private boolean inGame = true;

    // Timer used to record tick times.
    private Timer timer;

    // The interval after which the snake moves, in milliseconds.
    private static int speed = 125;

    // Instances of our snake & food.
    private Snake snake;
    private Food food = new Food();

    // Colours
    private Color bkgdColour = new Color(241,217,192);
    private Color foodColour = new Color(139,85,86);
    private Color headColour = new Color(57,85,32);
    private Color bodyColour = new Color(102,173,71);
    private Color textColour1 = new Color(93,17,49);
    private Color textColour2 = new Color(164,28,87);
    private Color textColour3 = new Color(40,12,23);

    public Board() {

        addKeyListener(new Keys());
        setBackground(bkgdColour);
        setFocusable(true);

        setPreferredSize(new Dimension(BOARDWIDTH*CELLSIZE, BOARDHEIGHT*CELLSIZE));

        initialiseGame();
    }

    // Used to paint our components to the screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }

    // Draw our Snake & Food, called on repaint().
    void draw(Graphics g) {

        // Only draw if the game is running
        if (inGame == true) {

            // Draw the food.
            g.setColor(foodColour);
            g.fillRect(food.getFoodX()*CELLSIZE, food.getFoodY()*CELLSIZE, CELLSIZE, CELLSIZE);

            // Draw the snake.
            for (int i = 0; i < snake.getLength(); i++) {
                // Snake's head
                if (i == 0) {
                    g.setColor(headColour);
                    g.fillRect(snake.getSnakeX(i)*CELLSIZE, snake.getSnakeY(i)*CELLSIZE,
                            CELLSIZE, CELLSIZE);
                    g.setColor(bodyColour);
                    // Body of snake
                } else {
                    g.fillRect(snake.getSnakeX(i)*CELLSIZE, snake.getSnakeY(i)*CELLSIZE,
                            CELLSIZE, CELLSIZE);
                }
            }

            // Draw text announcing the snake's length.
            String lengthMessage = "Length of snake: "+snake.getLength();
            g.setColor(textColour3);
            Font font = new Font("Alegreya", Font.BOLD, 14);
            g.drawString(lengthMessage, CELLSIZE,
                    (int)(BOARDHEIGHT-0.5)*CELLSIZE);

            // Sync our graphics together
            Toolkit.getDefaultToolkit().sync();
        } else {
            // If we're not alive, then we end our game
            endGame(g);
        }
    }

    void initialiseGame() {
        snake = new Snake();

        // Generate our first food.
        food.createFood(snake);

        // set the timer to start the snake moving.
        timer = new Timer(speed, this);
        timer.start();
    }

    // If our snake is in the close proximity of the food.
    void checkFoodCollisions() {

        if ((proximity(snake.getSnakeX(0), food.getFoodX(), 0))
                && (proximity(snake.getSnakeY(0), food.getFoodY(), 0))) {
            // Add a joint to our snake.
            snake.addJoint();
            // Create new food.
            food.createFood(snake);
        }
    }

    // Used to check collisions with snake's self.
    // Collisions with the walls are handled by Snake.move() so the snake reappears on the other side.
    void checkCollisions() {

        // If the snake hits its own joints...
        // Snake can only intersect with itself if it's longer than 3 joints,
        // so we check every joint after the 3rd for collision with the head.
        for (int i = snake.getLength()-1; i > 3; i--) {
            if (snake.getSnakeX(0) == snake.getSnakeX(i)
                    && (snake.getSnakeY(0) == snake.getSnakeY(i))) {
                inGame = false; // End the game.
            }
        }

        // If the snake hits the food...
        if ((food.getFoodX() == snake.getSnakeX(0)) && (food.getFoodY() == snake.getSnakeY(0))) {
            food.createFood(snake);
        }

        // If the game has ended, then we stop our timer.
        if (!inGame) {
            timer.stop();
        }
    }

    void endGame(Graphics g) {

        // Create a two-line message telling the player the game is over
        String message1 = "Game over!";
        String message2 = "Your snake bit itself. It was "+snake.getLength()+" joints long. Press Enter to reset.";

        // Create new font instances.
        Font font1 = new Font("Alegreya", Font.BOLD, 18);
        Font font2 = new Font("Alegreya", Font.BOLD, 14);
        FontMetrics metrics1 = getFontMetrics(font1);
        FontMetrics metrics2 = getFontMetrics(font2);

        // Set the color & font of the first line of text.
        g.setColor(textColour1);
        g.setFont(font1);

        // Draw the first line of the message to the board
        g.drawString(message1, (BOARDWIDTH*CELLSIZE - metrics1.stringWidth(message1)) / 2,
                (BOARDHEIGHT-2)*CELLSIZE / 2);

        // Set the color & font of the second line.
        g.setColor(textColour2);
        g.setFont(font2);

        // Draw the second line to the board
        g.drawString(message2, (BOARDWIDTH*CELLSIZE - metrics2.stringWidth(message2)) / 2,
                BOARDHEIGHT*CELLSIZE / 2);

        System.out.println("Game Ended");

    }

    // Run constantly as long as we're in game.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {

            checkFoodCollisions();
            checkCollisions();
            snake.move();
        }
        // Re-render our screen.
        repaint();
    }

    private class Keys extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (snake.getDirection()!=Snake.DIRECTIONS.RIGHT)) {
                snake.setDirection(Snake.DIRECTIONS.LEFT);
            }

            if ((key == KeyEvent.VK_RIGHT) && (snake.getDirection()!=Snake.DIRECTIONS.LEFT)) {
                snake.setDirection(Snake.DIRECTIONS.RIGHT);
            }

            if ((key == KeyEvent.VK_UP) && (snake.getDirection()!=Snake.DIRECTIONS.DOWN)) {
                snake.setDirection(Snake.DIRECTIONS.UP);
            }

            if ((key == KeyEvent.VK_DOWN) && (snake.getDirection()!=Snake.DIRECTIONS.UP)) {
                snake.setDirection(Snake.DIRECTIONS.DOWN);
            }

            if ((key == KeyEvent.VK_ENTER) && (!inGame)) {

                inGame = true;

                initialiseGame();
            }
        }
    }

    private boolean proximity(int a, int b, int closeness) {
        return Math.abs((long) a - b) <= closeness;
    }

    public static int getBoardWidth() {return BOARDWIDTH;}

    public static int getBoardHeight() {return BOARDHEIGHT;}
}