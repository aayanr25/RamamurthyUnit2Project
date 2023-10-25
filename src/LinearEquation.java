public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        double dist = Math.sqrt(Math.pow((x2 - x1), 2) + (Math.pow((y2 - y1), 2)));
        return roundedToHundredth((dist * 100) / 100.0);
    }

    public double slope() {
        double rise = y2 - y1;
        double run = x2 - x1;
        return roundedToHundredth((rise / run * 100) / 100.0);
    }

    public double yIntercept() {
        double intercept = y1 - (slope() * x1);
        return roundedToHundredth((intercept * 100) / 100.0);
    }

    public String equation() {
        int rise = (int) y2 - y1;
        int run = (int) x2 - x1;
        String slopeInEquation;
        String yIntInEquation;
        if (rise == run) {
            slopeInEquation = "";
        } else if (rise % run == 0) {
            slopeInEquation = "" + rise / run;
        } else if (slope() == -1.0) {
            slopeInEquation = "-";
        } else if (rise < 0 || run < 0) {
            slopeInEquation = "-" + Math.abs(rise) + "/" + Math.abs(run);
            if (rise % run == 0) {
                slopeInEquation = "-" + Math.abs(rise / run);
            }
        } else {
            slopeInEquation = rise + "/" + run;
        }
        if (yIntercept() == 0) {
            yIntInEquation = "";
            if (slope() == 0.0) {
                return "y = 0";
            }
        } else if (yIntercept() < 0) {
            yIntInEquation = "- " + Math.abs(yIntercept());
        } else {
            yIntInEquation = "+ " + yIntercept();
        }

            return "y = " + slopeInEquation + "x " + yIntInEquation;

    }
    public String coordinateForX(double xValue) {
        double yValue = slope() * xValue + yIntercept();
        return "(" + xValue + ", " + yValue + ")";
    }

    public String lineInfo() {
        String str = "The two points are: ";
        str += "(" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y intercept of this line is: " + yIntercept();
        str += "\nThe distance between these points is " + distance();
        return str;
    }

    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }

}
