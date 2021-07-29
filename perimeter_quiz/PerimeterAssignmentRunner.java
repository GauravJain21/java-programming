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

    public int getNumPoints (Shape s) {
        int numberOfPoints = 0;
        for(Point p: s.getPoints()) {
            ++numberOfPoints;
        }
        return numberOfPoints;
    }

    public double getAverageLength(Shape s) {
        double perimeter = getPerimeter(s);
        int numberOfPoints = getNumPoints(s);
        double averageSideLength = perimeter/numberOfPoints;
        return averageSideLength;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0;
        Point prevPoint = s.getLastPoint();
        for(Point currPoint: s.getPoints()) {
            largestSide = Math.max(largestSide, currPoint.distance(prevPoint));
            prevPoint = currPoint;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = -Double.MAX_VALUE;
        for(Point p: s.getPoints()) {
            largestX = Math.max(largestX, p.getX());
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = 0;
        DirectoryResource directoryResource = new DirectoryResource();
        for (File f: directoryResource.selectedFiles()) {
            FileResource fileResource = new FileResource(f);
            Shape shape = new Shape(fileResource);
            largestPerimeter = Math.max(largestPerimeter, getPerimeter(shape));
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        File fileWithMaxPerimeter = null;
        double largestPerimeter = 0;
        DirectoryResource directoryResource = new DirectoryResource();
        for(File file: directoryResource.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            double currentPerimeter = getPerimeter(new Shape(fileResource));
            if(largestPerimeter < currentPerimeter) {
                fileWithMaxPerimeter = file;
                largestPerimeter = currentPerimeter;
            }
        }
        return fileWithMaxPerimeter.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numberOfPoints = getNumPoints(s);
        System.out.println("Number of Points = " + numberOfPoints);
        double averageSideLength = getAverageLength(s);
        System.out.println("Average Side Length = " + averageSideLength);
        double largestSide = getLargestSide(s);
        System.out.println("Largest Side Length = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("Largest X = " + largestX);
    }

    public void testPerimeterMultipleFiles() {
        System.out.println("Largest Perimeter = " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        System.out.println("File with Largest Perimeter is " + getFileWithLargestPerimeter());
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
        pr.testFileWithLargestPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
