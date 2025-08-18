package Code;

import java.util.Arrays;

public class DimensionalArrays {
    public static void main(String[] args) {
        OneDimensionalArray();
        TwoDimensionalArrays();
        System.out.println("\n");
        MultiDimensionalArrays();
        System.out.println("\n");
        MultiDimensionalArraysVersion2();
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
    }
