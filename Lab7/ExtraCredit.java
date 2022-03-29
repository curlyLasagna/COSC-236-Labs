import java.util.*;

public class ExtraCredit {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int [] testScores = new int [10];
        double sum = 0;
        double avg = 0;
        double highest =0;

        for (int i=0; i<testScores.length;i++){
            System.out.println("Enter test score");
            testScores[i] = in.nextInt();
            sum += testScores[i];

            if (highest < testScores[i]){
                highest = testScores[i];
            }

        }
        
        avg = sum/testScores.length;

        System.out.println("The average score is " + avg);
        System.out.println("The highest score is " + highest);

    }

    
}
