package test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SmartBearOrderPlacing {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        LogInMethod.logInToSmartBear(driver);
        WebElement orders = driver.findElement(By.linkText("Order"));
        orders.click();
        WebElement selectProduct = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select select = new Select(selectProduct);
        select.selectByVisibleText("FamilyAlbum");
        WebElement input = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        input.clear();
        input.sendKeys("2");
        WebElement contactName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement street = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement city = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement state = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        Faker faker = new Faker();
        contactName.sendKeys(faker.name().fullName());
        System.out.println();
        street.sendKeys(faker.address().streetAddress());
        city.sendKeys(faker.address().cityName());
        state.sendKeys(faker.address().state());
        zip.sendKeys(faker.address().zipCode().replace("-", ""));
        WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioButton.click();
        WebElement cardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys(faker.finance().creditCard().replace("-", ""));
        WebElement expirationDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("10/19");
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        if(successMessage.getText().equals("New order has been successfully added.")){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }



    }
}
