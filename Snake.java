package Snake;

public class Snake {

    // Stores the joints for our snake.
    private final int[] x = new int[Board.getAllDots()];
    private final int[] y = new int[Board.getAllDots()];

    // Enum for possible directions.
    public enum DIRECTIONS {
        UP, RIGHT, DOWN, LEFT
    }

    // Stores direction of our snake
    private DIRECTIONS direction = DIRECTIONS.RIGHT;

    private int joints = 0; // The number of joints in the snake; starts at 3.

    public int getSnakeX(int index) {
        return x[index];
    }

    public int getSnakeY(int index) {
        return y[index];
    }

    public void setSnakeX(int i) {
        x[0] = i;
    }

    public void setSnakeY(int i) {
        y[0] = i;
    }

    public void setDirection(DIRECTIONS dir) {
        direction = dir;
    }

    public DIRECTIONS getDirection() {
        return direction;
    }

    public int getJoints() {
        return joints;
    }

    public void setJoints(int j) {
        joints = j;
    }

    public void move() {
        for (int i = joints; i > 0; i--) {
            // Moves every joint of the snake to the position of the previous joint.
            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }

        switch (direction) {
            case UP:
                y[0]--;
                break;
            case RIGHT:
                x[0]++;
                break;
            case DOWN:
                y[0]++;
                break;
            case LEFT:
                x[0]--;
        }

        // If the snake intersects with the board edges, it wraps around!
        if (getSnakeY(0) >= Board.getBoardHeight()) {
            setSnakeY(0);
        }

        if (getSnakeY(0) < 0) {
            setSnakeY(Board.getBoardHeight()-1);
        }

        if (getSnakeX(0) >= Board.getBoardWidth()) {
            setSnakeX(0);
        }

        if (getSnakeX(0) < 0) {
            setSnakeX(Board.getBoardWidth()-1);
        }
    }
}