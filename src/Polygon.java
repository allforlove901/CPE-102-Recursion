import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
   A polygon with a number of Point2D.Double corners
*/
public class Polygon
{
   private ArrayList<Point2D.Double> corners;
   private double area = 0;

   /**
      Constructs a Polygon object with no corners
   */
   public Polygon()
   {
      corners = new ArrayList<Point2D.Double>();
   }
   
   /**
      Adds a point to the list.
      @param p the point to add
   */
   public void add(Point2D.Double p)
   {
      corners.add(p);   
   }
   
   /**
      Computes the area of a polygon.
      @return area of a polygon
   */
   public double getArea()
   {
      if(corners.size() == 3){
    	  return area + computeArea(corners.get(0).x, corners.get(0).y,
    			  			corners.get(1).x, corners.get(1).y,
    			  			corners.get(2).x, corners.get(2).y);
      }
      else{
    	  Polygon smallerPolygon = new Polygon();
    	  smallerPolygon.add(corners.get(0));
    	  for(int i = 2; i<corners.size(); i++){
    		  smallerPolygon.add(corners.get(i));
    	  }
    	  smallerPolygon.area = trackArea(computeArea(corners.get(0).x, corners.get(0).y,
		  			corners.get(1).x, corners.get(1).y,
		  			corners.get(2).x, corners.get(2).y));
    	  return smallerPolygon.getArea();
      }
   }
   
   public double trackArea(double theArea){
	   return area + theArea;
   }
   
   public double computeArea(double x1, double y1, double x2, double y2, double x3, double y3){
	   return Math.abs(x1*y2 + x2*y3 + x3*y1 - x2*y1 - x3*y2 - x1*y3)/2;
   }
}