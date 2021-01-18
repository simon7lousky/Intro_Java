/**
 * Segment2 represents a line (parallel to the x-axis) using a center point and length.
 *
 * @author Simon Lousky
 * @version 28-11-2020
 */
public class Segment2
{
    //----------------------------//
    //        Declarations:       //
    //----------------------------//
    
    private Point _poCenter;
    private double _length;
    
    //----------------------------//
    //        Constructors:       //
    //----------------------------//
    
    /**
     * Constructs a new segment using two Points. 
     * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * @param left the left point of the segment
     * @param right the right point of the segment
     */
    public Segment2(Point left, Point right)
    {
        if (left.isAbove(right) || left.isUnder(right))
            right.setY(left.getY());
        _length = left.distance(right);
        _poCenter = new Point(left.getX() + _length / 2 , left.getY());
    }
    
    /**
     * Constructs a new segment using 4 specified x y coordinates: two coordinates for the left point and two coordinates for the right point. 
     * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * @param leftX X value of left point
     * @param leftY Y value of left point
     * @param rightX X value of right point
     * @param rightY Y value of right point
     */
    public Segment2(double leftX,double leftY,double rightX ,double rightY)
    {
        if (rightY != leftY)
            rightY = leftY;
        _length = rightX - leftX;
        _poCenter = new Point(leftX + _length / 2, leftY);
    }
    
    /**
     * Copy Constructor. Construct a segment using a reference segment.
     * @param other the reference segment
     */
    public Segment2 (Segment2 other)
    {
        this(other._poCenter, other._length);
    }
    
    /**
     * Constructs a new segment using a center point and the segment length.
     * @param poCenter the Center Point
     * @param length the segment length
     */
    public Segment2 (Point poCenter, double length)
    {
        _length = length;
        _poCenter = new Point(poCenter);
    }
    
    //----------------------------//
    //          Methods:          //
    //----------------------------//
    
     /**
     * Returns the left point of the segment.
     * @return The left point of the segment
     */
    public Point getPoLeft()
    {
        return new Point(_poCenter.getX() - _length / 2, _poCenter.getY());
    }
    
    /**
     * Returns the right point of the segment.
     * @return The right point of the segment
     */
    public Point getPoRight()
    {
        return new Point(_poCenter.getX() + _length / 2, _poCenter.getY());
    }
    
    /**
     * Returns the segment length.
     * @return The segment length
     */
    public double getLength()
    {
        return _length;
    }
    
    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     * @return String representation of this segment
     */
    public String toString()
    {
        return this.getPoLeft() + "---" + this.getPoRight();
    }
    
    /**
     * Check if the reference segment is equal to this segment.
     * @param other the reference segment
     * @return True if the reference segment is equal to this segment
     */
    public boolean equals(Segment2 other)
    {
        return _poCenter.equals(other._poCenter) &&  _length == other._length;
    }
    
    /**
     * Check if this segment is above a reference segment.
     * @param other the reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment2 other)
    {
        return _poCenter.isAbove(other._poCenter);
    }
    
    /**
     * Check if this segment is under a reference segment.
     * @param other the reference segment
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment2 other)
    {
        return other.isAbove(this);
    }
    
    /**
     * Check if this segment is left of a reference segment.
     * @param other the reference segment
     * @return True if this segment is left to the reference segment
     */
    public boolean isLeft(Segment2 other)
    {
        return this.getPoRight().isLeft(other.getPoLeft());
    }
    
    /**
     * Check if this segment is right of a reference segment.
     * @param other the reference segment
     * @return True if this segment is right to the reference segment
     */
    public boolean isRight(Segment2 other)
    {
        return other.isLeft(this);
    }
    
    /**
     * Move the segment horizontally by delta.
     * Will be implemented only for a valid delta
     * @param delta the displacement size
     */
    public void moveHorizontal (double delta)
    {
        if (this.getPoLeft().getX() + delta >=0)
            _poCenter.move(delta,0);
    }
    
    /**
     * Move the segment vertically by delta.
     * Will be implemented only for a valid delta
     * @param delta the displacement size
     */
    public void moveVertical (double delta)
    {
        _poCenter.move(0,delta);
    }
    
    /**
     * Change the segment size by moving the right point by delta. 
     * Will be implemented only for a valid delta: only if the new right point remains the right point.
     * @param delta the length change
     */
    public void changeSize (double delta)
    {
        if (_length + delta >= 0)
        {
            _length = _length + delta;
            _poCenter.move(delta/2,0);
        }
    }
    
    /**
     * Check if a point is located on the segment.
     * @param p a point to be checked
     * @return True if p is on this segment
     */
    boolean pointOnSegment (Point p)
    {
        return p.equals(this.getPoLeft()) || p.equals(this.getPoRight()) || 
               (p.isRight(this.getPoLeft()) && p.isLeft(this.getPoRight()) && p.getY()==_poCenter.getY());
    }
    
    /**
     * Check if this segment is bigger than a reference segment.
     * @param other the reference segment
     * @return True if this segment is bigger than the reference segment
     */
    public boolean isBigger (Segment2 other)
    {
        return _length > other._length;
    }
    
    /**
     * Returns the overlap size of this segment and a reference segment.
     * @param other the reference segment
     * @return The overlap size
     */
    public double overlap (Segment2 other)
    { 
        // If the segments have no overlap:
        if (this.isLeft(other) || this.isRight(other)) 
            return 0;
        return _length + other._length - (max(this.getPoRight().getX(),other.getPoRight().getX()) - min(this.getPoLeft().getX(),other.getPoLeft().getX()));
    }
    
      /**
     * Compute the trapeze perimeter, which is constructed by this segment and a reference segment.
     * @param other the reference segment
     * @return The trapeze perimeter
     */
    public double trapezePerimeter (Segment2 other)
    {
        return _length + other._length + this.getPoRight().distance(other.getPoRight()) + this.getPoLeft().distance(other.getPoLeft());
    }
    
    //--------------------------------//
    //       Private Functions:       //
    //--------------------------------//
    
    // Max function between 2 numbers: 
    private static double max(double a, double b)
    {
        double max = a;
        if (b > max)
            max = b;
        return max;
    }
    
    // Min function between 2 numbers: 
    private static double min(double a, double b)
    {
        double min = a;
        if (b < min)
            min = b;
        return min;
    }
}


