package Browser;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FirstTest {
    @Test
    public void GoogleTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver"); //"/drivers/chromedriver/"
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua"); //Открывает страницу по указанному URL
        driver.getTitle(); //Возвращает заголовок текущей страницы
        driver.getCurrentUrl();	//Возвращает текущий URL
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getTitle().contains("Інтернет-магазин ROZETKA™: офіційний сайт онлайн-гіпермаркету Розетка в Україні"));
        driver.navigate().to("https://rozetka.com.ua");	//Перейти на другой URL (аналогично get())
        driver.navigate().back();	//Назад по истории браузера
        driver.navigate().forward();	//Вперёд по истории браузера
        driver.navigate().refresh();	//Обновить текущую страницу
        driver.quit(); // Закрытие драйвера в конце теста





    }
}