package testingTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alerts {
    WebDriver driver;

    @BeforeClass
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test(priority = 1)
    public void ClickAlerts() {
        WebElement warning = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        warning.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(message.getText().equals("You successfuly clicked an alert"));

    }

    @Test(priority = 2)
    public void ClickWarning() {

        WebElement confirmation = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmation.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(message.isDisplayed());
       Assert.assertTrue(message.getText().equals("You clicked: Ok"));

    }

    @Test(priority = 3)
    public void ClickPrompt() {

        WebElement prompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        prompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello");
        alert.accept();
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(message.getText().equals("You entered: Hello"));
    }
}