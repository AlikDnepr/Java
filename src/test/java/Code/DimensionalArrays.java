package Code;

import java.util.Arrays;
import java.util.Random;

import static java.lang.String.valueOf;


public class DimensionalArrays {
    public static void main(String[] args) {
        OneDimensionalArray();
        TwoDimensionalArrays();
        System.out.println("\n");
        MultiDimensionalArrays();
        System.out.println("\n");
        MultiDimensionalArraysVersion2();
        System.out.println("\n");
        MultiDimensionalArraysVersion3();
        System.out.println("\n");
        Array();
        System.out.println("\n");
        Matrix();
    }

    private static void OneDimensionalArray() {
        String[] star = new String[10];
        for (int i = 0; i < star.length; i++) {
            star[i] = "*";
        }
        System.out.println("OneDimensionalArray: " + Arrays.toString(star));
    }

    public static void TwoDimensionalArrays() {
        String[][] star = new String[10][2];
        for (int i = 0; i < star.length; i++) {
            for (int j = 0; j < star[i].length; j++) {
                star[i][j] = "*";
            }
        }
        System.out.println("TwoDimensionalArrays: " + Arrays.deepToString(star));
    }
    public static void MultiDimensionalArrays(){
        for (int i = 1; i < 10; i++) {
            String[] star = new String[i];
            for (int j = 0; j < star.length; j++) {
                star[j] = "*";
            }
            System.out.println(Arrays.toString(star));
        }

    }
    public static void MultiDimensionalArraysVersion2() {
        int rows = 10;
        String[][] stars = new String[rows][];

        for (int i = 0; i < rows; i++) {
            stars[i] = new String[i + 1];
            for (int j = 0; j < stars[i].length; j++) {
                stars[i][j] = "*";
            }
        }

        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars[i].length; j++) {
                System.out.print(stars[i][j]);
            }
            System.out.println();

        }
    }
    public static void MultiDimensionalArraysVersion3() {
        int steps = 5;

        for (int step = 1; step <= steps; step++) {
            String[][] arr = new String[step][step];
            for (int i = 0; i < step; i++) {
                Arrays.fill(arr[i], "*");
            }
            System.out.println(Arrays.deepToString(arr));
        }
    }

    public static void Array() {
        int[] array = new int[10];
        int average = 0;
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(40);
            average = average + array[i];
        }
        Arrays.sort(array);
        System.out.println("Array min: " + array[0]);
        System.out.println("Array max: " + array[array.length - 1]);
        System.out.println("Array Average: " + average/array.length);
        System.out.println("Array Sum: " + average);
    }

    public static void Matrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transpose = new int[matrix.length][matrix[0].length];
        System.out.println(Arrays.deepToString(matrix));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        System.out.println(Arrays.deepToString(transpose));
    }
}

