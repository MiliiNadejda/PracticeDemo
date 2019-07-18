package ExpediaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomerService {

    public static void main(String[] args) {
        // Scenario2: I want to be able to get customer support.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
        BaseClass bc = new BaseClass(driver);
        //clicking on suport button
        bc.Support().click();
        //clicking on customer service button from dropdown
        bc.CustomerService().click();
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
        if (check) {
            System.out.println("Verification for result customer support passed");
        } else {
            System.out.println("Verification for result customer support failed");
        }



    }
}
