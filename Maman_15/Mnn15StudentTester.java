public class Mnn15StudentTester 
{
    public static void main(String[] args) 
    {
        System.out.println("************************ MMN 15 TEST START **************************");
        
        //----------------------------//
        //      Test Construtors      // 
        //----------------------------//
        
        System.out.println("***** b1 = new  BigNumber() = ");
        BigNumber b1 = new BigNumber();
        System.out.println(b1);
        
        System.out.println("\n***** b2 = new BigNumber(0) = ");
        BigNumber b2 = new BigNumber(0);
        System.out.println(b2);
        
        System.out.println("\n***** b3 = new BigNumber(1234567895432L) = ");
        BigNumber b3 = new BigNumber(1234567895432L);
        System.out.println(b3);
        
        System.out.println("\n****** b4 = new BigNumber(b3) = ");
        BigNumber b4 = new BigNumber(b3);
        System.out.println(b4);
        
        System.out.println("\n****** b5 = new BigNumber(123) = ");
        BigNumber b5 = new BigNumber(123);
        System.out.println(b5);
        
        System.out.println("\n***** b6 = new BigNumber(456) = ");
        BigNumber b6 = new BigNumber(456);
        System.out.println(b6);
        
        System.out.println("\n***** b7 = new BigNumber(785) = ");
        BigNumber b7 = new BigNumber(785);
        System.out.println(b7);
        
        //----------------------------//
        //    Test method compareTo   //
        //----------------------------//
        
        System.out.println("\n****** comp = b1.compareTo(b2) = ");
        System.out.println("***** b1 = " + b1);
        System.out.println("***** b2 = " + b2);
        int comp = b1.compareTo(b2);
        System.out.println(comp);
        
        System.out.println("\n****** comp = b3.compareTo(b4) = ");
        System.out.println("***** b3 = " + b3);
        System.out.println("***** b4 = " + b4);
        comp = b3.compareTo(b4);
        System.out.println(comp);
        
        System.out.println("\n****** comp = b3.compareTo(b1) = ");
        System.out.println("***** b3 = " + b3);
        System.out.println("***** b1 = " + b1);
        comp = b3.compareTo(b1);
        System.out.println(comp);
        
        System.out.println("\n****** comp = b2.compareTo(b3) = ");
        System.out.println("***** b2 = " + b2);
        System.out.println("***** b3 = " + b3);
        comp = b2.compareTo(b3);
        System.out.println(comp);
        
        System.out.println("\n****** comp = b3.compareTo(b5) = ");
        System.out.println("***** b3 = " + b3);
        System.out.println("***** b5 = " + b5);
        comp = b3.compareTo(b5);
        System.out.println(comp);
        
        System.out.println("\n****** comp = b5.compareTo(b3) = ");
        System.out.println("***** b5 = " + b5);
        System.out.println("***** b3 = " + b3);
        comp = b5.compareTo(b3);
        System.out.println(comp);
        
        System.out.println("\n****** comp = b6.compareTo(b7) = ");
        System.out.println("***** b6 = " + b6);
        System.out.println("***** b7 = " + b7);
        comp = b6.compareTo(b7);
        System.out.println(comp);
        
        System.out.println("\n****** comp = b7.compareTo(b6) = ");
        System.out.println("***** b7 = " + b7);
        System.out.println("***** b6 = " + b6);
        comp = b7.compareTo(b6);
        System.out.println(comp);
        
        //----------------------------//
        //  Test method addBigNumber  //
        //----------------------------//
        
        System.out.println("\n****** b8 = b6.addBigNumber(b7) = ");
        System.out.println("***** b6 = " + b6);
        System.out.println("***** b7 = " + b7);
        BigNumber b8 = b6.addBigNumber(b7);
        System.out.println(b8);
        
        System.out.println("\n****** b9 = b5.addBigNumber(b5) = ");
        System.out.println("****** b5 = " + b5);
        BigNumber b9 = b5.addBigNumber(b5);
        System.out.println(b9);
        
        System.out.println("\n****** b10 = b1.addBigNumber(b3) = ");
        System.out.println("***** b1 = " + b1);
        System.out.println("***** b3 = " + b3);
        BigNumber b10 = b1.addBigNumber(b3);
        System.out.println(b10);
        
        System.out.println("\n****** b11 = b1.addBigNumber(b1) = ");
        System.out.println("***** b1 = " + b1);
        BigNumber b11 = b1.addBigNumber(b1);
        System.out.println(b11);
        
        BigNumber b12 = new BigNumber(99999);
        System.out.println("\n****** b13 = b6.addBigNumber(b12) = ");
        System.out.println("***** b6 = " + b6);
        System.out.println("***** b12 = " + b12);
        BigNumber b13 = b6.addBigNumber(b12);
        System.out.println(b13);
        System.out.println("****** b14 = b12.addBigNumber(b6) = ");
        BigNumber b14 = b12.addBigNumber(b6);
        System.out.println(b14);
        
        System.out.println("\n****** b15 = b3.addLong(123456789L) = ");
        System.out.println("***** b3 = " + b3);
        BigNumber b15 = b3.addLong(123456789L);
        System.out.println(b15);
        
        BigNumber b25 = new BigNumber(198);
        BigNumber b26 = new BigNumber(22);
        System.out.println("\n****** b27 = b25.addBigNumber(b26) = ");
        System.out.println("***** b25 = " + b25);
        System.out.println("***** b26 = " + b26);
        BigNumber b27 = b25.addBigNumber(b26);
        System.out.println(b27);
        
        //---------------------------------//
        //  Test method subtractBigNumber  //
        //---------------------------------//
        
        System.out.println("\n****** b16 = b6.subtractBigNumber(b7) = ");
        System.out.println("***** b6 = " + b6);
        System.out.println("***** b7 = " + b7);
        BigNumber b16 = b6.subtractBigNumber(b7);
        System.out.println(b16);
        
        System.out.println("\n****** b17 = b6.subtractBigNumber(b6) = ");
        System.out.println("***** b6 = " + b6);
        BigNumber b17 = b6.subtractBigNumber(b6);
        System.out.println(b17);
        
        System.out.println("\n****** b18 = b12.subtractBigNumber(b2) = ");
        System.out.println("***** b12 = " + b12);
        System.out.println("***** b2 = " + b2);
        BigNumber b18 = b12.subtractBigNumber(b2);
        System.out.println(b18);
        
        System.out.println("\n****** b19 = b3.subtractBigNumber(b15) = ");
        System.out.println("***** b3 = " + b3);
        System.out.println("***** b15 = " + b15);
        BigNumber b19 = b3.subtractBigNumber(b15);
        System.out.println(b19);
        
        BigNumber b20 = new BigNumber(56);
        System.out.println("\n****** b21 = b20.subtractBigNumber(b5) = ");
        System.out.println("****** b5 = " + b5);
        System.out.println("****** b20 = " + b20);
        BigNumber b21 = b20.subtractBigNumber(b5);
        System.out.println(b21);
        
        //---------------------------------//
        //    Test method multBigNumber    //
        //---------------------------------//
        
        BigNumber b22 = new BigNumber(1234);
        BigNumber b23 = new BigNumber(10000);
        System.out.println("\n****** b24 = b22.multBigNumber(b23) = ");
        System.out.println("***** b22 = " + b22);
        System.out.println("***** b23 = " + b23);
        BigNumber b24 = b22.multBigNumber(b23);
        System.out.println(b24);
        
       
        System.out.println("\n************************ MMN 15 TEST END **************************");

    }

}
