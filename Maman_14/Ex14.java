/**
 * This class contains the functions of exercise 14.
 *
 * @author Simon Lousky
 * @version 16-01-2021
 */
public class Ex14
{
    // Question 1:
     /**
     * Function findSingle that received a complete array of integers, 
     * where each number appears twice, except one number that appears only once.
     * The function returns the number that appears in the array only once.
     * @param a The received array 
     * @return The number that appears in the array only once
     */
    public static int findSingle (int[] a)
    {
        int low = 0;
        int high = a.length-1;
        int mid = 0;
        boolean found = false;
        
        // Check extremity cases:
        if (a.length == 1)
            return a[0];
        if (a[high] != a[high-1])
            return a[high];
        if (a[low] != a[low+1])
            return a[low];
        
        // The number is in odd place:
        while (!found)
        {
            mid = (low + high) / 2;
            if(a[mid] != a[mid-1] && a[mid] != a[mid+1])
                found = true;
            else if (a[mid] != a[mid-1])
                low = mid;
            else
                high = mid;
        }
        
        return a[mid];
        
        // Running time efficiency = O(log n) 
        // The function divides by 2 the number of cells left to search each time it enters the loop.
        // Place efficiency = O(1)
    }
    
    // Question 2:
    /**
     * Function smallestSubSum that received a complete array
     * of positive integers and a positive number.
     * The function returns the size of the smallest subset
     * in the array whose sum is larger than the given number.
     * If the array is empty or there is no subset whose sum is greater 
     * than the given number, the function returns -1.
     * @param arr The received array
     * @param x The received number 
     * @return The size of the smallest subset that is larger than the number
     */
    public static int smallestSubSum(int arr[], int x)
    {
        int start = 0;
        int end = 0;
        int ans = arr.length + 1;
        int tempSum = x;
        
        while (end < arr.length)
        {
            // Subtract from the received number until the result is negative:
            while (tempSum >= 0 && end < arr.length)
            {
                if (x - arr[end] < 0) // Check if a single number is enough (can save running time)
                    return 1;
                tempSum = tempSum - arr[end];
                end ++;
            }
            // Reduce the size if needed:
            while (tempSum + arr[start] < 0)
            {
                tempSum = tempSum + arr[start];
                start ++;
            }
            // Update minimum length:
            if (end - start < ans && tempSum < 0) 
                ans = end - start;
            tempSum = tempSum + arr[start];
            start ++;
        }
        
        if (ans == arr.length + 1)
            return -1;
        return ans;
        
        // Running time efficiency = O(n) 
        // Place efficiency = O(1)
    }
    
    // Question 3:
    /**
     * Recursive function - solutions that received a positive integers - num.
     * The function returns the number of solutions of the equation x1 + x2 + x3 = num.
     * x's are integers and positive numbers between 1 and 10. 
     * The function also prints these solutions, each solution in a separate line.
     * @param num The received number 
     * @return The number of solutions of the equation x1 + x2 + x3 = num
     */
    public static int solutions(int num)
    {
        if (num < 3 || num > 30)
            return 0;
        // Overloadind:
        return solutions(num, 1, 1, 1);
    }
    
    private static int solutions(int num, int x1, int x2, int x3)
    {   
        int count = 0;          
        
        // Print and count if x1 + x2 + x3 == num:
        if (x1 + x2 + x3 == num) 
        {
            System.out.println(x1 + " + " + x2 + " + " + x3);
            count = 1;
        }                
        
        // Increase x3:
        if (x3 < 10 && x1 + x2 + x3 < num)
            return count + solutions(num, x1, x2, x3 + 1);
        // Increase x2:
        else if (x2 < 10 && x1 + x2 < num - 1) 
            return count + solutions(num, x1, x2 + 1, 1);    
        // Increase x1:
        else if (x1 < 10 && x1 < num - 2)
            return count + solutions(num, x1 + 1, 1, 1);
        
        else
            return count;
    }
    
    // Question 4:
    /**
     * Recursive Function - cntTrueReg that received a boolean matrix 
     * and returns the number of true region in the matrix.
     * A true region in the array is defined by a maximum collection 
     * of adjacent cells that all have true value.
     * Cells located diagonally to each other are not considered adjacent.
     * @param mat The received matrix of boolean
     * @return The number of true region in the matrix
    */ 
    public static int cntTrueReg (boolean[][]mat)
    {
        // If the array size is one: 
        if (mat.length == 0 && mat[0][0])
            return 1;
        if (mat.length == 0 && !mat[0][0])
            return 0;
        // Check the first cell in the array (upper left) and overloadind:
        if (mat.length > 0 && mat[0][0])
            return cntTrueReg (mat, 1, 1);
        return cntTrueReg (mat, 1, 0);
    }
    
    /* Private recursive function that received  the matrix, 
     * the current number of diagonal, and the current count of true region.
     * The function runs on all matrix diagonals (by recursion) 
     * and returns the number of true region in the matrix. 
     * The function uses diagCheck function to calculate 
     * how many true region have been added in the current diagonal.
    */ 
    private static int cntTrueReg (boolean[][]mat, int diagonal, int count)
    {
        // Stop condition:
        if (diagonal == 2 * mat.length - 1)
            return count;
        // If the diagonal is above or equal to the main diagonal:
        if (diagonal < mat.length)
            count = count + diagCheck (mat, 0, diagonal);
        // If the diagonal is under the main diagonal:
        else 
            count = count + diagCheck (mat, diagonal - mat.length + 1, mat.length - 1);
        // Recursive call:
        return cntTrueReg (mat, diagonal + 1, count);
    }    
    
    /* Private recursive function that runs on the diagonal cells
     * and calculate how many true region have been added in the diagonal.
    */
    private static int diagCheck (boolean[][]mat, int i, int j)
    {
        int count = 0;
        // Stop condition:
        if (i < 0 || j < 0 || i == mat.length || j == mat.length)
            return count;
        // If the cell is on the first matrix row:
        else if (i == 0 && !mat[i][j-1] && mat[i][j])
            count ++;
        // If the cell is on the first matrix column:
        else if (j == 0 && !mat[i-1][j] && mat[i][j])  
            count ++;
        // If the cell isn't on the first matrix row or on the first matrix column:
        else if (i > 0 && j > 0 && !mat[i-1][j] && !mat[i][j-1] && mat[i][j])
            count ++;
        // Recursive call:
        return count + diagCheck (mat, i+1, j-1);
    }
    
}
