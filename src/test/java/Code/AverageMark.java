package Code;

import java.util.Arrays;
import java.util.Random;

public class AverageMark {
    public static void main(String[] args) {
        int[][] integerMatrix = new int[5][10];
        System.out.println(integerMatrix.length); // here I found the length of  array first
        System.out.println(integerMatrix[0].length); // here I found the length of  array second

        Random random = new Random();
        int[] grade = new int[integerMatrix.length];
        int avarage = 0;
        for (int i = 0; i < integerMatrix.length; i++) {
            for (int j = 0; j < integerMatrix[i].length; j++) {
                integerMatrix[i][j] = random.nextInt(12);
                avarage = avarage + integerMatrix[i][j];
            }

            grade[i] = avarage / integerMatrix[0].length;
            avarage = 0;
        }
        System.out.println(Arrays.deepToString(integerMatrix));
        System.out.println(Arrays.toString(grade));


        int max = grade[0];
        int studentId = 0;
        for (int i = 1; i < grade.length; i++) {
            if (max < grade[i]){
                max = grade[i];
                studentId = i;
            }
        }
        System.out.println("Id the best student: " + studentId);
        System.out.println("His average mark: " + grade[studentId]);
    }
}
