public class Ex14StudentTester
{
    public static void main()
    {
        //**********************************************************************************************//
        System.out.println ("********** Question 1 **********\n");
        
        int studentResult;
        int[] array1 = {6,6,18,18,-4,-4,12,9,9};
        System.out.println("Checking method findSingle on array [6,6,18,18,-4,-4,12,9,9]\n");
        studentResult= Ex14.findSingle(array1);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array2 = {8,8,-7,-7,3,3,0,0,10,10,5,5,4};
        System.out.println("Checking method findSingle on array [8,8,-7,-7,3,3,0,0,10,10,5,5,4]\n");
        studentResult= Ex14.findSingle(array2);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array3 = {5};
        System.out.println("Checking method findSingle on array [5]\n");
        studentResult= Ex14.findSingle(array3);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array4 = {7,4,4};
        System.out.println("Checking method findSingle on array [7,4,4]\n");
        studentResult= Ex14.findSingle(array4);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array5 = {0,0,8};
        System.out.println("Checking method findSingle on array [0,0,8]\n");
        studentResult= Ex14.findSingle(array5);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        //**********************************************************************************************//
        System.out.println ("********** Question 2 **********\n");
        
        int[] array6 = {1,4,45,6,0,19};
        int x = 51;
        System.out.println("Checking method smallestSubSum on array [1,4,45,6,0,19] and value 51\n");
        studentResult= Ex14.smallestSubSum(array6,x);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array7 = {1,10,5,2,7};
        x = 9;
        System.out.println("Checking method smallestSubSum on array [1,10,5,2,7] and value 9\n");
        studentResult= Ex14.smallestSubSum(array7,x);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array8 = {1,11,100,1,0,200,3,2,1,250};
        x = 280;
        System.out.println("Checking method smallestSubSum on array [1,11,100,1,0,200,3,2,1,250] and value 280\n");
        studentResult= Ex14.smallestSubSum(array8,x);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array9 = {45,6,0};
        x = 51;
        System.out.println("Checking method smallestSubSum on array [45,6,0] and value 51\n");
        studentResult= Ex14.smallestSubSum(array9,x);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array10 = {52};
        x = 51;
        System.out.println("Checking method smallestSubSum on array [52] and value 51\n");
        studentResult= Ex14.smallestSubSum(array10,x);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array11 = {50};
        x = 51;
        System.out.println("Checking method smallestSubSum on array [50] and value 51\n");
        studentResult= Ex14.smallestSubSum(array11,x);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array12 = {45,6,0,1};
        x = 51;
        System.out.println("Checking method smallestSubSum on array [45,6,0,1] and value 51\n");
        studentResult= Ex14.smallestSubSum(array12,x);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        int[] array13 = {};
        x = 51;
        System.out.println("Checking method smallestSubSum on array [] and value 51\n");
        studentResult= Ex14.smallestSubSum(array13,x);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        //**********************************************************************************************//
        System.out.println ("********** Question 3 **********\n");

        System.out.println("Checking method solutions with number 5\n");

        studentResult= Ex14.solutions(3);
        System.out.println();
        System.out.println("Result of num 3 is: "+studentResult);
        System.out.println();
        
        studentResult= Ex14.solutions(4);
        System.out.println();
        System.out.println("Result of num 4 is: "+studentResult);
        System.out.println();
        
        studentResult= Ex14.solutions(5);
        System.out.println();
        System.out.println("Result of num 5 is: "+studentResult);
        System.out.println();
        
        studentResult= Ex14.solutions(7);
        System.out.println();
        System.out.println("Result of num 7 is: "+studentResult);
        System.out.println();
        
        studentResult= Ex14.solutions(13);
        System.out.println();
        System.out.println("Result of num 13 is: "+studentResult);
        System.out.println();
        
        studentResult= Ex14.solutions(20);
        System.out.println();
        System.out.println("Result of num 20 is: "+studentResult);
        System.out.println();
        
        studentResult= Ex14.solutions(29);
        System.out.println();
        System.out.println("Result of num 29 is: "+studentResult);
        System.out.println();
        
        studentResult= Ex14.solutions(1);
        System.out.println();
        System.out.println("Result of num 1 is: "+studentResult);
        System.out.println();
        
        studentResult= Ex14.solutions(31);
        System.out.println();
        System.out.println("Result of num 31 is: "+studentResult);
        System.out.println();
        
        //**********************************************************************************************//
        System.out.println("********** Question 4**********\n");

        boolean[][] mat1 = {
                {false,false,false,false,true},
                {false,true,true,true,false},
                {false,false,true,true,false},
                {true,false,false,false,false},
                {true,true,false,false,false},
            };

        System.out.println ("Checking method cntTrueReg with the matrix:\n");
        printMat (mat1);

        int studentCntRegResult=Ex14.cntTrueReg(mat1);
        System.out.println();
        System.out.println("Result of mat1 is: "+studentCntRegResult);
        
        boolean[][] mat2 = {
                {true,false,true,false,true},
                {false,true,false,true,false},
                {true,false,true,false,true},
                {false,true,false,true,false},
                {true,false,true,false,true},
            };

        System.out.println ("Checking method cntTrueReg with the matrix:\n");
        printMat (mat2);

        studentCntRegResult=Ex14.cntTrueReg(mat2);
        System.out.println();
        System.out.println("Result of mat2 is: "+studentCntRegResult);
        
        boolean[][] mat3 = {{true}};

        System.out.println ("Checking method cntTrueReg with the matrix:\n");
        printMat (mat3);

        studentCntRegResult=Ex14.cntTrueReg(mat3);
        System.out.println();
        System.out.println("Result of mat3 is: "+studentCntRegResult);
        
        boolean[][] mat4 = {{false}};

        System.out.println ("Checking method cntTrueReg with the matrix:\n");
        printMat (mat4);

        studentCntRegResult=Ex14.cntTrueReg(mat4);
        System.out.println();
        System.out.println("Result of mat4 is: "+studentCntRegResult);
        
        boolean[][] mat5 = {{true,false},
                            {true,true}};

        System.out.println ("Checking method cntTrueReg with the matrix:\n");
        printMat (mat5);

        studentCntRegResult=Ex14.cntTrueReg(mat5);
        System.out.println();
        System.out.println("Result of mat5 is: "+studentCntRegResult);
        
        boolean[][] mat6 = {
                {false,false,false,false,true},
                {false,true,true,true,false},
                {false,true,false,true,false},
                {false,true,true,true,false},
                {false,false,false,false,false},
            };

        System.out.println ("Checking method cntTrueReg with the matrix:\n");
        printMat (mat6);

        studentCntRegResult=Ex14.cntTrueReg(mat6);
        System.out.println();
        System.out.println("Result of mat6 is: "+studentCntRegResult);
    }

    public static void printMat(boolean [][]mat)
    {
        for (int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
                if(mat[i][j]== true)
                    System.out.print("1\t");
                else
                    System.out.print("0\t");
            System.out.println();
        }
    }
}

        
        
        
