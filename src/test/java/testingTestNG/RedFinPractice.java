package testingTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedFinPractice {
    WebDriver driver;
    @BeforeClass
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.redfin.com");
    }
    @Test(priority = 1)
    public void search(){
        WebElement searchButton = driver.findElement(By.xpath("(//input[@type='search'])[1]"));
        searchButton.sendKeys("Naperville");
        driver.findElement(By.xpath("(//button[@class='inline-block SearchButton clickable float-right'])[1]")).click();

    }
    @Test(priority = 2)
    public void selectPrice(){
        WebElement selectMin = driver.findElement(By.cssSelector(".quickMinPrice.withFlyout.withOptions.mounted.selected.field.select.Select.clickable.optional"));
        selectMin.click();
        List<WebElement> prices = driver.findElements(By.cssSelector(".flyout div"));
        for (WebElement l: prices){
            System.out.println(l.getText());
                l.click();

            }
        }

    @Test(priority = 3)
    public void selectMax(){
        WebElement selectMax = driver.findElement(By.cssSelector(".quickMaxPrice.withFlyout.withOptions.mounted.selected.field.select.Select.clickable.optional"));
        selectMax.click();
        List<WebElement> prices = driver.findElements(By.cssSelector(".flyout div"));
        for (WebElement l: prices){
            if(l.getText().equals("$175k")){
                l.click();
                break;
            }
        }
    }
    @Test(priority = 4)
    public void heckUrl() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("50k"), "50k doesnt exist");
        Assert.assertTrue(driver.getCurrentUrl().contains("175k"), " 175k doesnt exist");

    }

}
