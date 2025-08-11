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
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver"); //"/drivers/chromedriver/" Specifying the path to the driver on the local machine
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

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
