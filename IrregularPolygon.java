import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon;


    public IrregularPolygon() {
        myPolygon = new ArrayList<>();
    }

    
    public void add(Point2D.Double aPoint) {
        myPolygon.add(aPoint);
    }

    
    public double perimeter() {
        if (myPolygon.size() < 2) return 0.0;
        
        double perimeter = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size()); // Wrap around
            perimeter += p1.distance(p2);
        }
        return perimeter;
    }

   
    public double area() {
        if (myPolygon.size() < 3) return 0.0;
        
        double sum1 = 0.0, sum2 = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % myPolygon.size()); // Wrap around
            sum1 += p1.x * p2.y;
            sum2 += p1.y * p2.x;
        }
        return Math.abs(sum1 - sum2) / 2.0;
    }

   
  