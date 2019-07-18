package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class LoginPages {
    WebDriver driver;
    public LoginPages(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "txtUsername")
    public WebElement usernameInput;
    @FindBy(id = "txtPassword")
    public WebElement passwordInput;
    @FindBy(id = "btnLogin")
    public WebElement loginButton;

  public void Login(String username, String password){
      usernameInput.sendKeys(username);
      passwordInput.sendKeys(password);
      loginButton.click();
  }

}
