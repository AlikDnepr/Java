package Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForLoop {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите число: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());

        for (int i = 1; i < number; i++){
            for (int j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();

        }

    }
}
