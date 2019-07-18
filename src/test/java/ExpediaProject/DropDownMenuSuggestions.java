package ExpediaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownMenuSuggestions {
    public static void main(String[] args) {
        //I want to get suggestion when i start searching for a destination.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
        BaseClass sf = new BaseClass(driver);
        sf.HotelButton().click();
        sf.SearchButtonHotel().sendKeys("Chicago");
        //Checking if all sugestions contain the input
        List<WebElement> listOptions = driver.findElements(By.cssSelector("#typeaheadDataPlain a"));
        boolean check = true;
        for (WebElement w : listOptions) {
            if(!w.getAttribute("data-value").contains("Chicago")){
                check = false;
                System.out.println("Verification of dropdown auto-suggest FAILED");
            }
        }
        if(check){
            System.out.println("Verification of dropdown auto-suggest PASSED");

        }
    }

    }

