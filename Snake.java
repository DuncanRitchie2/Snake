package Snake;

import java.util.ArrayList;

public class Snake {

    // Stores the joints for our snake.
    private ArrayList<Integer> x = new ArrayList<Integer>();
    private ArrayList<Integer> y = new ArrayList<Integer>();

    // Enum for possible directions.
    public enum DIRECTIONS {
        UP, RIGHT, DOWN, LEFT
    }

    // Stores direction of our snake
    private DIRECTIONS direction = DIRECTIONS.RIGHT;

    public Snake() {
//        int initLength = 2;

        // Define the initial positions of all the joints.
        for (int i = 0; i < joints; i++) {
            x.add(Board.getBoardWidth() / 2 - i);
            y.add(Board.getBoardHeight() / 2);
        }
    }

    public void addJoint() {
        x.add(x.get(x.size()-1));
        y.add(y.get(y.size()-1));
    }


    private int joints = 2; // The number of joints in the snake; starts at 2.

    public int getSnakeX(int index) {
        return x.get(index);
    }

    public int getSnakeY(int index) {
        return y.get(index);
    }

    public void setSnakeX(int i) {
        x.set(0,i);
    }

    public void setSnakeY(int i) {
        y.set(0,i);
    }

    public void setDirection(DIRECTIONS dir) {
        direction = dir;
    }

    public DIRECTIONS getDirection() {
        return direction;
    }

    public int getLength() {
        return x.size();
    }

    public void move() {
        for (int i = x.size()-1; i > 0; i--) {
            // Moves every joint of the snake to the position of the previous joint.
            x.set(i,x.get((i - 1)));
            y.set(i,y.get((i - 1)));
        }

        switch (direction) {
            case UP:
                y.set(0,y.get(0)-1);
                break;
            case RIGHT:
                x.set(0,x.get(0)+1);
                break;
            case DOWN:
                y.set(0,y.get(0)+1);
                break;
            case LEFT:
                x.set(0,x.get(0)-1);
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