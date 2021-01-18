
/**
 * This programcalculates the radius, the areas and the perimeters 
 * of the excircle and the incircle of a given rectangle.
 * @author Simon Lousky
 * @version 03/11/2020
 */

import java.util.Scanner;

public class Circle
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println ("This program calculates the areas " +
                            "and the perimeters of the excircle and the incircle " +
                            "of a given rectangle. ");
        System.out.println ("Please enter the two coordinates of the " +
                            "left-upper point of the rectangle:");
        int leftUpX = scan.nextInt();
        int leftUpY = scan.nextInt();
        System.out.println ("Please enter the two coordinates of the " +
                            "right-down point of the rectangle:");
        int rightDownX = scan.nextInt();
        int rightDownY = scan.nextInt();
        final double PI = Math.PI;
        double radius, area, perimeter;
        
        // Calculation of the Incircle:
        radius = (double)(leftUpY - rightDownY) / 2;
        System.out.println("Incircle: radius = " + radius + 
                           ", area = " + (PI * Math.pow(radius,2)) + 
                           ", perimeter = " + (2 * PI * radius));
        // Calculation of the Excircle:
        radius = Math.sqrt(Math.pow(leftUpY-rightDownY,2) + Math.pow(rightDownX-leftUpX,2)) / 2;
        System.out.println("Excircle: radius = " + radius + 
                           ", area = " + (PI * Math.pow(radius,2)) + 
                           ", perimeter = " + (2 * PI * radius));
       
    }
}
