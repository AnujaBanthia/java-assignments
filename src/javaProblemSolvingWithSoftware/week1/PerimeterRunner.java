package javaProblemSolvingWithSoftware.week1;

import edu.duke.*;
/*
Assignment 1
 */
public class PerimeterRunner {
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

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int noOfPoints = getNumPoints(s);
        System.out.println("Number of points= "+noOfPoints);
        double averageLength = getAverageLength(s);
        System.out.println("Average Length= "+averageLength);
        double largestSide = getLargestSide(s);
        System.out.println("Largest side= "+largestSide);
        double largestXCoordinate = getLargestX(s);
        System.out.println("Largest X Co-ordinate= "+largestXCoordinate);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}