package Snake;

public class Food {
    private int foodX; // Stores X pos of our food
    private int foodY; // Stores Y pos of our food

    public void createFood() {

        // Set our food's x & y position to a random position
        foodX = (int)(Math.random() * Board.getBoardWidth());
        foodY = (int)(Math.random() * Board.getBoardHeight());
    }

    public int getFoodX() {
        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }
}