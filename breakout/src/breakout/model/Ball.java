package breakout.model;

import java.util.Random;

import static breakout.model.Breakout.GAME_HEIGHT;
import static breakout.model.Breakout.GAME_WIDTH;

/*
 *    A Ball for the Breakout game
 */

public class Ball extends Item {
    //Add property ball radius
    public Ball(double x, double y){
        super(x,y);
        this.width=5;
        this.height=5;
    }
}
