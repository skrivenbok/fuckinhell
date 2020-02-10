package breakout.model;

public abstract class Item implements IPositionable {
    public double x;
    public double y;
    public double width;
    public double height;

    public Item(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Item(){}
    public double getX(){return this.x;};

    public double getY(){return this.y;};

    public double getWidth(){return this.width;};

    public double getHeight(){return this.height;};
}
