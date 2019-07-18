package actionsClass;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;



public class HoveringOver {
    Actions actions;
//    @Test
//    public void amazonHover(){
//        Driver.getDriver().get("https://www.amazon.com");
//        WebElement signInLink = Driver.getDriver().findElement(By.id("nav-link-accountList"));
//        Actions actions = new Actions(Driver.getDriver());
//        actions.moveToElement(signInLink).perform();
//    }
    @Test
    public void hoverOver(){
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
WebElement firstPic = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
WebElement secondPic = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
WebElement thirdPic = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));

WebElement firstPicText = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
WebElement secondPicText = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
WebElement thirdPicText = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));



actions = new Actions(Driver.getDriver());
actions.moveToElement(firstPic).perform();
Assert.assertTrue(firstPicText.getText().contains("name: user1"));
actions.moveToElement(secondPic).perform();
Assert.assertTrue(secondPicText.getText().contains("name: user2"));
actions.moveToElement(thirdPic).perform();
Assert.assertTrue(thirdPicText.getText().contains("name: user3"));

    }
    @Test
    public void doubleClick() throws InterruptedException {
        Driver.getDriver().get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        WebElement puff = Driver.getDriver().findElement(By.id("puff_content"));
        actions = new Actions(Driver.getDriver());
        actions.doubleClick(puff).perform();
        Thread.sleep(1000);
        Assert.assertTrue(!puff.isDisplayed());

    }
    /*1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2.
    2.Switch	to	iframe.
    3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
    4.Assert:	Text’s	“style”attribute	value	contains	“red”.**/


    @Test
    public void Iframe (){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        WebElement frame = Driver.getDriver().findElement(By.id("iframeResult"));
        Driver.getDriver().switchTo().frame(frame);
        WebElement text = Driver.getDriver().findElement(By.xpath("//p[.='Double-click me to change my text color.']"));
        actions = new Actions(Driver.getDriver());
        actions.doubleClick(text).perform();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//p[.='Double-click me to change my text color.']")).getAttribute("style").contains("red"));


    }
    //Scrolling example
    @Test
    public void scrollUsingMoveTo(){
        Driver.getDriver().get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        WebElement footer = Driver.getDriver().findElement(By.className("footer-info-left"));
        actions = new Actions(Driver.getDriver());
        actions.doubleClick(footer).perform();

    }
    @Test
    public void scrollUsingKeys() throws InterruptedException{
        Driver.getDriver().get("https://www.youtube.com");


        Actions actions = new Actions(Driver.getDriver());
        // Sending Keys using object
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    @Test
    public void scrollUsingJSExecutor(){
        Driver.getDriver().get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,1000);");
    }

    @Test
    public void DragAndDrop(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement source = Driver.getDriver().findElement(By.xpath("//div[@id ='draggable']"));
        WebElement target = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(source,target).perform();
        Assert.assertTrue(target.getText().contains("You did great!"));
        WebElement acceptCookie = Driver.getDriver().findElement(By.cssSelector(".optanon-allow-all.accept-cookies-button"));
        acceptCookie.click();

    }
@Test
    public void uploadTest() throws InterruptedException {
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        WebElement chooseFileInput = Driver.getDriver().findElement(By.id("file-upload"));
        Thread.sleep(2000);
        chooseFileInput.sendKeys("/Users/nadejdamilii/Desktop/AWS Certified Cloud Practitioner certificate.pdf");
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement text = Driver.getDriver().findElement(By.id("uploaded-files"));

        Assert.assertTrue(text.getText().equals("AWS Certified Cloud Practitioner certificate.pdf"));

}
}
