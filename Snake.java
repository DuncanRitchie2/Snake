package Snake;

public class Snake {

    // Stores the joints for our snake.
    private final int[] x = new int[Board.getAllDots()];
    private final int[] y = new int[Board.getAllDots()];

    // Stores direction of our snake
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean movingUp = false;
    private boolean movingDown = false;

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

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
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

        // Moves snake to the left
        if (movingLeft) {
            x[0]--;
        }
        // To the right
        if (movingRight) {
            x[0]++;
        }
        // Down
        if (movingDown) {
            y[0]++;
        }
        // And finally up
        if (movingUp) {
            y[0]--;
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