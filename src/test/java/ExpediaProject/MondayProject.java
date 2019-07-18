package ExpediaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MondayProject {
    static WebDriver driver;
    static BaseClass sf;
    @BeforeClass
    public void setDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sf = new BaseClass(driver);

    }
        @BeforeMethod
        public void Navigate(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://expedia.com");

    }
    @Test
    public void ScheduleTrip()  {
        sf.Flight().click();
        sf.OneWay().click();
        sf.From().sendKeys("    chi");
        sf.From().sendKeys(Keys.DOWN, Keys.ENTER);

        sf.To().sendKeys("   atl");
        sf.To().sendKeys(Keys.DOWN, Keys.ENTER);


        sf.Departing().click();

        //Checking if i can choose a date  months in advance
        while (!driver.findElement(By.xpath("//div[@class='datepicker-cal-month']")).
                findElement(By.cssSelector(".datepicker-cal-month-header")).getText().contains("Mar")){
            driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();

        }

        driver.findElement(By.cssSelector("[data-day='12']")).click();
        driver.findElement(By.xpath("(//button[@class='btn-primary btn-action gcw-submit'])[1]")).click();


        boolean check = driver.findElement(By.cssSelector(".title-city-text")).getText().contains("Select your departure to");

        Assert.assertTrue(check, "Verification of selecting flight in advance FAILED");
    }

    @Test
public void CustomerService(){
        sf.Support().click();
        //clicking on customer service button from dropdown
        sf.CustomerService().click();
        //Checking if the result contains my input
        WebElement searchCS = driver.findElement(By.id("search-term"));
        String question = "Cancel my flight";
        if (searchCS.isDisplayed()) {
            searchCS.sendKeys(question + Keys.ENTER);
        } else {
            System.out.println("Verification of search customer service failed");
        }
        List<WebElement> listResults = driver.findElements(By.cssSelector("#article-list-container-- li"));

        boolean check = false;
        String[] words = question.split(" ");
        for (WebElement l : listResults) {
            for (String w : words) {
                if (l.getText().contains(w)) {
                    check = true;
                }
            }
        }
        Assert.assertTrue(check,"Verification for result customer support failed");

    }

    @Test(priority = 1)
    public void DropDownMenu()throws InterruptedException{
        sf.HotelButton().click();
        Thread.sleep(2000);
        sf.SearchButtonHotel().sendKeys("Chicago");
        //Checking if all sugestions contain the input
        List<WebElement> listOptions = driver.findElements(By.cssSelector("#typeaheadDataPlain a"));
        boolean check = true;
        for (WebElement w : listOptions) {
            if(!w.getAttribute("data-value").contains("Chicago")){
                check = false;

            }
        }
        Assert.assertTrue(check,"Verification of dropdown auto-suggest FAILED");


    }

    @AfterClass
    public void CloseTab(){
        driver.quit();
    }

}



