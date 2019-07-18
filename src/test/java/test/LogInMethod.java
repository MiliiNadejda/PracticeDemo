package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInMethod {

    static public void logInToSmartBear(WebDriver driver){

        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();


    }
}
