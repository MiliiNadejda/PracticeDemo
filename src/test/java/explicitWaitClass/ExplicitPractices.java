package explicitWaitClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.Driver;

public class ExplicitPractices {
    @Test
    public void waitingExplicitly(){
        WebElement googleSearch = Driver.getDriver().findElement(By.name("q"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement googleWait = wait.until(ExpectedConditions.visibilityOf(googleSearch));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath")));
        googleWait.sendKeys("search for something ");
    }
}
