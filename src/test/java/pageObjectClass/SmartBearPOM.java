package pageObjectClass;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginSmartBear;

import utilities.Config;
import utilities.Driver;

public class SmartBearPOM {
    public LoginSmartBear login;

   @BeforeMethod
    public void setUp(){
       Driver.getDriver().get(Config.getProperties("url"));
       login = new LoginSmartBear();
   }
   @AfterMethod
   public void Quit(){
       Driver.quitDriver();
   }
   @Test(priority = 1)
    public void loginWrongUsername() {

      login.Login("Admin", "test");

       Assert.assertTrue(login.message.isDisplayed());
   }
   @Test(priority = 2)
    public void loginWrongPassword()  {
       login.Login("Tester", "tester");

    Assert.assertTrue(login.message.isDisplayed());
   }

   @Test(priority = 3)
    public void noUsername(){
       login.Login("", "test");

       Assert.assertTrue(login.message.isDisplayed());
   }
   @Test(priority = 4)
    public void noPassword(){
       login.Login("Tester", "");

       Assert.assertTrue(login.message.isDisplayed());
   }
}
