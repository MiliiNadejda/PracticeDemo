package testingTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTask {
     WebDriver driver;

    @BeforeClass
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
//        Assert.assertTrue(username.isDisplayed() || username.isEnabled(), "Username was not displayed");
//        Assert.assertTrue(password.isDisplayed() || password.isEnabled(), "Password was not displayed");
//        Assert.assertTrue(login.isDisplayed() || login.isEnabled(), "Login buttton was not displayed");
        username.sendKeys("Tester");
        password.sendKeys("test");
        login.click();


    }


    public static  void Login(WebDriver driver){
         WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
         WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
         WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
         Assert.assertTrue(username.isDisplayed()||username.isEnabled(), "Username was not displayed");
         Assert.assertTrue(password.isDisplayed()||password.isEnabled(), "Password was not displayed");
         Assert.assertTrue(login.isDisplayed()||login.isEnabled(), "Login buttton was not displayed");
         username.sendKeys("Tester");
         password.sendKeys("test");
         login.click();

     }
     @Test
    public void checkSelectBoxes() {
         WebElement checkAllButton = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
         checkAllButton.click();
         List<WebElement> list = driver.findElements(By.xpath("//table[@class='SampleTable']//tr/td[1]/input"));
         for (WebElement l : list) {
             Assert.assertTrue(l.isSelected(), "Verification checkboxes failed");
         }
     }
     @Test
             public void deleteSelected(){

         WebElement deleteAll = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
         deleteAll.click();
         WebElement message = driver.findElement(By.id("ctl00_MainContent_orderMessage"));
         Assert.assertTrue(message.isDisplayed());
         Assert.assertTrue(message.getText().equals("List of orders is empty. In order to add new order use this link."));
     }
    @Test(priority = 1)
    public void setCheck() {

        WebElement table = driver.findElement(By.cssSelector(".SampleTable "));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));

        for (int i = 1; i < listOfRows.size(); i++) {
            List<WebElement> listOfColumns = listOfRows.get(i).findElements(By.tagName("td"));
            if (listOfColumns.get(1).getText().equals("Mark Smith")) {
                listOfColumns.get(0).click();
                break;
            }
        }
        WebElement delete = driver.findElement(By.cssSelector("[name='ctl00$MainContent$btnDelete']"));
        delete.click();
        boolean check = true;
        List<WebElement> names = driver.findElements(By.xpath("//table[@class='SampleTable']//tr//td[2]"));
        for (WebElement w : names) {
            if (w.getText().equals("Mark Smith")) {
                check = false;
            }
        }
        Assert.assertTrue(check, "Mark Smith was not deleted");
    }

    @Test(priority = 2)
    public void editName() {
        WebElement table = driver.findElement(By.cssSelector(".SampleTable"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
        for (int i = 1; i < listOfRows.size(); i++) {
            List<WebElement> listOfColumns = listOfRows.get(i).findElements(By.tagName("td"));
            if(listOfColumns.get(1).getText().equals("Steve Johns")){
                listOfColumns.get(12).click();
                break;
                }
            }
        }
        @Test(priority = 3)
    public void changeName(){
        WebElement name = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
        name.clear();
        name.sendKeys("Michael Jordan");
        WebElement update = driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));
        update.click();
        List<WebElement> names = driver.findElements(By.xpath("//table[@class='SampleTable']//tr//td[2]"));
        boolean check = false;
            for (WebElement w : names) {
                if (w.getText().equals("Michael Jordan")) {
                    check = true;
                }
            }
            Assert.assertTrue(check, "Steve Johns was not edited");

        }
        }




