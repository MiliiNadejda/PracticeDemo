package ExpediaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class ActionClassPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        driver.get("https://amazon.com");
        Actions action = new Actions(driver);
        WebElement AccountList = driver.findElement(By.cssSelector("#nav-link-accountList"));
        action.moveToElement(AccountList).build().perform();
        WebElement search = driver.findElement(By.cssSelector(".nav-search-field input"));
        action.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("spoons").keyDown(Keys.ENTER).build().perform();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

//        while (it.hasNext()){
//            driver.switchTo().window(it.next())
//        }
        String first = it.next();
        String second = it.next();

        driver.switchTo().window(second);

        String rightClick = Keys.chord(Keys.COMMAND, Keys.ENTER);
        driver.findElement(By.id("daf")).sendKeys(rightClick);

    }
}
