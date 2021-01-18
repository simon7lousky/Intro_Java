/**
 * Segment1 represents a line (parallel to the x-axis) using two Points.
 *
 * @author Simon Lousky
 * @version 28-11-2020
 */
public class Segment1
{
    //----------------------------//
    //        Declarations:       //
    //----------------------------//
    
    private Point _poLeft;
    private Point _poRight;
    
    //----------------------------//
    //        Constructors:       //
    //----------------------------//
    
    /**
     * Constructs a new segment using two Points. 
     * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * @param left the left point of the segment
     * @param right the right point of the segment
     */
    public Segment1(Point left, Point right)
    {
        if (left.isAbove(right) || left.isUnder(right))
            right.setY(left.getY());
        _poLeft = new Point(left);
        _poRight = new Point(right);
    }
    
    /**
     * Constructs a new segment using 4 specified x y coordinates: 
     * Two coordinates for the left point and two coordinates for the right point. 
     * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * @param leftX X value of left point
     * @param leftY Y value of left point
     * @param rightX X value of right point
     * @param rightY Y value of right point
     */
    public Segment1(double leftX,double leftY,double rightX ,double rightY)
    {
        if (rightY != leftY)
            rightY = leftY;
        _poLeft = new Point(leftX,leftY);
        _poRight = new Point(rightX,rightY);
    }
    
    /**
     * Copy Constructor. Construct a segment using a reference segment.
     * @param other the reference segment
     */
    public Segment1 (Segment1 other)
    {
        _poLeft = new Point(other._poLeft);
        _poRight = new Point(other._poRight);
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
        return new Point(_poLeft);
    }
    
    /**
     * Returns the right point of the segment.
     * @return The right point of the segment
     */
    public Point getPoRight()
    {
        return new Point(_poRight);
    }
    
    /**
     * Returns the segment length.
     * @return The segment length
     */
    public double getLength()
    {
        return _poLeft.distance(_poRight);
    }
    
    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     * @return String representation of this segment
     */
    public String toString()
    {
        return _poLeft + "---" + _poRight;
    }
    
    /**
     * Check if the reference segment is equal to this segment.
     * @param other the reference segment
     * @return True if the reference segment is equal to this segment
     */
    public boolean equals(Segment1 other)
    {
        return _poLeft.equals(other._poLeft) &&  _poRight.equals(other._poRight);
    }
    
    /**
     * Check if this segment is above a reference segment.
     * @param other the reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment1 other)
    {
        return _poLeft.isAbove(other._poLeft);
    }
    
    /**
     * Check if this segment is under a reference segment.
     * @param other the reference segment
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment1 other)
    {
        return other.isAbove(this);
    }
    
    /**
     * Check if this segment is left of a reference segment.
     * @param other the reference segment
     * @return True if this segment is left to the reference segment
     */
    public boolean isLeft(Segment1 other)
    {
        return _poRight.isLeft(other._poLeft);
    }
    
    /**
     * Check if this segment is right of a reference segment.
     * @param other the reference segment
     * @return True if this segment is right to the reference segment
     */
    public boolean isRight(Segment1 other)
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
        if (_poLeft.getX() + delta >=0)
        {
            _poLeft.move(delta,0);
            _poRight.move(delta,0);
        }
    }
    
    /**
     * Move the segment vertically by delta.
     * Will be implemented only for a valid delta
     * @param delta the displacement size
     */
    public void moveVertical (double delta)
    {
        _poLeft.move(0,delta);
        _poRight.move(0,delta);
    }
    
    /**
     * Change the segment size by moving the right point by delta. 
     * Will be implemented only for a valid delta: only if the new right point remains the right point.
     * @param delta the length change
     */
    public void changeSize (double delta)
    {
        if (this.getLength() + delta >= 0)
            _poRight.move(delta,0);
    }
    
    /**
     * Check if a point is located on the segment.
     * @param p a point to be checked
     * @return True if p is on this segment
     */
    boolean pointOnSegment (Point p)
    {
        return p.equals(_poLeft) || p.equals(_poRight) || (p.isRight(_poLeft) && p.isLeft(_poRight) && p.getY()==_poLeft.getY());
    }
    
    /**
     * Check if this segment is bigger than a reference segment.
     * @param other the reference segment
     * @return True if this segment is bigger than the reference segment
     */
    public boolean isBigger (Segment1 other)
    {
        return this.getLength() > other.getLength();
    }
    
    /**
     * Returns the overlap size of this segment and a reference segment.
     * @param other the reference segment
     * @return The overlap size
     */
    public double overlap (Segment1 other)
    {
        if (this.isLeft(other) || this.isRight(other))
            return 0;
        return this.getLength() + other.getLength() - (max(this._poRight.getX(),other._poRight.getX()) - min(this._poLeft.getX(),other._poLeft.getX()));
    }
    
    /**
     * Compute the trapeze perimeter, which is constructed by this segment and a reference segment.
     * @param other the reference segment
     * @return The trapeze perimeter
     */
    public double trapezePerimeter (Segment1 other)
    {
        return this.getLength() + other.getLength() + _poRight.distance(other._poRight) + _poLeft.distance(other._poLeft);
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
