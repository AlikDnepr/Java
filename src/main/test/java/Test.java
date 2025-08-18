import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> emails = new ArrayList<>(List.of(
                "Ivan.Petrov@@Gmail.Com",
                "Katya_1989MAIL.ru",
                "oleg#example.com",
                "sergey@gnail.com",
                "natalia@outlok.com",
                "dmitriy@mail..ru",
                "anna.smirnova@gmail.com",
                "mikhail1988@yandex.ru",
                "elena_kovalenko@outlook.com",
                "roman-ivanov@mail.ru"
        ));
        ArrayList<String> refactoredEmails = new ArrayList<>();
        for (int i = 0; i < emails.size(); i++) {
            if (emails.get(i).contains(".ru")){
                refactoredEmails.add(emails.get(i).replace(".ru",".ua"));

            }
            if (emails.get(i).equals(emails.get(i + 1))){
                refactoredEmails.add(emails.get(i).replace(".ru",".ua"));
            }

            refactoredEmails.add(emails.get(i).toLowerCase());
            //System.out.println(emails.get(i));
        }
        for (int i = 0; i < refactoredEmails.size(); i++) {
            //System.out.println(refactoredEmails.get(i));
        }

        // Список
        // Цикл
        // Применение методов
        // 1) Нижний регистр
        // 2) Фильтр и разделение эмейлов по группам
        // 3) Сравнение эмейлов между собой чтоб отклонить дубликаты
        // 4) endsWith()
    }
}
