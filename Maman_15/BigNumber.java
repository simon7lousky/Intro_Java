
/**
 * This class represents a big positive number by one-way list of digit (IntNode).
 *
 * @author Simon Lousky
 * @version 23-01-2021
 */
public class BigNumber
{
    
    //----------------------------//
    //        Declarations:       //
    //----------------------------//
    
    private IntNode _head;
    
    //----------------------------//
    //        Constructors:       //
    //----------------------------//
    
    /**
     * Empty constructor - initializes the list with one IntNode whose value is zero.
     */
    public BigNumber()
    {
        _head = new IntNode(0);
    }
    
    /**
     * Constructor that receives a long type number and stores it in a BigNumber list.
     * @param num The long type number
     */
    public BigNumber(long num)
    {
        int temp = (int)(num % 10);
        _head = new IntNode(temp);
        IntNode ptr = _head;
        num = num / 10;
        
        while (num != 0)
        {
            temp = (int)(num % 10);
            ptr.setNext(new IntNode(temp)); 
            ptr = ptr.getNext();
            num = num / 10;
        }
        // Running time efficiency = O(n) 
        // Place efficiency = O(1)
    }
    
    /**
     * Copy constructor
     * @param other The other BigNumber
     */
    public BigNumber(BigNumber other)
    {
        this._head = new IntNode(other._head.getValue());
        IntNode ptrThis = this._head;
        IntNode ptrOther = other._head.getNext();
        
        while (ptrOther != null)
        {
            ptrThis.setNext(new IntNode(ptrOther.getValue())); 
            ptrThis = ptrThis.getNext();
            ptrOther = ptrOther.getNext();
        }
        // Running time efficiency = O(n) 
        // Place efficiency = O(1)
    }
    
    //----------------------------//
    //          Methods:          //
    //----------------------------//
    
    /**
     * Returns a string representation of this big number.
     * @return The string representation of this big number
     */
    public String toString()
    {
        IntNode ptr = _head;
        String st = "" + ptr.getValue();
        return toString(st, ptr.getNext());
    }
    
    // Private Overloading Method:
    private String toString(String st, IntNode ptr)
    {
        if (ptr==null)
            return st;
        return  toString(ptr.getValue() + st, ptr.getNext());
        // Running time efficiency = O(n) 
        // Place efficiency = O(1)
    }
    
    /**
     * Compare two big numbers. 
     * If this big number is smaller than the big number obtained as a parameter, the value -1 will be returned.
     * If this big number is greater than the big number obtained as a parameter, the value 1 will be returned.
     * If the two big numbers are equal, the value 0 will be returned.
     *
     * @param other The big number obtained as a parameter
     * @return The value (1/-1/0) depend on the comparison.
     */
    public int compareTo (BigNumber other)
    {
        if (this.length() > other.length())
            return 1;
        else if (this.length() < other.length())
            return -1;
        
        BigNumber thisCopy = new BigNumber(this); 
        BigNumber otherCopy = new BigNumber (other);
        IntNode ptrThis = thisCopy._head;
        IntNode ptrOther = otherCopy._head;
        
        if (ptrThis.getNext() == null && ptrThis.getValue() > ptrOther.getValue())
            return 1;
        if (ptrThis.getNext() == null && ptrThis.getValue() < ptrOther.getValue())
            return -1;
            
        while (ptrThis.getNext() != null)
        {
            if (ptrThis.getNext().getNext() == null && ptrThis.getNext().getValue() > ptrOther.getNext().getValue())
                return 1;
            if (ptrThis.getNext().getNext() == null && ptrThis.getNext().getValue() < ptrOther.getNext().getValue())
                return -1;    
            if (ptrThis.getNext().getNext() == null)
            {
                ptrThis.setNext(null);
                ptrThis = thisCopy._head;
                ptrOther.setNext(null);
                ptrOther = otherCopy._head;
            }
            else
            {
                ptrThis = ptrThis.getNext();
                ptrOther = ptrOther.getNext();
            }
        }
        return 0;    
        // Running time efficiency = O(n^2) 
        // Place efficiency = O(1)
    }
    
    // Private function that compute the length of the big number:
    private int length()
    {
        IntNode temp = _head;
        int count = 0;
        while (temp != null)
        {
            count ++;
            temp = temp.getNext();
        }
        return count;
    }
    
