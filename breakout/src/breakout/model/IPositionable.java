package breakout.model;

/*

   Specification for anything that can be positioned in the world.
   NOTE: This must be fulfilled by any object the GUI shall render

 */
public interface IPositionable {

    double getX();      // Min x and y is upper left corner (y-axis pointing donw)

    double getY();

    double getWidth();

    double getHeight();

}
