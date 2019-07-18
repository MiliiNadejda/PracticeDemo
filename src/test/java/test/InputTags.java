package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InputTags {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.openxcell.com/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElements(By.xpath("//body//input"));
        System.out.println(list.size());
        //List<WebElement> list1 = driver.findElements(By.xpath("//body//input"));
        for (WebElement l :list) {
            System.out.println(l.getAttribute("type"));

        }
    }
}
