import java.util.Scanner;

public class Main 
{
    
    
    public static void fibonacci(int n) 
    {
    
        int prev1 = 0, prev2 = 1; 
        System.out.print(prev2); 
        
        for (int i = 1; i < n; i++)
        {
            prev2 = prev1 + prev2;
            prev1 = prev2 - prev1;
            System.out.print(", " + prev2); 
        }
        
    }
    
    public static void main(String[] args) {
        System.out.print("Call to fibonacci(1) prints:\n"); 
        fibonacci(1);
        System.out.print("\nCall to fibonacci(2) prints:\n"); 
        fibonacci(2);
        System.out.print("\nCall to fibonacci(3) prints:\n"); 
        fibonacci(3);
        System.out.print("\nCall to fibonacci(5) prints:\n"); 
        fibonacci(5);
        System.out.print("\nCall to fibonacci(9) prints:\n"); 
        fibonacci(9);
    }
}