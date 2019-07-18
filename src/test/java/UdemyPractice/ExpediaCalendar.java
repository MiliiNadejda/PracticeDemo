package UdemyPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExpediaCalendar  {

    @Test
    public void getDates(){
        Driver.getDriver().get("https://www.expedia.com/");
        WebElement flights = Driver.getDriver().findElement(By.id("tab-flight-tab-hp"));
        flights.click();
        WebElement oneWayButton = Driver.getDriver().findElement(By.id("flight-type-one-way-label-hp-flight"));
        oneWayButton.click();

        WebElement departingCalendar = Driver.getDriver().findElement(By.cssSelector("#flight-departing-single-hp-flight"));
        departingCalendar.click();
        List<WebElement> dates = Driver.getDriver().findElements(By.xpath("//tbody[@class='datepicker-cal-dates']//button[@class='datepicker-cal-date']"));
        List<WebElement> months = Driver.getDriver().findElements(By.cssSelector(".datepicker-cal-month-header"));
        System.out.println(dates.size());
        for (int i = 0; i <dates.size() ; i++) {
            if(months.get(0).getText().contains("Jul")){
                if(dates.get(i).getAttribute("data-day").equals("10")){
                    System.out.println(dates.get(i).getAttribute("data-day"));
                    dates.get(i).click();
                    break;
                }
            }
        }

        }
    }

