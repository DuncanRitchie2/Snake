package Snake;

public class Food {
    private int foodX; // Stores X position of our food
    private int foodY; // Stores Y position of our food

    public void createFood(Snake snake) {
        // This boolean is set to true if new food co-ordinates have
        // not been set or if the food would be under the snake.
        boolean newPositionNeeded = true;

        while (newPositionNeeded) {
            // Set our food's x & y position to a random position.
            foodX = (int)(Math.random() * Board.getBoardWidth());
            foodY = (int)(Math.random() * Board.getBoardHeight());

            newPositionNeeded = false;

            // Check whether there's a joint coinciding with the food.
            for (int i = 0; i < snake.getLength(); i++) {
                if (snake.getSnakeX(i)==foodX || snake.getSnakeY(i)==foodY) {
                    newPositionNeeded = true;
                    break;
                }
            }
        }

    }

    public int getFoodX() {
        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }
}