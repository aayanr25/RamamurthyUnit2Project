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
        return Math.round(dist * 100) / 100.0;
    }

    public double slope() {
        double rise = y2 - y1;
        double run = x2 - x1;
        return Math.round(rise / run * 100) / 100.0;
    }

    public double yIntercept() {
        double intercept = y1 - (slope() * x1);
        return Math.round(intercept * 100) / 100.0;
    }

    public String equation() {
        int rise = (int) y2 - y1;
        int run = (int) x2 - x1;
        if (rise == run) {
            return "y = " + yIntercept();
        } else {
            return "y = " + rise + "/" + run + "x + " + yIntercept();
        }
    }
    public String coordinateForX(double xValue) {
        double yValue = slope() * xValue + yIntercept();
        return "(" + xValue + ", " + yValue + ")";
    }

}
