package ExpediaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ScheduleFlights {
    public static void main(String[] args) throws InterruptedException {

        // Scenario: I want to be able to schedule my flights eight months in advance

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
        BaseClass sf = new BaseClass(driver);
        sf.Flight().click();
        sf.OneWay().click();
        sf.From().sendKeys("chi");
        sf.From().sendKeys(Keys.DOWN, Keys.ENTER);

        sf.To().sendKeys("atl");
        sf.To().sendKeys(Keys.DOWN, Keys.ENTER);


          sf.Departing().click();

          //Checking if i can choose a date  months in advance
        while (!driver.findElement(By.xpath("//div[@class='datepicker-cal-month']")).
                findElement(By.cssSelector(".datepicker-cal-month-header")).getText().contains("Mar")){
           driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();
           Thread.sleep(1000);
        }

            driver.findElement(By.cssSelector("[data-day='12']")).click();
                driver.findElement(By.xpath("(//button[@class='btn-primary btn-action gcw-submit'])[1]")).click();

                boolean check = driver.findElement(By.cssSelector(".title-city-text")).getText().contains("Select your departure to");

        }
    }
