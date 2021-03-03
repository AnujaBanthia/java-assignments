package javaProblemSolvingWithSoftware.week1;
/*
Assignment 2
 */
import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

public int getNumPoints(Shape s){
        int noOfPoints =0;
        for(Point currPoint: s.getPoints()){
            noOfPoints++;
        }
        return noOfPoints;
    }

    public double getAverageLength(Shape s){
        double averageLength = 0;
        Point prevPt = s.getLastPoint();
        double totalLength = getPerimeter(s);
        int noOfPoints = getNumPoints(s);
        averageLength = totalLength/noOfPoints;
        return averageLength;
    }

    public double getLargestSide(Shape s){
        double largestLength = 0;

        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(largestLength<currDist){
                largestLength = currDist;
            }
        }
        return largestLength;
    }

    public double getLargestX(Shape s){
        int largestXCoordinate = 0;
        for (Point currPt : s.getPoints()) {
            if(largestXCoordinate < currPt.getX()){
                largestXCoordinate = currPt.getX();
            }
        }
        return  largestXCoordinate;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double maxPerimeter=0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape shapeInput = new Shape(fr);
            double currPerimeter = getPerimeter(shapeInput);
            if(maxPerimeter < currPerimeter)
                maxPerimeter = currPerimeter;
        }
        return maxPerimeter;
    }

    public File getFileWithLargestPerimeter() {
        // Put code here


        DirectoryResource dr = new DirectoryResource();
        double maxPerimeter=0;
        File shapeFileWithLargestPerimeter = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape shapeInput = new Shape(fr);

            double currPerimeter = getPerimeter(shapeInput);
            if(maxPerimeter < currPerimeter){
                maxPerimeter = currPerimeter;
                shapeFileWithLargestPerimeter = f;
            }

        }
        return shapeFileWithLargestPerimeter;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);

        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter= "+largestPerimeter);

        File fileWithlargestPerimeter = getFileWithLargestPerimeter();
        System.out.println("File name with Largest Perimeter= "+fileWithlargestPerimeter.getName());
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}