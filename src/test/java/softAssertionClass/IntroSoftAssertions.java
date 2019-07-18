package softAssertionClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IntroSoftAssertions {

    @Test
    public void test3 (){
        System.out.println("Test 3 is starting...");
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(4,5);
        System.out.println("Test 3 middle...");
        soft.assertTrue(false);
        System.out.println("Test 3 ending...");
        soft.assertAll();
    }

}
