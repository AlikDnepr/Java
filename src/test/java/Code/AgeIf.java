package Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AgeIf {
    public static String getAgeCategory(int age) {
        if (age > 0 && age <= 17) {
            return "Дитина";
        } else if (age >= 18 && age <= 59) {
            return "Дорослий";
        } else if (age > 60) {
            return "Пенсіонер";
        } else {
            return "Некоректний вік";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int age = Integer.parseInt(reader.readLine());
            System.out.println(getAgeCategory(age));
            if (age == 666){
                break;
            }
        }
    }
}