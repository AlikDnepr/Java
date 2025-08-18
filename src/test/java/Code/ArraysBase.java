package Code;

import java.util.Arrays;
import java.util.Random;

public class ArraysBase {
    public static void main(String[] args) {
        int[] array = new int[100];
        Random random = new Random();

        ArrayFill(array, random);

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("MinInt: " + ArrayMin(array));
        System.out.println("MaxInt: " + ArrayMax(array));
    }
    public static void ArrayFill(int[] array,Random random){
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
    }
    public static int ArrayMin(int[] array){
        Arrays.sort(array);
        return array[0];
    }
    public static int ArrayMax(int[] array){
        Arrays.sort(array);
        return array[array.length - 1];
    }
}
