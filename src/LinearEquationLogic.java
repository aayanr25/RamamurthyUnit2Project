import java.util.Scanner;
public class LinearEquationLogic {
    private LinearEquation line;
    private Scanner scan;
    private boolean slopeUndefined;
    public LinearEquationLogic() {
        line = null;
        scan = new Scanner(System.in);
    }
    public void start() {
        String str = "";
        while (!str.equals("n")) {
            getCoordinates();
            if (slopeUndefined) {
                System.out.println("You cannot enter 2 points with the same x value.");
            } else {
                System.out.println("Your line has been created.\n");
                secondPart();
            }
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            str = scan.nextLine();
            System.out.println();
        }
    }
    private void getCoordinates() {
        System.out.print("Enter first coordinate: ");
        String coordinate1 = scan.nextLine();
        int idx = coordinate1.indexOf(",");
        int idx2 = coordinate1.indexOf(")");
        String xCoordinate1 = coordinate1.substring(1,idx);
        int x1 = Integer.parseInt(xCoordinate1);
        String yCoordinate1 = coordinate1.substring(idx + 2, idx2);
        int y1 = Integer.parseInt(yCoordinate1);
        System.out.print("Enter second coordinate: ");
        String coordinate2 = scan.nextLine();
        idx = coordinate2.indexOf(",");
        idx2 = coordinate2.indexOf(")");
        String xCoordinate2 = coordinate2.substring(1, idx);
        int x2 = Integer.parseInt(xCoordinate2);
        String yCoordinate2 = coordinate2.substring(idx + 2, idx2);
        int y2 = Integer.parseInt(yCoordinate2);

        slopeUndefined = false;
        if (x1 == x2) {
            slopeUndefined = true;
        }

        line = new LinearEquation(x1, y1, x2, y2);

    }

    private void secondPart() {
        System.out.println(line.lineInfo());
        System.out.println();
        System.out.print("Enter an x value: ");
        double num = scan.nextDouble();
        scan.nextLine();
        System.out.println("The point on the line is " + line.coordinateForX(num));


    }


}
