package breakout.model;


import breakout.event.ModelEvent;
import breakout.event.EventBus;

import java.util.ArrayList;
import java.util.List;

/*
 *  Overall all logic for the Breakout Game
 *  Model class representing the full game
 *  This class should use other objects delegate work.
 *
 *  NOTE: Nothing visual here
 *
 */
public class Breakout {

    public static final double GAME_WIDTH = 400;
    public static final double GAME_HEIGHT = 400;
    public static final double BALL_SPEED_FACTOR = 1.05; // Increase ball speed
    public static final long SEC = 1_000_000_000;  // Nano seconds used by JavaFX

    private int ballsLeft = 5;
    int points;
    public List<Brick> bricks;
    public List<Wall> walls;
    public Paddle paddle;
    public Ball ball;
    int ballSpeedX = 1;
    int ballSpeedY = 1;


    // TODO Constructor that accepts all objects needed for the model
    public Breakout(List<Brick> _bricks,List<Wall> walls, Ball ball, Paddle paddle)
    {
        this.bricks = _bricks;
        this.walls = walls;
        this.ball = ball;
        this.paddle = paddle;
    }

    // --------  Game Logic -------------

    private long timeForLastHit;         // To avoid multiple collisions

    public void update(long now) {
        // TODO  Main game loop, start functional decomposition from here
    moveBall();
    checkPaddleCollision();
    checkBrickCollision();
    }

    // ----- Helper methods--------------
    private void checkBrickCollision(){
        for(Brick b : this.bricks){
            if((this.ball.x >= b.x && this.ball.x <= b.x + b.width) && this.ball.y > b.y && this.ball.y <= b.y + b.height){

                   this.ballSpeedX = -this.ballSpeedX;
                   this.ballSpeedY = -this.ballSpeedY;
                   this.bricks.remove(b);
                   this.points += b.pointValue;


            }
        }
    }
    private void checkPaddleCollision(){
        if(this.ball.y >= this.paddle.y - this.paddle.height){
            if(this.ball.x >= this.paddle.x && this.ball.x <= this.paddle.x + this.paddle.width) {
                ballSpeedY = -ballSpeedY;
                this.ball.y = this.paddle.y - this.paddle.height;
            }
        }
    }
    private void moveBall(){
        this.ball.x += ballSpeedX;
        this.ball.y += ballSpeedY;
        //this.ball.y += ballSpeedY;
        if (this.ball.x < 0) {
            this.ballSpeedX = -this.ballSpeedX;
            this.ball.x = 0;
        }else if(this.ball.x > this.GAME_WIDTH){ //Add ball radius
            this.ballSpeedX = -this.ballSpeedX;
            this.ball.x = this.GAME_WIDTH; //Add ball radius
        }
        if (this.ball.y < 0) {
            ballSpeedY = -ballSpeedY;
            this.ball.y = 0;
        } else if (this.ball.y > this.GAME_HEIGHT) { //Add ball radius
            //Dead
            if(ballsLeft - 1 >= 0){
                ballsLeft--;
                this.ball = new Ball(200, 200);
            }else{
                //gameover
            }

        }

    }
    // Used for functional decomposition
    public void movePaddle(Direction dir){
        switch (dir){
            case Left:
                if((this.paddle.x - 5) > 0) {
                    this.paddle.x -= 5;
                }
                break;
            case Right:
                if((this.paddle.x + this.paddle.width + 5) < this.GAME_WIDTH) {
                    this.paddle.x += 5;
                }
                break;
            default:
                break;
        }
    }


    // --- Used by GUI  ------------------------

    public List<IPositionable> getPositionables() {
       List<IPositionable> list = new ArrayList<IPositionable>();
        for(Brick b : this.bricks){
            list.add((IPositionable) b);
        }
        list.add((IPositionable) this.paddle);
        list.add((IPositionable) this.ball);
        return list;

       // return null;  // TODO return all objects to be rendered by GUI
    }

    public int getPoints() {
        return points;
    }

    public int getBallsLeft() {
        return ballsLeft;
    }




}
