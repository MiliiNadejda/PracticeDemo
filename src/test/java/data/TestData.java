package data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestData {

    @Test
    public void m()  {
        //Config.getProperties("url");
        Driver.getDriver().get(Config.getProperties("url"));
        WebElement search = Driver.getDriver().findElement(By.name("q"));

    }
    public void search(String word){

    }

}
