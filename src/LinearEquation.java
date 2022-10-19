public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /* Creates a LinearEquation object */
    /*
     * PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for
     * ensuring
     * this precondition is not violated)
     */
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Finds the distance between two points rounded
    public double distance() {
        double squared = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
        double distance = Math.sqrt(squared);
        return roundedToHundredth(distance);
    }

    // Finds the y intercept and returns it rounded
    public double yIntercept() {
        double slope = slope();
        return roundedToHundredth(y1 - x1 * slope);
    }

    // Finds slope and returns it rounded
    public double slope() {
        double slope = (double) (y2 - y1) / (double) (x2 - x1);
        return roundedToHundredth(slope);
    }

    // Returns a String that represents the linear equation of the line through the points
    public String equation() {
        int deltaY = y2 - y1;
        int deltaX = x2 - x1;
        double yIntercept = yIntercept();
        String slope;


        // Checks if line is horizontal
        if (y2 == y1) {
            return "y = " + y2;
        }

        // Gets slope
        if (deltaY % deltaX == 0) {
            int temp = deltaY / deltaX;

            // Checks if slope is 1
            if (temp == 1) {
                slope = "x";
            }
            else {
                slope = temp + "x";
            }

        }
        else {
            // Check if numerator and denominator are both negative
            if (Math.abs(deltaX) > deltaX && Math.abs(deltaY) > deltaY) {
                slope = deltaY + "/" + deltaX + "x";
            }
            // Check if one of them is negative
            else if (Math.abs(deltaX) > deltaX || Math.abs(deltaY) > deltaY) {
                slope = "-" + Math.abs(deltaY) + "/" + Math.abs(deltaX) + "x";
            }
            else {
                slope = deltaY + "/" + deltaX + "x";
            }
        }

        // Checks if yIntercept is 0
        if (yIntercept == 0) {
            return "y = " + slope;
        }
        // Checks if yIntercept is positive
        else if (Math.abs(yIntercept) == yIntercept) {
            return "y = " + slope + " + " + yIntercept;
        }
        else {
            return "y = " + slope + " - " + Math.abs(yIntercept);
        }

    }


    // Returns a String of the coordinate point on the line that has the given x
    public String coordinateForX(double xValue) {
        double y;

        y = roundedToHundredth(slope()* xValue + yIntercept());
        return "\nThe point on the line is: (" + xValue + ", " + y + ")";
    }

    // Helper method to round
    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }


    // Returns a string that includes all information about the linear equation
    public String lineInfo() {
        return "\nThe two points are: (" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ")"
                + "\nThe equation of the line between these points is: " + equation()
                + "\nThe slope of this line is: " + slope()
                + "\nThe y-intercept of the line is: " + yIntercept()
                + "\nThe distance between these two points is: " + distance();
    }

}
