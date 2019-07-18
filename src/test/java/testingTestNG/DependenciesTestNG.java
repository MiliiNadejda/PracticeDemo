package testingTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTestNG {

    @Test
    public void login(){
        System.out.println("logging in ");
        Assert.fail();
    }

    @Test(dependsOnMethods = "login")
    public void makePurchase(){
        System.out.println("making purchase ");
    }

    @Test
    public void homePage(){
        System.out.println("homePage tested");
    }
}
