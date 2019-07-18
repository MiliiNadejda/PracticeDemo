package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    WebDriver driver;
    public HomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(id = "welcome")
    public WebElement welcomeText;

    @FindBy(id = "menu_Performance")
    public WebElement performance;

    @FindBy(id = "menu_performance_Configure")
    public WebElement configure;

    @FindBy(id = "menu_performance_searchKpi")
    public WebElement kpi;

    @FindBy(id = "kpi360SearchForm_jobTitleCode")
    public WebElement jobTitleDropDown;

}
