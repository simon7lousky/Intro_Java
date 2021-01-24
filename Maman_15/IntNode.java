
/**
 * This class represents a digit 0-9 node.
 *
 * @author Simon Lousky
 * @version 21-01-2021
 */
public class IntNode
{
    
    //----------------------------//
    //        Declarations:       //
    //----------------------------//
    
    private int _value;
    private IntNode _next;
    
    //----------------------------//
    //        Constructors:       //
    //----------------------------//
    
    /**
     * Construct a digit node with _next equal to null.
     * @param val The value of the digit node
     */
    public IntNode(int val)
    {
        _value = val;
        _next = null;
    }
    
    /**
     * Construct a digit node with _next equal to next.
     * @param val The value of the digit node
     * @param next The next digit node
     */
    public IntNode(int val, IntNode next)
    {
        _value = val;
        _next = next;
    }
    
    //----------------------------//
    //          Methods:          //
    //----------------------------//
    
    /**
     * Return the value of the digit node.
     * @return The value of the digit node
     */
    public int getValue()
    {
        return _value;
    }
    
    /**
     * Set the value of the digit node.
     * @param v The new value of the digit node
     */
    public void setValue(int v)
    {
        _value = v;
    }
    
    /**
     * Return the next digit node.
     * @return The next digit node
     */
    public IntNode getNext()
    {
        return _next;
    }
    
    /**
     * Set the next digit node.
     * @param node The new next digit node
     */
    public void setNext(IntNode node)
    {
        _next = node;
    }
    
    /**
     * Returns a string representation of this digit.
     * @return The string representation of this digit
     */
    public String toString() 
    {
        return ("" + _value);
    }
}
