package itqop.points;

public class point2D {
    protected double xCoord;
    protected double yCoord;
    public point2D ( double x, double y) {
        xCoord = x;
        yCoord = y;
    }
    public point2D () {
        this(0, 0);
    }
    public double getX () {
        return xCoord;
    }
    public double getY () {
        return yCoord;
    }
    public void setX ( double val) {
        xCoord = val;
    }
    public void setY ( double val) {
        yCoord = val;
    }
}
