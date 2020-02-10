package breakout.model;

/*
 *   A brick for the rows of bricks
 */

public class Brick extends Item{

    public static final double BRICK_WIDTH = 20;
    public static final double BRICK_HEIGHT = 10;
    public double pointValue;

    public Brick(double x, double y, double points){
        super(x,y);
        this.width = this.BRICK_WIDTH;
        this.pointValue = points;
        this.height = this.BRICK_HEIGHT;
    }
}

