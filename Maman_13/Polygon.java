
/**
 * This class represents a Polygon object by an array of appropriate Point objects.
 * Maximum Polygon size is 10 vertices.
 * 
 * @author Simon Lousky
 * @version 07-12-2020
 */
public class Polygon
{
    
    //----------------------------//
    //        Declarations:       //
    //----------------------------//
    
    private Point[] _vertices;
    private int _noOfVertices;
    private static final int MAX_SIZE = 10;
    
    //----------------------------//
    //        Constructors:       //
    //----------------------------//
    
    /**
     * Construct a Polygon. 
     * During the construction phase, the polygon is empty.
     */
    public Polygon()
    {
        _vertices = new Point[MAX_SIZE];
        _noOfVertices = 0;
    } 
    
    //----------------------------//
    //          Methods:          //
    //----------------------------//
    
    /**
     * Method addVertex add new appropriate Point in this vertices array - this Polygon.
     * If the method succeed to add the Point, returns true, otherwise false.
     * @param x The x new Point coordinate 
     * @param y The y new Point coordinate
     * @return If the method succeed to add the Point
     */
    public boolean addVertex(double x, double y)
    {
        if (_noOfVertices < MAX_SIZE)
        {
            _vertices[_noOfVertices] = new Point(x,y);
            _noOfVertices ++;
            return true;
        }
        return false;
    }
    
    /**
     * Method highestVertex returns the highest vertice in this Polygon.
     * If there are more than one, the method returns the first one it find.
     * If there are no vertices, the method returns null.
     * @return The highest vertice in this Polygon
     */
    public Point highestVertex()
    {
        if (_noOfVertices == 0)
            return null;
        int indexMax = 0;
        for (int i = 1 ; i < _noOfVertices ; i++)
        {
            if (_vertices[i].isAbove(_vertices[indexMax]))
                indexMax = i;
        }
        return new Point(_vertices[indexMax]);
    }    
    
    /**
     * Returns a string representation of this Polygon.
     * @return String representasion of this Polygon
     */
    public String toString()
    {
        if (_noOfVertices == 0)
            return "The polygon has 0 vertices.";
        String result = "The polygon has " + _noOfVertices + " vertices:\n(" + _vertices[0];
        for (int i = 1 ; i < _noOfVertices; i++)
        {
            result += "," + _vertices[i];
        }
        return result + ")";
    }
    
    /**
     * Method calcPerimeter calculates and returns the Polygon perimeter.
     * If there are less than two Point in the array, the method return 0.
     * If there are two Point in the array, the method return the distance between them.
     * @return The Polygon perimeter
     */
    public double calcPerimeter()
    {
        if (_noOfVertices < 2)
            return 0;
        else if (_noOfVertices == 2)
            return _vertices[0].distance(_vertices[1]);
        double perimeter =  _vertices[0].distance(_vertices[_noOfVertices-1]);
        for (int i = 1 ; i < _noOfVertices ; i++)
        {
            perimeter += _vertices[i].distance(_vertices[i-1]);
        }
        return perimeter;
    }
    
    /**
     * Method calcArea calculates and returns the Polygon area.
     * If there are less than three Point in the array, the method return 0.
     * @return The Polygon area
     */
    public double calcArea()
    {
        double area = 0;
        if (_noOfVertices < 3)
            return area;
        for (int i = 1 ; i < _noOfVertices-1 ; i++)
        {
            area += areaTriangle(_vertices[0], _vertices[i], _vertices[i+1]); // Using a private method areaTriangle
        }
        return area;
    }
    
    /**
     * Method isBigger checks if this Polygon area is bigger than a reference Polygon area.
     * @param other The reference Polygon
     * @return True if this Polygon area is bigger than a reference Polygon area
     */
    public boolean isBigger(Polygon other)
    {
        return this.calcArea() > other.calcArea();
    }
    
    /**
     * Method findVertex receives a Point and returns his place in the vertices array.
     * If the Point is not in the vertices array, the method returns -1.
     * @param p The Point to find his index in the vertices array
     * @return The index of the Point in the vertices array
     */
    public int findVertex(Point p)
    {
        int index = -1;
        for (int i = 0 ; i < _noOfVertices ; i++)
        {
            if (_vertices[i].equals(p))
            {
                index = i;
                return index;
            }
        }    
        return index;
    }
    
    /**
     * Method getNextVertex receives a Point and returns the next Point relative to him in the vertices array.
     * If the Point is not in the vertices array, the method returns null.
     * If the Point is the last in the vertices array, the method returns the first Point in the vertices array.
     * If the Point is the only one in the vertices array, the method returns the Point.
     * @param p The Point to which the function returns the next point
     * @return The next Point relative to the Point received
     */
    public Point getNextVertex(Point p)
    {
        int index = this.findVertex(p);
        if (index == -1)
            return null;
        else if (index == _noOfVertices-1 || _noOfVertices == 1)
            return new Point(_vertices[0]);
        return new Point(_vertices[index + 1]);
    }
    
    /**
     * Method getBoundingBox Returns the bounding rectangle of the polygon.
     * The method returns the bounding rectangle as a Polygon object.
     * If there are less than three Point in the array, the method returns null.
     * @return The bounding rectangle as a Polygon object.
     */
    public Polygon getBoundingBox()
    {
        if (_noOfVertices < 3)
            return null;
        int indexMax = 0;
        int indexMin = 0;
        int indexRight = 0;
        int indexLeft = 0;
        for (int i = 1 ; i < _noOfVertices ; i++)
        {
            if (_vertices[i].isAbove(_vertices[indexMax]))
                indexMax = i;
            if (_vertices[i].isUnder(_vertices[indexMin]))
                indexMin = i;
            if (_vertices[i].isRight(_vertices[indexRight]))
                indexRight = i;
            if (_vertices[i].isLeft(_vertices[indexLeft]))
                indexLeft = i;
        }
        Polygon boundingBox = new Polygon();
        boundingBox.addVertex(_vertices[indexLeft].getX(),_vertices[indexMin].getY());
        boundingBox.addVertex(_vertices[indexRight].getX(),_vertices[indexMin].getY());
        boundingBox.addVertex(_vertices[indexRight].getX(),_vertices[indexMax].getY());
        boundingBox.addVertex(_vertices[indexLeft].getX(),_vertices[indexMax].getY());
        return boundingBox;
    }
    
    //--------------------------------//
    //       Private Functions:       //
    //--------------------------------//
    
    // Fonction that received 3 Points and return triangle area between them (by Heron): 
    private static double areaTriangle(Point Point1, Point Point2, Point Point3)
    {
        double a = Point1.distance(Point2);
        double b = Point2.distance(Point3);
        double c = Point3.distance(Point1); 
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}    