package UdemyPractice;

import com.github.javafaker.App;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchingWindows  {


      @Test
    public void switchWindows(){
          Driver.getDriver().get("https://www.apple.com/");

          String rightClick = Keys.chord(Keys.COMMAND, Keys.ENTER);
          List<WebElement> appleDirectory = Driver.getDriver().findElements(By.xpath("(//div[@class='ac-gf-directory-column-section'])[2]//li/a"));
          for (WebElement l: appleDirectory){
              l.sendKeys(rightClick);
          }

          Set<String> windows = Driver.getDriver().getWindowHandles();
          Iterator<String> it = windows.iterator();
          while(it.hasNext()){
              Driver.getDriver().switchTo().window(it.next());
              System.out.println(Driver.getDriver().getTitle());

          }

        }


        }



