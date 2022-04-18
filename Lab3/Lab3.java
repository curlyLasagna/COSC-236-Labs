//Coder: Abdalla A.
//Driver: Luis G.

/*
Sophomore between 30 and 59
Junior between 60 and 89
Senior 90+
30 <= x <= 59
60 <= x <= 89
90 <= x
*/

import java.util.Scanner;

public class Lab3 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int credits = 0;
        int semesters = 0;
        double gpa = 0.0;
        String time = "";
        String year = "Freshmen";
        boolean goodStanding = false;

        System.out.print("Enter amount of credits: ");
        // Checks if input type for credits is an integer
        if (in.hasNextInt())
            credits = in.nextInt();
        else {
            System.err.println("Not an integer");
            System.exit(0);
        }

        // Doesn't allow for negative credit values
        if (credits <= 0) {
            System.out.println("Must be greater than 0");
            System.exit(0);
        }

        // To remind the user they have to chill
        else if (credits >= 20)
            System.out.println("You doing too much");

        System.out.print("Enter number of semesters: ");
        if (in.hasNextInt())
            semesters = in.nextInt();
        else {
            System.err.println("Not an integer");
            System.exit(0);
        }

        if (semesters <= 0) {
            System.out.println("Must be greater than 0");
            System.exit(0);
        }

        System.out.print("Enter your GPA: ");
        if (in.hasNextDouble())
            gpa = in.nextDouble();
        else {
            System.err.println("Not a double");
            System.exit(0);
        }

        if (gpa < 0 || gpa >= 5) {
            System.out.println("Input not valid");
            System.exit(0);
        }

        switch (credits) {
            case 11:
            case 10:
            case 9:
                time = "three quarter time";
                break;
            case 8:
            case 7:
            case 6:
                time = "half time";
                break;
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
                time = "less than half time";
                break;
            default:
                time = "full time";
        }

        credits = credits * semesters;

        if (credits >= 30 && credits <= 59)
            year = "Sophomore";
        else if (credits >= 60 && credits <= 89)
            year = "Junior";
        else if (credits >= 90)
            year = "Senior";

        if ((credits >= 1 && credits <= 29.5) && gpa > 1.5)
            goodStanding = true;
        else if ((credits >= 30 && credits <= 59.5) && gpa > 1.75)
            goodStanding = true;
        else if (credits >= 60 && gpa >= 2.0)
            goodStanding = true;

        System.out.println("You are a " + time + " student");
        System.out.println("You are a " + year);

        if (goodStanding)
            System.out.println("You are in good standing!");

        else
            System.out.println("You are not in good standing");
    }
}
