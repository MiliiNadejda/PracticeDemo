package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class LoginSmartBear {


    public LoginSmartBear(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameInput;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordInput;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement LoginButton;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement message;
    public void Login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        LoginButton.click();
    }
    public WebElement xPathByCLASS (String partXPath){
        String xpath = "//div[@class ='"+partXPath+"']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
}
