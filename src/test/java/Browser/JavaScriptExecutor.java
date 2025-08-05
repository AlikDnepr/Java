package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavaScriptExecutor {
    public static void main(String[] args) {
        // WebDriver settings
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open page
            driver.get("https://novaposhta.ua");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 10000);"); // Scroll 10k pixels

            Thread.sleep(2000);

            // The CSS selector is selected, which will be used to press the button
            WebElement button = driver.findElement(By.cssSelector("#app-footer > div > div:nth-child(2) > div.flex.justify-between.items-center.l-xl\\:items-start.mt-10.gap-7.l-lg\\:flex-col-reverse.l-lg\\:items-start > div.flex.gap-8.items-center.l-md\\:flex-col.l-md\\:items-start > div > button")); // змінити селектор під потрібну кнопку
            js.executeScript("arguments[0].click();", button);

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
