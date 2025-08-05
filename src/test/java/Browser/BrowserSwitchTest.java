package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class BrowserSwitchTest {

    public static void main(String[] args) {
        for (int browserCount = 1; browserCount <= 4; browserCount++) {
            WebDriver driver = null;

            try {
                driver = createWebDriver(browserCount);
                if (driver == null) {
                    System.out.println("Unsupported browser: " + browserCount);
                    continue;
                }
                if (browserCount == 1){
                    System.out.println("*** Тестирование браузера Chrome ***");
                }
                if (browserCount == 2){
                    System.out.println("*** Тестирование браузера Firefox ***");
                }
                if (browserCount == 3){
                    System.out.println("*** Тестирование браузера Edge ***");
                }
                if (browserCount == 4){
                    System.out.println("*** Тестирование браузера Safari ***");
                }


                performLoginTest(driver);
                exampleLoginTest(driver);
                googleLoginTest(driver);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }

    private static WebDriver createWebDriver(int browserCount) {
        switch (browserCount) {
            case 1:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case 2:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case 3:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case 4:
                return new SafariDriver(); // Safari не требует setup
            default:
                return null;
        }
    }

    private static void performLoginTest(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        long start = System.currentTimeMillis();

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement subheader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.subheader")));
        assertEquals("This is where you can log into the secure area. Enter tomsmith for the username and " +
                        "SuperSecretPassword! for the password. If the information is wrong you should see error messages.",
                subheader.getText(), "Subheader text does not match");

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        loginButton.click();

        WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        WebElement contentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));

        assertTrue(flashMessage.getText().contains("You logged into a secure area!"));
        assertTrue(contentMessage.getText().contains("Welcome to the Secure Area. When you are done click logout below."));
        assertNotNull(driver.getTitle(), "Title is NULL");
        assertEquals("The Internet", driver.getTitle(), "Page title does not match");
        assertEquals("https://the-internet.herokuapp.com/secure", driver.getCurrentUrl(), "Incorrect URL");

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.button.secondary.radius")));
        logoutButton.click();

        long end = System.currentTimeMillis();
        System.out.println("Время логина (herokuapp): " + (end - start) + " мс");
    }

    private static void exampleLoginTest(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        long start = System.currentTimeMillis();
        driver.get("https://rozetka.com.ua");

        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.search-form__submit")));
        assertEquals(" Знайти ", submitButton.getText(), "Wrong Submit button text (text does not match)");

         //Здесь можно добавить базовую проверку наличия элементов
        assertTrue(driver.getTitle().contains("Інтернет-магазин ROZETKA™: офіційний сайт онлайн-гіпермаркету Розетка в Україні"));
        assertTrue(driver.getCurrentUrl().contains("https://rozetka.com.ua/"));
        assertNotNull(driver.getTitle(), "Title is NULL");
        assertEquals("Інтернет-магазин ROZETKA™: офіційний сайт онлайн-гіпермаркету Розетка в Україні",
                driver.getTitle(), "Page title does not match");
        assertEquals("https://rozetka.com.ua/", driver.getCurrentUrl(), "Incorrect URL");

        long end = System.currentTimeMillis();
        System.out.println("Время загрузки rozetka.com.ua: " + (end - start) + " мс");
    }

    private static void googleLoginTest(WebDriver driver) {
        long start = System.currentTimeMillis();
        driver.get("https://www.google.com");

        //Проверяем наличие логотипа Google
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Google']")));

        assertTrue(driver.getTitle().toLowerCase().contains("google"));

        long end = System.currentTimeMillis();
        System.out.println("Время загрузки google.com: " + (end - start) + " мс");
    }
}