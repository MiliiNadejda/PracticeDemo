package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
        Select dropdownmenu = new Select(dropdown);
        String s = dropdownmenu.getFirstSelectedOption().getText();
        if(s.equals("All Departments")){
            System.out.println("Verifying default value passed");
        }else{
            System.out.println("Verifying default value failed");
        }
      //dropdown.click();
        List<WebElement> list = dropdownmenu.getOptions();
        if(list.size()==51){
            System.out.println("Number of option verification passed");
        }else{
            System.out.println("Number of option verification failed");
        }
        boolean check = false;
        for (WebElement m : list) {
            if(m.getText().isEmpty()){
               check = false;
            }else{
                check = true;
            }
        }
        if(check){
            System.out.println("Character verification passed");
        }else{
            System.out.println("Character verification failed");
        }
      dropdownmenu.selectByVisibleText("Courses");
        if(dropdownmenu.getFirstSelectedOption().getText().equals("Courses")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }
}
