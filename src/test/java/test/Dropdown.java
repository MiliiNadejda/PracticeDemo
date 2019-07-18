package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.Config;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdown {

    @Test
    public void testing(){
        System.out.println(Config.getProperties("url"));
    }
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement month = driver.findElement(By.id("month"));
        Select monthDropodown = new Select(month);
        String s = monthDropodown.getFirstSelectedOption().getText();
        System.out.println(s);
        Thread.sleep(3000);
        monthDropodown.selectByIndex(1);
        Thread.sleep(3000);
        monthDropodown.selectByValue("8");
        Thread.sleep(3000);
        monthDropodown.selectByVisibleText("December");
        List<WebElement> months = monthDropodown.getOptions();
        for (WebElement mon: months) {
            System.out.println(mon.getText());

        }

    }
}