    /**
     * Addition of two big numbers. The method receives as parameter a other big number 
     * and returns the addition result of this big number and the other big number.
     * @param other The big number obtained as a parameter
     * @return The addition result as new BigNumber object
     */
    public BigNumber addBigNumber (BigNumber other)
    {
        BigNumber result = new BigNumber();
        // Set Pointer in each list:
        IntNode ptrResult = result._head;
        IntNode ptrThis = this._head;
        IntNode ptrOther = other._head;
        // Create decimal help variable:
        int decimal_add = 0;
        
        while (ptrThis != null || ptrOther != null)
        {
            // If this length list shorter than other length list:
            if (ptrThis == null && ptrOther != null)
            {
                ptrResult.setValue((ptrOther.getValue() + decimal_add) % 10);
                if ((ptrOther.getValue() + decimal_add) >= 10)
                    decimal_add = 1;
                else 
                    decimal_add = 0;
                ptrOther = ptrOther.getNext();
            }
            // If other length list shorter than this list:
            else if (ptrThis != null && ptrOther == null)
            {
                ptrResult.setValue((ptrThis.getValue() + decimal_add) % 10);
                if ((ptrThis.getValue() + decimal_add) >= 10)
                    decimal_add = 1;
                else 
                    decimal_add = 0;
                ptrThis = ptrThis.getNext();
            }
            // If the two lists have the same length:
            else
            {
                ptrResult.setValue((ptrThis.getValue() + ptrOther.getValue() + decimal_add) % 10);
                if ((ptrThis.getValue() + ptrOther.getValue() + decimal_add) >= 10)
                    decimal_add = 1;
                else 
                    decimal_add = 0;
                ptrThis = ptrThis.getNext();
                ptrOther = ptrOther.getNext();
            }        
            // Advance the pointer if needed:
            if (ptrThis != null || ptrOther != null)
            {
                ptrResult.setNext(new IntNode(0));
                ptrResult = ptrResult.getNext();
            }
            // Add decimal digit if needed:
            if (ptrThis == null && ptrOther == null && decimal_add == 1) 
                ptrResult.setNext(new IntNode(decimal_add));
        }
        return result;
        // Running time efficiency = O(n) 
        // Place efficiency = O(1)
    }
    
    /**
     * Addition of this big number and long type number. 
     * The method receives as parameter a long type number and returns 
     * the addition result of this big number and the other long type number.
     * @param other The long type number obtained as a parameter
     * @return The addition result as new BigNumber object
     */
    public BigNumber addLong (long num)
    {
        BigNumber other = new BigNumber(num);
        return addBigNumber (other);
        // Running time efficiency = O(n) 
        // Place efficiency = O(1)
    }
    
    /**
     * Substraction of two big numbers. The method receives as parameter a 
     * other big number and returns the substraction result (abs).
     * @param other The big number obtained as a parameter
     * @return The substraction result as new BigNumber object
     */
    public BigNumber subtractBigNumber (BigNumber other)
    {
        IntNode ptrBig, ptrSmall, ptrResult;
        BigNumber result;
        if (this.compareTo(other) == 1)
        {
            ptrBig = this._head;
            ptrSmall = other._head;
            result = new BigNumber(this);
            ptrResult = result._head;
        }
        else 
        {
            ptrBig = other._head;
            ptrSmall = this._head;
            result = new BigNumber(other);
            ptrResult = result._head;
        }
        // Create decimal help variable:
        int decimal_sub = 0;
        
        while (ptrBig != null || ptrSmall != null)
        {
            if (ptrBig != null && ptrSmall == null)
            {
                if (ptrBig.getValue() < decimal_sub)
                {
                    ptrResult.setValue(ptrBig.getValue() + 10 - decimal_sub);
                    decimal_sub = 1; 
                }
                else
                {
                    ptrResult.setValue(ptrBig.getValue() - decimal_sub);
                    decimal_sub = 0;
                }
            }
            if (ptrBig != null && ptrSmall != null) 
            {
                if (ptrBig.getValue() < (ptrSmall.getValue() + decimal_sub))
                {
                    ptrResult.setValue(ptrBig.getValue() + 10 - ptrSmall.getValue() - decimal_sub);
                    decimal_sub = 1;
                }
                else
                {
                    ptrResult.setValue(ptrBig.getValue() - ptrSmall.getValue() - decimal_sub);
                    decimal_sub = 0;
                }
                ptrSmall = ptrSmall.getNext();
            }
            ptrBig = ptrBig.getNext();
            ptrResult = ptrResult.getNext();
            // Substrat decimal digit in the beginning: 
            if (decimal_sub == 1 && ptrBig == null && ptrSmall == null)
                ptrResult.setValue(ptrBig.getValue() - decimal_sub);
        }
            result.removeZeros();
            return result;
            // Running time efficiency without removeZeros function = O(n) 
            // Place efficiency = O(1)
    }
    
    // Private function that removes zeros from the left side of the BigNumber:
    private void removeZeros()
    {
        IntNode ptr = this._head;
        while (ptr.getNext() != null)
        {
            if (ptr.getNext().getNext() == null && ptr.getNext().getValue() == 0)
            {
                ptr.setNext(null);
                ptr = this._head;
            }
            else
                ptr = ptr.getNext();
        }
        // Running time efficiency = O(n^2) 
        // Place efficiency = O(1)
    }
    
    /**
     * Multiplication of two big numbers. The method receives as parameter a 
     * other big number and returns the multiplication result.
     * @param other The big number obtained as a parameter
     * @return The multiplication result as new BigNumber object
     */
    public BigNumber multBigNumber (BigNumber other)
    {
        BigNumber tempNum, zeroNum, oneNum, result;
        tempNum = new BigNumber(other);
        zeroNum = new BigNumber();
        oneNum = new BigNumber(1);
        result = new BigNumber();
        
        while (tempNum.compareTo(zeroNum) != 0)
        {
            result = result.addBigNumber(this);
            tempNum = tempNum.subtractBigNumber(oneNum);
        }
        return result;
        // Running time efficiency = O(n^2) 
        // Place efficiency = O(1)
    }
}
     
   

    
    
    
    
    
    
    
    
    
    

