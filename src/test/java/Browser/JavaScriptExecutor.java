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
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://novaposhta.ua");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            JavascriptExecutor js = (JavascriptExecutor) driver;

            scrollPageDown(js);
            selectCountry(js, driver);
            scrollPageUp(js);
            fillSearchField(js, driver);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void scrollPageDown(JavascriptExecutor js) throws InterruptedException {
        js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
        Thread.sleep(1000);
    }
    public static void scrollPageUp(JavascriptExecutor js) throws InterruptedException {
        js.executeScript("window.scrollBy(0, -document.body.scrollHeight);");
        Thread.sleep(1000);
    }

    public static void fillSearchField(JavascriptExecutor js, WebDriver driver) throws InterruptedException {
        WebElement search = driver.findElement(By.cssSelector("#main-page-search > div.np-input.w-full.h-full > label > div > input"));
        js.executeScript("arguments[0].style.border='3px solid blue'", search);
        js.executeScript(
                "arguments[0].value='333-1527-1878';" +
                        "arguments[0].dispatchEvent(new Event('input'));" +
                        "arguments[0].dispatchEvent(new Event('change'));",
                search
        );
        Thread.sleep(2000);
        WebElement findButton = driver.findElement(By.cssSelector("#__nuxt > div > main > div > section > div >" +
                " div.relative.z-1.h-full.app-container.flex.items-center > div > div.mt-10.flex.gap-3.l-lg-mid\\:flex-col > button"));
        js.executeScript("arguments[0].style.border='3px solid green'", findButton);
        Thread.sleep(2000);
        findButton.click();
        Thread.sleep(5000);
    }

    public static void selectCountry(JavascriptExecutor js, WebDriver driver) throws InterruptedException {
        WebElement button = driver.findElement(By.cssSelector("#app-footer > div > div:nth-child(2) > " +
                "div.flex.justify-between.items-center.l-xl\\:items-start.mt-10.gap-7.l-lg\\:flex-col-reverse.l-lg\\:" +
                "items-start > div.flex.gap-8.items-center.l-md\\:flex-col.l-md\\:items-start > div > button"));
        js.executeScript("arguments[0].style.border='3px solid blue'", button);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", button);
        Thread.sleep(2000);

        WebElement close = driver.findElement(By.cssSelector("#app-footer > div > div:nth-child(2) > div.flex." +
                "justify-between.items-center.l-xl\\:items-start.mt-10.gap-7.l-lg\\:flex-col-reverse.l-lg\\:items-start " +
                "> div.flex.gap-8.items-center.l-md\\:flex-col.l-md\\:items-start > div > div > " +
                "div > div.modal-content-wrapper.relative.z-10.max-h-\\[100\\%\\].h-full.max-w-\\[100vw\\].w-full." +
                "flex.justify-center.pointer-events-none > div > div > div.absolute.right-\\[1\\.65rem\\].top-\\[1\\." +
                "35rem\\].l-md\\:right-\\[0\\.8rem\\].l-md\\:top-\\[1\\.22rem\\] > button"));
        js.executeScript("arguments[0].style.border='3px solid blue'", close);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", close);
        Thread.sleep(2000);
    }
}

