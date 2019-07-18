package ExpediaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class WindowHandlesPractice {
    WebDriver driver;
    @BeforeClass
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void openLink(){
        WebElement mw = driver.findElement(By.linkText("Multiple Windows"));
        mw.click();
        String mainHandle = driver.getWindowHandle();
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        link.click();
        //driver getWindowHandles()  => returns Set<String>
        for(String handle: driver.getWindowHandles()){
            if(!handle.equals(mainHandle)){
                driver.switchTo().window(handle);
                break;
            }
        }


    }

}
