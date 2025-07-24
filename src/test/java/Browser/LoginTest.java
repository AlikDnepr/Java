package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    @Test
    public void GoogleTest(){
        WebDriverManager.chromedriver().setup(); // библиотека WebDriverManager, которая автоматически загружает и настраивает нужную версию ChromeDriver (и других драйверов), подходящую для твоего браузера.
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver"); //"/drivers/chromedriver/" почитать как можно оптимизаровать эту строку Хроме драйвер сетап
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login"); // Відкриває сторінку логіну

        WebElement usernameField = driver.findElement(By.id("username")); //Находим элемент по id
        usernameField.sendKeys("tomsmith"); //Вводить у поле логіну: tomsmith
        WebElement passwordField = driver.findElement(By.name("password")); //Находим элемент по id
        passwordField.sendKeys("SuperSecretPassword!"); //Вводить у поле пассворд: SuperSecretPassword!

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement massage = driver.findElement(By.id("flash"));
        System.out.println("flash");
        assertTrue(massage.getText().contains("You logged into a secure area!"));
        System.out.println("test");
        WebElement massage2 = driver.findElement(By.id("content"));
        assertTrue(massage2.getText().contains("Welcome to the Secure Area. When you are done click logout below."));
        System.out.println("test2");
        driver.close();
        driver.quit();
        
    }
}
