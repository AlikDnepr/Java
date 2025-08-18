package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
    @Test
    public void BrowserTests() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver chrome = new ChromeDriver();
// Переходим на первую страницу "https://the-internet.herokuapp.com/login" с помощью get()
// Метод get() загружает указанную страницу и очищает состояние браузера (например, cookies, историю), если это нужно
        chrome.get("https://the-internet.herokuapp.com/login");
        Thread.sleep(8000);
// Переходим на следующую страницу "https://www.browserstack.com/" с помощью navigate().to()
// Метод navigate().to() добавляет текущую страницу в историю браузера перед переходом на новую страницу
        chrome.navigate().to("https://www.browserstack.com/");
        Thread.sleep(8000);
// Возвращаемся обратно на предыдущую страницу с помощью метода navigate().back()
// Этот метод работает, если переход выполнялся через navigate().to(), так как сохраняется история
// В данном случае мы вернемся к "https://the-internet.herokuapp.com/login".
        chrome.navigate().back();
        Thread.sleep(8000);
// Вперед по истории на следующую страницу с помощью метода navigate().forward()
// Работает, если ранее был вызван navigate().back()
// Мы снова переходим на "https://www.browserstack.com/"
        chrome.navigate().forward();
        Thread.sleep(8000);
        chrome.quit();
    }
}
