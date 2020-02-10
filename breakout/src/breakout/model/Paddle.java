package breakout.model;

import static breakout.model.Breakout.GAME_HEIGHT;
import static breakout.model.Breakout.GAME_WIDTH;

/*
 * A Paddle for the Breakout game
 *
 */
public class Paddle extends Item {

    public static final double PADDLE_WIDTH = 60;
    public static final double PADDLE_HEIGHT = 10;
    public static final double PADDLE_SPEED = 5;

    public Paddle(double x, double y){
        super(x,y);
        this.width = PADDLE_WIDTH;
        this.height = PADDLE_HEIGHT;
    }
}
