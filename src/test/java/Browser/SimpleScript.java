package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Проверка самой страници
// Элементы
// содержание

public class SimpleScript {
    @Test
    public void Test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://example.com");
        System.out.println("Site is opened:" + " " +  driver.getCurrentUrl());

        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println("Заголовок найден: " + element.getText()); // element.getText() - replaces the identifier with the element value!!!

        //assertTrue(driver.getCurrentUrl().contains("https://example.com/"));
        String expTitle = driver.getTitle();
        System.out.println(expTitle);
        if (expTitle.contains("Example Domain")){
            System.out.println("да содержит");
        }
        else {
            System.out.println("Не содержит");
        }
        driver.quit();

    }
}
