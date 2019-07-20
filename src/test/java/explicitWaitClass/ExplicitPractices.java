package explicitWaitClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class ExplicitPractices {
    @Test
    public void waitingExplicitly(){
        WebElement googleSearch = Driver.getDriver().findElement(By.name("q"));

    }
}
