/**
 * This class represents a point object in the first quadrant of a 
 * Polar coordinate system.
 *
 * @author Simon Lousky
 * @version 28-11-2020
 */
public class Point
{
    
    //----------------------------//
    //        Declarations:       //
    //----------------------------//
    
    private double _radius;
    private double _alpha;
    private static final int DEFAULT_VAL = 0;
    private static final double PI = Math.PI;
    private static final double DEGREE_180 = 180;
    private static final double DEGREE_90 = 90;
    private static final double PRECISION = 10000;
    
    //----------------------------//
    //        Constructors:       //
    //----------------------------//
    
    /**
     * Construct a point in Polar coordinate.
     * If one of the parameters is negative then it should be initialized to zero,
     * If x Carthesian coordinate is zero then alpha Polar coordinate should be initialized to 90 degree.
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(double x, double y)
    {
        if (x < DEFAULT_VAL)
            x = DEFAULT_VAL;
        if (y < DEFAULT_VAL)
            y = DEFAULT_VAL;
        _radius = radiusCalcul(x,y);  
        _alpha = alphaCalcul(x,y);
    }
    
    /**
     * Copy constructor for point.
     * Construct a point with the same coordinates as other point.
     * @param other The point object from which to construct the new point
     */
    public Point (Point other)
    {
        _radius = other._radius;
        _alpha = other._alpha;
    }
    
    //----------------------------//
    //          Methods:          //
    //----------------------------//
    
    /**
     * Returns the x coordinate of the point.
     * @return The x coordinate of the point.
     */
    public double getX()
    {
        return Math.round(_radius * Math.cos(_alpha * PI / DEGREE_180) * PRECISION) / (double)PRECISION;
    }
    
    /**
     * Returns the y coordinate of the point.
     * @return The y coordinate of the point.
     */
    public double getY()
    {
        return Math.round(_radius * Math.sin(_alpha * PI / DEGREE_180) * PRECISION) / (double)PRECISION;
    }
    
    /**
     * Sets the x coordinate of the point (by suitable Polar coordinates change).
     * If a negative number is received then the x coordinate does not change.
     * @param num The new x coordinate
     */
    public void setX(double num)
    {
        double y = this.getY();
        if (num >= DEFAULT_VAL)
        {
            _radius = radiusCalcul(num,y);
            _alpha = alphaCalcul(num,y);
        }
    }
    
    /**
     * Sets the y coordinate of the point (by suitable Polar coordinates change).
     * If a negative number is received then the y coordinate does not change.
     * @param num The new y coordinate
     */
    public void setY(double num)
    {
        double x = this.getX();
        if (num >= DEFAULT_VAL)
        {
            _radius = radiusCalcul(x,num);
            _alpha = alphaCalcul(x,num);
        }
    }
    
    /**
     * Returns a string representation of this point.
     * @return String representasion of this point.
     */
    public String toString()
    {
        return "(" + Math.round(this.getX()*PRECISION)/(double)PRECISION + "," + Math.round(this.getY()*PRECISION)/(double)PRECISION + ")";
    }
    
    /**
     * Check if this point equals other point.
     * @param other The point to be compared with this point
     * @return True if this point equals other point.
     */
    public boolean equals(Point other)
    {
       return (_radius == other._radius && _alpha == other._alpha);
    }
    
    /**
     * Check if this point is above other point.
     * @param other The point to check if this point is above
     * @return True if this point is above other point.
     */
    public boolean isAbove(Point other)
    {
        return (this.getY() > other.getY());
    }
    
    /**
     * Check if this point is under other point.
     * @param other The point to check if this point is under
     * @return True if this point is under other point.
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }
    
    /**
     * Check if this point is to the left of other point.
     * @param other The point to check if this point is left of
     * @return True if this point is to the left of other point.
     */
    public boolean isLeft(Point other)
    {
        return (this.getX() < other.getX());
    }
    
    /**
     * Check if this point is to the right of other point.
     * @param other The point to check if this point is right of
     * @return True if this point is to the right of other point.
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    }
    
    /**
     * Calculate the distance between this point and other point.
     * @param p The point to calculate the distance from
     * @return The distance between this and p points.
     */
    public double distance (Point p)
    {
        return Math.sqrt(Math.pow(this.getX() - p.getX(),2) + Math.pow(this.getY() - p.getY(),2));
    }
    
    /**
     * Moves the x coordinate by dx and the y coordinate by dy.
     * If movement moves the point outside first quadrant then 
     * the point will remain at the same place and not move.
     * @param dx The amount to move in the x direction
     * @param dy The amount to move in the y direction
     */
    public void move (double dx, double dy)
    {
        if (this.getX()+dx >= DEFAULT_VAL && this.getY()+dy >= DEFAULT_VAL)
            {
                setX(this.getX()+dx);
                setY(this.getY()+dy);
            }
    }
    
    //--------------------------------//
    //       Private Functions:       //
    //--------------------------------//
    
    // Fonction that received x and y coordinates and return radius: 
    private double radiusCalcul(double x, double y)
    {
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
    
    // Fonction that received x and y coordinates and return alpha: 
    private double alphaCalcul(double x, double y)
    {
        if (Math.round(x*PRECISION)/(double)PRECISION == DEFAULT_VAL)
            return DEGREE_90;
        return Math.atan(y/x) / PI * DEGREE_180;
    }
}
