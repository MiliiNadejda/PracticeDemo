package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPages;
import utilities.Driver;
import utilities.Config;

import java.nio.channels.SelectableChannel;
import java.util.List;


public class OrangeCrm {

    @Ignore
    @Test
    public void login(){
        Driver.getDriver().get(Config.getProperties("url2"));

    }
    @Ignore
    @Test

public void orangeLoginVerification(){
        Driver.getDriver().get(Config.getProperties("url2"));
        LoginPages olp = new LoginPages();
        olp.Login("Admin", "admin123");
//        olp.usernameInput.sendKeys("Admin");
//        olp.passwordInput.sendKeys("admin123");
//        olp.loginButton.click();
        HomePage hp = new HomePage();
        Assert.assertTrue(hp.welcomeText.isDisplayed());


    }

    @Test
    public void verifyCEO()throws InterruptedException{
        Driver.getDriver().get(Config.getProperties("url2"));
        LoginPages login = new LoginPages();
        login.Login("Admin", "admin123");
        HomePage homePage = new HomePage();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homePage.performance).perform();
        Thread.sleep(2000);
        actions.moveToElement(homePage.configure).perform();
        Thread.sleep(2000);
        actions.moveToElement(homePage.kpi).perform();
        Thread.sleep(2000);
        actions.click().perform();
        Thread.sleep(2000);
        Select select = new Select(homePage.jobTitleDropDown);
        List<WebElement> options = select.getOptions();
        boolean found = false;
        for(WebElement option: options){
            if(option.getText().equals("CEO")){
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);

    }
}
