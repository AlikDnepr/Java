package Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loops {

    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
        loop();
    }
    static void loop(){
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }
}
