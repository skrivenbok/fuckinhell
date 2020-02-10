package breakout.model;

/*
        A wall for the ball to bounce
 */
public class Wall{
    //enum constants are public , static and final
    public enum Dir {
        HORIZONTAL,
        VERTICAL;
    }

    public Dir direction;
    public double x;

    public Wall(double x,Dir direction){
        this.x = x;
        this.direction = direction;
    }
}
