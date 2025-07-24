package Code;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        //1 - two variables, string and float, compare who is bigger [size]
        //2 - student - 10 subjects[Math - 10], average score  - 11.1, 10.5
        //второй способ через приведение типов

        String name = "Maxim";
        float number = 12345;
        float sizeName = name.length();

        if (sizeName > number){
            System.out.println("Переменная name больше");
        }
        else {
            System.out.println("Переменная number больше");
        }

        List<String> subjects = List.of("Math - 10", "Physics - 10", "Chemistry - 3", "Biology - 7", "English - 5",
                "History - 5", "Geography - 1", "Computer Science - 2", "Literature - 3", "Physical Education - 1");

        int sum = 0;
        for (int i = 0; i < subjects.size(); i++) {
            String subject = subjects.get(i);
            String[] part = subject.split("- ");
            int count = Integer.parseInt(part[1]);
            sum += count;
        }
        float result = (float) sum / (float) subjects.size();
        System.out.println(result);

    }
}
