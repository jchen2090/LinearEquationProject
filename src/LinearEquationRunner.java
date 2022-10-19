import java.util.Scanner;

public class LinearEquationRunner {
    public static void start() {
        System.out.println("Welcome!");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String coord1, coord1Left, coord1Right;
        String coord2, coord2Left, coord2Right;

        int commaPos;
        int x1, y1;
        int x2, y2;
        double valueForX;

        // Welcomes user
        start();

        // Gets coord1 from input
        System.out.print("Enter coordinate 1: ");
        coord1 = input.nextLine();
        commaPos = coord1.indexOf(", ");

        // Isolates the numbers of coord1
        coord1Left = coord1.substring(1, commaPos);
        coord1Right = coord1.substring(commaPos + 2, coord1.length() - 1);
        x1 = Integer.parseInt(coord1Left);
        y1 = Integer.parseInt(coord1Right);

        // Gets coord2 from input
        System.out.print("Enter coordinate 2: ");
        coord2 = input.nextLine();
        commaPos = coord2.indexOf(", ");

        // Isolates the numbers of coord2
        coord2Left = coord2.substring(1, commaPos);
        coord2Right = coord2.substring(commaPos + 2, coord2.length() - 1);
        x2 = Integer.parseInt(coord2Left);
        y2 = Integer.parseInt(coord2Right);

        // Checks if they're on a vertical line
        if (x2 == x1) {
            System.out.println("\nThese points are on a vertical line: x = " + x1);
        }
        else {
            LinearEquation linearEquation = new LinearEquation(x1, y1, x2, y2);
            System.out.println(linearEquation.lineInfo());

            System.out.print("\nEnter a value for x: ");
            valueForX = input.nextDouble();
            System.out.println(linearEquation.coordinateForX(valueForX));
        }
        input.close();

    }
}
