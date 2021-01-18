    
/**
 * This program converts between different temperature units.
 * C-Celsius / F-Fahrenheit / K-Kelvin
 * 
 * Simon Lousky
 * 03/11/2020
 */
    
import java.util.Scanner;
    
public class Temperature
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program converts between different temperature units.");
        System.out.println("What unit measure of the temperature do you want to convert?");
        System.out.println(" - Enter C for Celsius");
        System.out.println(" - Enter F for Fahrenheit");
        System.out.println(" - Enter K for Kelvin");
        
        String answer = scan.next();
        char unit = answer.charAt(0);
        
        final int CONSTANT_C_TO_F = 32;
        final double MULTIPLIER_C_TO_F = 1.8;
        final double CONSTANT_C_TO_K = 273.15;
        
        double temp;
        
        if(unit == 'C')
            {
                System.out.println("Enter the temperature in Celsius:"); 
                temp = scan.nextDouble();
                System.out.println(temp + " C");
                System.out.println((MULTIPLIER_C_TO_F * temp + CONSTANT_C_TO_F) + " F");
                System.out.println((temp + CONSTANT_C_TO_K) + " K");
            }
        else if (unit == 'F')
            {
                System.out.println("Enter the temperature in Fahrenheit:"); 
                temp = scan.nextDouble();
                System.out.println(((temp - CONSTANT_C_TO_F) / MULTIPLIER_C_TO_F) + " C");
                System.out.println(temp + " F");
                System.out.println(((temp - CONSTANT_C_TO_F) / MULTIPLIER_C_TO_F + CONSTANT_C_TO_K) + " K");
            }
        else if (unit == 'K')
            {
                System.out.println("Enter the temperature in Felvin:"); 
                temp = scan.nextDouble();
                System.out.println((temp - CONSTANT_C_TO_K) + " C");
                System.out.println((MULTIPLIER_C_TO_F * (temp - CONSTANT_C_TO_K) + CONSTANT_C_TO_F) + " F");
                System.out.println(temp + " K");
            }
        else
                System.out.println("You entered an invalid unit of temperature.");
    }
}
      
