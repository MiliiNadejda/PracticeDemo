package frameworkMondayProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Config;
import utilities.Driver;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;

public class userStory103 {
    SoftAssert soft;
    // go to the app
    @BeforeClass
    public void open(){
        Driver.getDriver().get(Config.getProperties("url"));
    }
    // input the right credentials
    @Test
    public void mytest() throws InterruptedException{
     Locators locators = new Locators();

     locators.Username.sendKeys(Config.getProperties("username"));
     locators.Password.sendKeys(Config.getProperties("password"));
     locators.LoginButton.submit();
     soft = new SoftAssert();
     soft.assertTrue(locators.UserText.getText().equals("ManufacturingManager"), "Login Verification Failed");
      //
     locators.ManufactoringButton.click();
        Thread.sleep(2000);
     soft.assertTrue(locators.ManufOrderDispayed.getText().contains("Manufacturing Orders"), "Manufacturing Button Verification Failed");
     locators.BillOfMaterials.click();
        Thread.sleep(2000);
        soft.assertTrue(locators.ManufOrderDispayed.getText().contains("Bills of Materials"), "Bills of Materials Button Verification Failed");
        //soft.assertTrue(locators.BillOfMaterials().isDisplayed(), "Bills of Materials Verification Failed");


     locators.CreateButton.click();
        Thread.sleep(2000);
     soft.assertTrue(locators.WindowDisplay.isDisplayed(), "Create button verification failed");
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@class='o_cp_left']// button"));
        for (WebElement w: list) {
            if(w.getText().equals("Save")){
                w.click();
                break;
            }

        }
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("(//td[@class='o_td_label']//label)[1]")).getAttribute("class").contains("invalid"), "Save button verification failed");

//        WebElement popUp = Driver.getDriver().findElement(By.cssSelector(".o_notification_manager"));
//        WebDriverWait d = new WebDriverWait( Driver.getDriver(), 10);
//        d.until(ExpectedConditions.visibilityOfElementLocated(By "popUp"));
        soft.assertAll();
    }
}
