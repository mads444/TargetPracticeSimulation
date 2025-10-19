// Madison Crewse Program 5ab
import java.util.Scanner;
import java.util.Random;

public class TargetPracticeSimulation {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Random rng = new Random();

        System.out.print("This program practices using functions "
        		+ "and information passing \ntechniques by value and the"
        		+ " function return value.\n\n");
        
        // menu cheat option 5b
        System.out.print("Do you want to cheat? (Y/N): ");
        char cheat = kb.next().charAt(0);
        while (cheat != 'Y' && cheat != 'y' && cheat != 'N' && cheat != 'n') {
            System.out.print("Enter Y or N: ");
            cheat = kb.next().charAt(0);
        }

        // menu options 5b
        char choice;
        do {
            System.out.println("\nPhase II Menu:");
            System.out.println("  (1) Basic Calculations");
            System.out.println("  (2) Artillery Table");
            System.out.println("  (3) Target Practice");
            System.out.println("  (4) Quit");
            System.out.print("Choose an option: ");
            choice = kb.next().charAt(0);
            while (choice < '1' || choice > '4') {
                System.out.print("Enter 1-4: ");
                choice = kb.next().charAt(0);
            }
            if (choice == '1') runPhaseI(kb);
            else if (choice == '2') runArtilleryTable(kb);
            else if (choice == '3') runTargetPractice(kb, rng, cheat);
            else System.out.println("Goodbye!");
        } while (choice != '4');
        kb.close();
    }
        // menu options 5a (choice 1)
    public static void runPhaseI(Scanner kb) {
        char option;
        do {
            System.out.println("Please choose an option below:\n");
            System.out.println("(1) Given two points, compute the distance\n"
            		+ " between the two points.");
            System.out.println("(2) Given two points, compute the horizontal\n"
            		+ " angle from the first point to the second.");
            System.out.println("(3) Given the elevation angle and velocity,\n"
            		+ " compute the horizontal distance an object travels.");
            System.out.println("(4) Given a starting point, "
            		+ "a distance, and a\n"
            		+ " horizontal angle, computes the destination.");
            System.out.println("(5) Quit Program");
            option = kb.next().charAt(0);
            while (option < '1' || option > '5') {
                System.out.println("Invalid option. "
                		+ "Please enter a valid option.");
                option = kb.next().charAt(0);
            }
            if (option == '1') computeDistancePrompt(kb);
            else if (option == '2') computeHorizontalAnglePrompt(kb);
            else if (option == '3') computeHorizontalDistancePrompt(kb);
            else if (option == '4') computeDestinationPrompt(kb);
            else System.out.println("Bye Bye! :]");
            System.out.println();
        } while (option != '5');
    }

    // customer-service subprograms
    //option 1
    public static void computeDistancePrompt(Scanner kb) {
        System.out.print("Enter x1: ");
        double x1 = kb.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = kb.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = kb.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = kb.nextDouble();
        double result = computeDistance(x1, y1, x2, y2);
        System.out.printf("Distance: %.2f feet\n", result);
    }

    // option 2
    public static void computeHorizontalAnglePrompt(Scanner kb) {
        System.out.print("Enter x1: ");
        double x1 = kb.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = kb.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = kb.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = kb.nextDouble();
        double result = computeHorizontalAngle(x1, y1, x2, y2);
        System.out.printf("Horizontal angle: %.2f degrees\n", result);
    }

    //option 3
    public static void computeHorizontalDistancePrompt(Scanner kb) {
        double elevation;
        do {
            System.out.print("Enter elevation angle "
            		+ "(between 0 and 90 degrees): ");
            elevation = kb.nextDouble();
        } while (elevation <= 0 || elevation >= 90);

        double velocity;
        do {
            System.out.print("Enter velocity in mph (greater than 0 mph): ");
            velocity = kb.nextDouble();
        } while (velocity <= 0);

        double result = computeHorizontalDistance(elevation, velocity);
        System.out.printf("Horizontal distance: %.2f feet\n", result);
    }

    //option 4
    public static void computeDestinationPrompt(Scanner kb) {
        System.out.print("Enter starting x: ");
        double x1 = kb.nextDouble();
        System.out.print("Enter starting y: ");
        double y1 = kb.nextDouble();

        double distance;
        do {
            System.out.print("Enter distance (greater than zero): ");
            distance = kb.nextDouble();
        } while (distance <= 0);

        double angle;
        do {
            System.out.print("Enter horizontal angle "
            		+ "between 0 and 360 degrees: ");
            angle = kb.nextDouble();
        } while (angle < 0 || angle > 360);

        double[] result = computeDestination(x1, y1, distance, angle);
        System.out.printf("Destination: (%.2f, %.2f)\n", result[0], result[1]);
    }

    //distance formula
    public static double computeDistance(double x1, double y1, double x2,
    		double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    //horizontal angle formula
    public static double computeHorizontalAngle(double x1, double y1,
    		double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double angleRad;
        if (dx > 0) {
            angleRad = Math.atan(dy / dx);
        } else if (dx < 0) {
            angleRad = Math.atan(dy / dx) + Math.PI;
        } else {
            if (dy >= 0) {
                angleRad = Math.PI / 2;
            } else {
                angleRad = 3 * Math.PI / 2;
            }
        }
        double angleDeg = angleRad * 180 / Math.PI;
        if (angleDeg < 0) angleDeg += 360;
        return angleDeg;
    }

    // horizontal distance formula
    public static double computeHorizontalDistance
    (double elevationAngleDegrees, double velocityMph) {
        double radians = elevationAngleDegrees * Math.PI / 180;
        double feetPerSecond = velocityMph * 5280 / 3600;
        return (Math.pow(feetPerSecond, 2) * Math.sin(2 * radians)) / 32.172;
    }

    //destination formula (distance and angle)
    public static double[] computeDestination(double x1, double y1,
    		double distance, double angleDegrees) {
        double radians = angleDegrees * Math.PI / 180;
        double dx = distance * Math.cos(radians);
        double dy = distance * Math.sin(radians);
        return new double[]{x1 + dx, y1 + dy};
    }
    
    //choice 2
    public static void runArtilleryTable(Scanner kb) {
        System.out.print("Enter initial vertical angle (degrees): ");
        double angleStart = kb.nextDouble();
        System.out.print("Enter initial velocity (mph): ");
        double velocityStart = kb.nextDouble();
        System.out.print("Enter number of rows: ");
        int rows = kb.nextInt();
        System.out.print("Vary angle (A) or velocity (V): ");
        char mode = kb.next().charAt(0);
        System.out.print("Enter increment: ");
        double increment = kb.nextDouble();

        System.out.printf("%-12s %-12s%n", mode == 'A' || mode == 'a' ?
        		"Angle" : "Velocity", "Distance");
        
        for (int i = 0; i < rows; i++) {
            double currentAngle = angleStart;
            double currentVelocity = velocityStart;
            if (mode == 'A' || mode == 'a') {
                currentAngle = angleStart + i * increment;
            } else {
                currentVelocity = velocityStart + i * increment;
            }
            double distance = computeHorizontalDistance
            		(currentAngle, currentVelocity);
            if (mode == 'A' || mode == 'a') {
                System.out.printf("%-12.2f %-12.2f%n",
                		currentAngle, distance);
            } else {
                System.out.printf("%-12.2f %-12.2f%n",
                		currentVelocity, distance);
            }
        }
    }
    
    // choice 3
    public static void runTargetPractice(Scanner kb, Random rng, char cheat) {
        System.out.print("Choose difficulty - "
        		+ "Easy (E), Medium (M), Hard (H): ");
        char difficulty = kb.next().charAt(0);
        double targetRadius = 100;
        if (difficulty == 'M' || difficulty == 'm') targetRadius = 25;
        else if (difficulty == 'H' || difficulty == 'h') targetRadius = 5;

        double cannonX = 2500;
        double cannonY = 0;
        int shots = 0;
        int hits = 0;
        char playAgain;

        do {
            double targetX = rng.nextDouble() * 5000;
            double targetY = rng.nextDouble() * 5000;

            if (cheat == 'Y' || cheat == 'y') {
                double distance = computeDistance(cannonX, cannonY,
                		targetX, targetY);
                double angle = computeHorizontalAngle(cannonX, cannonY,
                		targetX, targetY);
                System.out.printf("Target at (%.2f, %.2f) -"
                		+ " Distance: %.2f ft - Angle: %.2f deg%n", 
                		targetX, targetY, distance, angle);
            } else {
                System.out.printf("Target is at (%.2f, %.2f)%n",
                		targetX, targetY);
            }

            System.out.print("Enter barrel direction "
            		+ "(between 0 and 180 degrees): ");
            double direction = kb.nextDouble();
            System.out.print("Enter elevation angle "
            		+ "(between 0 and 90 degrees): ");
            double elevation = kb.nextDouble();
            System.out.print("Enter velocity (greater than 0 mph): ");
            double velocity = kb.nextDouble();

            double distance = computeHorizontalDistance(elevation, velocity);
            double[] shell = computeDestination(cannonX, cannonY, distance,
            		direction);
            double distanceToTarget = computeDistance(shell[0], shell[1],
            		targetX, targetY);

            shots++;
            if (distanceToTarget <= targetRadius) {
                hits++;
                System.out.println("BOOOOOOM! Hit!");
            } else {
                System.out.printf("You missed... Distance to target:"
                		+ " %.2f feet%n",
                		distanceToTarget);
            }
            
            // asking the user if they would like to play again
            System.out.print("Take another shot? (Y/N): ");
            playAgain = kb.next().charAt(0);
        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.printf("You took %d shots and hit the target %d times.%n",
        		shots, hits);
    }
}
