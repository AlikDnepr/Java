package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Iimelight {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            getAdministrationPage(js,driver);
            getCheckBoxes(driver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
    public static void getAdministrationPage(JavascriptExecutor js, WebDriver driver) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demo42-qa.limelightnow.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > " +
                "div.auth-wrapper > div.auth-content > div > div.form-content > div.input-wrapper.undefined >" +
                " div > span > input")));
        js.executeScript("arguments[0].style.border='3px solid red'", usernameField);
        Thread.sleep(1000);
        usernameField.sendKeys("servicesteam@golimelight.com");
        Thread.sleep(1000);
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > " +
                "div.auth-wrapper > div.auth-content >" +
                " div > div.form-content > div.button-container.undefined > button")));
        js.executeScript("arguments[0].style.border='3px solid blue'", submitButton);
        Thread.sleep(1000);
        submitButton.click();
        Thread.sleep(1000);
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root" +
                " > div.auth-wrapper > div.auth-content > div > div.form-content > " +
                "div.password-container > div > div > span.focus-area > input")));
        js.executeScript("arguments[0].style.border='3px solid red'", passwordField);
        Thread.sleep(1000);
        passwordField.sendKeys("Al9$iAZ8D5s5A$2I");
        WebElement logInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > " +
                "div.auth-wrapper > div.auth-content > " +
                "div > div.form-content > div.button-container.undefined > button")));
        js.executeScript("arguments[0].style.border='3px solid blue'", logInButton);
        Thread.sleep(1000);
        logInButton.click();
        Thread.sleep(1000);
        WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#navbarSupportedContent" +
                " > div.d-flex.align-items-center.gap-3.me-3 > div > a.dropdown-item.cursor-pointer.h-fit-content.w-fit-content > svg")));
        js.executeScript("arguments[0].style.border='3px solid green'", account);
        account.click();
        Thread.sleep(1000);
        WebElement administration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#navbarSupportedContent " +
                "> div.d-flex.align-items-center.gap-3.me-3 > div > div:nth-child(4) > ul > li:nth-child(4) > a")));
        js.executeScript("arguments[0].style.border='3px solid blue'", administration);
        administration.click();
        Thread.sleep(5000);
    }
    public static void getCheckBoxes(WebDriver driver) {
        WebElement[] checkboxes = new WebElement[driver.findElements(By.cssSelector("input[data-ll='default-checkbox-input']")).size()];
        System.out.println("Найдено чекбоксов: " + checkboxes.length);
        for (WebElement checkbox : checkboxes) {
            WebElement row = checkbox.findElement(By.xpath("./ancestor::tr"));
            String id = row.getAttribute("data-item-id");
            System.out.println("Checkbox с id: " + id);
        }

    }
}
