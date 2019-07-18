package testingTestNG;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TestNgFirstTest {
      @BeforeClass
      public void setUp(){
          System.out.println("Before test running");
      }
      @AfterClass
      public void tearDown(){
          System.out.println("Tearing down something");
      }
      @BeforeMethod
      public void beforeMethod(){
          System.out.println("Before method running");
      }
      @AfterMethod
      public void afterMethod(){
          System.out.println("After method running");
      }

        @Test
        public void firstTest(){
          System.out.println("This is the first test running");
          Assert.assertEquals("a", "a", "first test a-b is failed");

        }
@Test
public void titleTest(){
          String actualTitle = "Google - Apples";
          String expectedResult = "apples";
          Assert.assertTrue(actualTitle.contains(expectedResult), "Actual title does not contain the expected value");
}

        @Test
    public void secondTest(){
            System.out.println("This is the second test running");
        }
    @Test
    public void onPurposeFail(){
          fail("On purpose fail");

    }
    }


