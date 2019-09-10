package Snake;

public class Food {

    private Snake snake = new Snake();
    private int foodX; // Stores X pos of our food
    private int foodY; // Stores Y pos of our food

    public void createFood() {

        // Set our food's x & y position to a random position
        foodX = (int)(Math.random() * Board.getBoardWidth());
        foodY = (int)(Math.random() * Board.getBoardHeight());

        if ((foodX == snake.getSnakeX(0)) && (foodY == snake.getSnakeY(0))) {
            createFood();
        }
    }

    public int getFoodX() {
        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }
}