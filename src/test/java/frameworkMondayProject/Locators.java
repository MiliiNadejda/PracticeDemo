package frameworkMondayProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Locators {
    WebDriver driver;
    public Locators(){
        driver = Driver.getDriver();
        PageFactory.initElements(Driver.getDriver(), this);

    }

    public Locators(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(id = "login")
    public WebElement Username;


    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(css = ".btn.btn-primary")
    public WebElement LoginButton;

    @FindBy(linkText = "Manufacturing")
    public WebElement ManufactoringButton;

    @FindBy(linkText = "Bills of Materials")
    public WebElement BillOfMaterials;

    @FindBy(css = ".btn.btn-primary.btn-sm.o_list_button_add")
    public WebElement CreateButton;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement SaveButton;

    @FindBy(xpath = "//span[.='ManufacturingManager']")
    public WebElement UserText;


    @FindBy(xpath = "//ol[@class='breadcrumb']//li")
    public WebElement ManufOrderDispayed;

    @FindBy(css = ".o_form_sheet")
    public WebElement WindowDisplay;







}
