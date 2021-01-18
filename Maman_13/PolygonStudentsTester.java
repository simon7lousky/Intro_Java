/**
 * Students tester to Polygon class
 */
public class PolygonStudentsTester {
   public static void main(String[] args) {

        System.out.println("start");
        
        Polygon polygon = new Polygon();
        boolean check = polygon.addVertex(2.0, 1.0);
        check = polygon.addVertex(5.0, 0.0);
        check = polygon.addVertex(7.0, 5.0);
        check = polygon.addVertex(4.0, 6.0);
        check = polygon.addVertex(1.0, 4.0);
        
        Polygon polygon0 = new Polygon();
        
        Polygon polygon1 = new Polygon();
        check = polygon1.addVertex(2.0, 1.0);
        
        Polygon polygon2 = new Polygon();
        check = polygon2.addVertex(2.0, 1.0);
        check = polygon2.addVertex(5.0, 0.0);
        
        Polygon polygon3 = new Polygon();
        check = polygon3.addVertex(2.0, 1.0);
        check = polygon3.addVertex(5.0, 0.0);
        check = polygon3.addVertex(7.0, 5.0);
        
        Point highest0 = polygon0.highestVertex();
        Point highest1 = polygon1.highestVertex();
        Point highest2 = polygon2.highestVertex();
        Point highest3 = polygon3.highestVertex();

        Point highest = polygon.highestVertex();
        
        String highestStr = highest.toString();
        if (highestStr.equals("(4.0,6.0)"))
            System.out.println("\nhighestVertex - OK");
        else
            System.out.println("\nError in highestVertex. Your result " + highestStr + " Expected result (4.0,6.0)");
        
        System.out.println(polygon0);
        System.out.println(polygon1);
        System.out.println(polygon2);
        System.out.println(polygon3);
        System.out.println(polygon);
        
        double perimeter0 = polygon0.calcPerimeter();
        double perimeter1 = polygon1.calcPerimeter();
        double perimeter2 = polygon2.calcPerimeter();
        
        double perimeter = polygon.calcPerimeter();
        if (Math.abs(perimeter-18.47754906310363)<=0.01)
            System.out.println("\ncalcPerimeter - OK");
        else
            System.out.println("\nError in calcPerimeter. Your result " + perimeter + " Expected result 18.478");

        double area0 = polygon0.calcArea();
        double area1 = polygon1.calcArea();
        double area2 = polygon2.calcArea();
        double area3 = polygon3.calcArea();
            
        double area = polygon.calcArea();
        if (Math.abs(area-22.5)<=0.01)
            System.out.println("\ncalcArea - OK");
        else
            System.out.println("\nError in calcArea. Your result " + area + " Expected result 22.5");

        Polygon biggerPolygon = new Polygon();
        biggerPolygon.addVertex(2.0, 1.0);
        biggerPolygon.addVertex(5.0, 0.0);
        biggerPolygon.addVertex(7.0, 5.0);
        biggerPolygon.addVertex(4.0, 7.0);
        biggerPolygon.addVertex(1.0, 4.0);
        
        Polygon equalPolygon = new Polygon();
        equalPolygon.addVertex(2.0, 1.0);
        equalPolygon.addVertex(5.0, 0.0);
        equalPolygon.addVertex(7.0, 5.0);
        equalPolygon.addVertex(4.0, 6.0);
        equalPolygon.addVertex(1.0, 4.0);
        boolean flagequal = polygon.isBigger(biggerPolygon);
        boolean flag = biggerPolygon.isBigger(polygon);

        flag = polygon.isBigger(biggerPolygon);
        if (flag)
            System.out.println("\nError in isBigger. Your result is " + flag + " Expected result is false");
        else
            System.out.println("\nisBigger - OK");
        
        Point pointfirst = new Point(2.0, 1.0);
        Point point = new Point(4.0, 6.0);
        Point pointnot = new Point(1.0, 1.0);
        Point pointlast = new Point(1.0, 4.0);
        int indexnot = polygon.findVertex(pointnot);
        int indexlast = polygon.findVertex(pointlast);
        
        int index = polygon.findVertex(point);
        if (index==3)
            System.out.println("\nfindVertex - OK");
        else
            System.out.println("\nError in findVertex. Your result = " + index + " Expected result = 3");
        
        Point nextVertexnot = polygon.getNextVertex(pointnot);
        Point nextVertexlast = polygon.getNextVertex(pointlast);
        Point nextVertex1 = polygon1.getNextVertex(pointnot);
        nextVertex1 = polygon1.getNextVertex(pointfirst);
        
        Point nextVertex = polygon.getNextVertex(point);
        String nextVStr = nextVertex.toString();
        if (nextVStr.equals("(1.0,4.0)"))
            System.out.println("\nnextVertex - OK");
        else
            System.out.println("\nError in nextVertex. Your result " + nextVStr + " Expected result (1.0,4.0)");

        Polygon boundingBox0 = polygon0.getBoundingBox();
        Polygon boundingBox1 = polygon1.getBoundingBox();
        Polygon boundingBox2 = polygon2.getBoundingBox();
        Polygon boundingBox3 = polygon3.getBoundingBox();
        System.out.println(boundingBox3);
        
        Polygon boundingBox = polygon.getBoundingBox();
        String boundingBoxStr = boundingBox.toString();
        if (boundingBoxStr.equals("The polygon has 4 vertices:\n((1.0,0.0),(7.0,0.0),(7.0,6.0),(1.0,6.0))"))
            System.out.println("\ngetBoundingBox - OK");
        else
        {
            System.out.println("\nError in getBoundingBox or in toString");
            System.out.println("Your bounding box is:\n" + boundingBox + "\nExpected bounding box is:\nThe polygon has 4 vertices:\n((1.0,0.0),(7.0,0.0),(7.0,6.0),(1.0,6.0))");
        }
        System.out.println("\nNote that this is only a basic test. Make sure you test all cases!");
        System.out.println("end");
   }
}
