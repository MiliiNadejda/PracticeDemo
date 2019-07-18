package ExpediaProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindowsPractice extends TestBase {


    @Test(priority = 1)
    public void multipleWindows() {
        driver.get("http://practice.cybertekschool.com/windows");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://amazon.com','_blank');");



        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while(it.hasNext()){
            if(driver.getTitle().equals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone")){
                System.out.println(driver.getTitle());
            break;

            }else{
                driver.switchTo().window(it.next());
            }
        }


    }
}
