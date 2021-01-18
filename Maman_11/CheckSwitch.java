

import java.util.Scanner;
public class CheckSwitch
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int num;
        
        System.out.println("Please enter a number:");
        num = scan.nextInt();
        
        switch (num)
        {
            case 1:
            case 2:System.out.println("Update number:" +(num+1)); 
                   break;
            case 3:
            case 4:
            case 5:System.out.println("Update number:" +(num-1)); 
                   break;
            case 6:System.out.println("Update number:" +(num*2)); 
                   break;
            default: System.out.println("Update number:" +(num*3)); 
                     break;
        }
           
         
        
    }
    
}

